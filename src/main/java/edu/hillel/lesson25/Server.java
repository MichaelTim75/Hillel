package edu.hillel.lesson25;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class Server {
    private final static int PORT = 1111;

    private volatile List<ClientInfo> clients;


    public static void main(String[] args) throws IOException {
        new Server().start();
    }

    public Server() {
        clients = new CopyOnWriteArrayList<>();
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                final Socket accept = serverSocket.accept();

                new Thread(() -> {

                    String newClientName = getNewClientName(clients);

                    try (BufferedReader bufferedReader = new BufferedReader((new InputStreamReader(accept.getInputStream())));
                         PrintWriter outWriter = new PrintWriter(accept.getOutputStream(), true)) {
                        ClientInfo clientInfo = new ClientInfo(newClientName, LocalDateTime.now(), accept, outWriter);

                        clients.add(clientInfo);

                        sendAllClients(clients, "[SERVER] " + newClientName + " successfully connected", newClientName);

                        handleClientMessages(clients,bufferedReader, clientInfo, outWriter,accept);

                    } catch (SocketException e) {
                        clients.removeIf(c -> newClientName.equals(c.getName()));
                        System.out.println("Client " + newClientName + " disconnected");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }).start();

            }
        }
    }

    void handleClientMessages(List<ClientInfo> clients, BufferedReader bufferedReader, ClientInfo clientInfo, PrintWriter outWriter,Socket accept) throws IOException {
        String message;

        while ((message = bufferedReader.readLine()) != null) {
            if ("exit".equals(message)) {
                clients.remove(clientInfo);
                break;
            } else if ("client-list".equals(message)) {
                String clientList = clients.stream()
                        .map(ClientInfo::getName)
                        .toList()
                        .toString();
                outWriter.println("Client list is: " + clientList);
            } else if (message.startsWith("file ")) {
                receiveFile(message, clientInfo.getName(), accept.getInputStream());
            }
        }
    }

    void receiveFile(String message, String clientName, InputStream inputStream) throws IOException {
        String fileName = clientName + "_" + (message.substring(message.lastIndexOf(' ') + 1)).trim();
        File file = new File(fileName);
        int countBytes;
        byte[] bufferBytes = new byte[8192];
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file))) {
            while ((countBytes = inputStream.read(bufferBytes)) >= 0) {
                bufferedOutputStream.write(bufferBytes, 0, countBytes);
            }
        }
    }

    String getNewClientName(List<ClientInfo> clients) {
        int maxNumber = clients.stream()
                .map(ClientInfo::getName)
                .map(str -> Integer.parseInt(str.substring(str.lastIndexOf('-') + 1)))
                .max(Integer::compare)
                .orElse(0);

        return "client-" + (maxNumber + 1);
    }

    void sendAllClients(List<ClientInfo> clients, String message, String fromClient) {
        clients.stream()
                .filter(c -> !fromClient.equals(c.getName()))
                .forEach(c -> {
                    System.out.println("sending to " + c.getName());
                    c.getOutWriter().println(message);
                });
    }

}
