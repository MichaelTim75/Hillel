package edu.hillel.lesson25;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ServerTest {

    @Test
    public void getNewClientNameEmptyList() {
        List<ClientInfo> clients = new CopyOnWriteArrayList<>();
        Server server = new Server();
        String newClientName = server.getNewClientName(clients);

        Assert.assertEquals("client-1", newClientName);
    }

    @Test
    public void getNewClientNameNonEmptyList() {
        List<ClientInfo> clients = new CopyOnWriteArrayList<>();
        clients.add(new ClientInfo("client-1", LocalDateTime.now(), null, null));
        clients.add(new ClientInfo("client-2", LocalDateTime.now(), null, null));
        clients.add(new ClientInfo("client-3", LocalDateTime.now(), null, null));

        Server server = new Server();
        String newClientName = server.getNewClientName(clients);

        Assert.assertEquals("client-4", newClientName);
    }

    @Test
    public void testSendAllClients() {
        List<ClientInfo> clients = new CopyOnWriteArrayList<>();

        PrintWriter client1Writer = mock(PrintWriter.class);
        ClientInfo client1 = new ClientInfo("client-1", LocalDateTime.now(), null, client1Writer);
        clients.add(client1);

        PrintWriter client2Writer = mock(PrintWriter.class);
        ClientInfo client2 = new ClientInfo("client-2", LocalDateTime.now(), null, client2Writer);
        clients.add(client2);

        Server server = new Server();

        server.sendAllClients(clients, "[SERVER] client-2 successfully connected", "client-2");

        verify(client1Writer).println("[SERVER] client-2 successfully connected");
        verify(client2Writer, never()).println("[SERVER] client-2 successfully connected");
    }

    @Test
    public void receiveFileTest() throws IOException {
        InputStream inputStream = new ByteArrayInputStream("Some data".getBytes());

        Server server = new Server();

        File file = new File("client-1_test.txt");
        file.deleteOnExit();

        server.receiveFile("file test.txt", "client-1", inputStream);

        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String str = reader.readLine();

            Assert.assertEquals("Some data", str);
        }

        file.deleteOnExit();
    }

    @Test
    public void testHandleClientMessagesClientList() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new StringReader("client-list"));
        PrintWriter printWriter = mock(PrintWriter.class);
        Socket socket = mock(Socket.class);

        Server server = new Server();

        List<ClientInfo> clients = new CopyOnWriteArrayList<>();
        server.handleClientMessages(clients, bufferedReader, null, printWriter,socket);

        verify(printWriter, atLeastOnce()).println(anyString());

    }

    @Test
    public void testHandleClientMessagesExit() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new StringReader("exit"));
        PrintWriter printWriter = mock(PrintWriter.class);
        Socket socket = mock(Socket.class);

        Server server = new Server();

        List<ClientInfo> clients = new CopyOnWriteArrayList<>();
        ClientInfo clientInfo = new ClientInfo("client-1",LocalDateTime.now(),null,null);
        clients.add(clientInfo);
        server.handleClientMessages(clients, bufferedReader, clientInfo, printWriter,socket);

        Assert.assertEquals(0,clients.size());

    }

    @Test
    public void testHandleClientMessagesFile() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new StringReader("file test.txt"));
        PrintWriter printWriter = mock(PrintWriter.class);
        Socket socket = mock(Socket.class);
        when(socket.getInputStream()).thenReturn(new ByteArrayInputStream("Some data".getBytes()));

        Server server = new Server();

        List<ClientInfo> clients = new CopyOnWriteArrayList<>();

        ClientInfo clientInfo = new ClientInfo("client-1",LocalDateTime.now(),null,null);
        clients.add(clientInfo);

        File file = new File("client-1_test.txt");
        file.deleteOnExit();

        server.handleClientMessages(clients, bufferedReader, clientInfo, printWriter,socket);

        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String str = reader.readLine();

            Assert.assertEquals("Some data", str);
        }

        file.deleteOnExit();

    }

}