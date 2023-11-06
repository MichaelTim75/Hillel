package edu.hillel.lesson25;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@ToString
public class ClientInfo {

    private String name;

    private LocalDateTime connectTimestamp;

    private Socket clientSocket;

    private PrintWriter outWriter;
}
