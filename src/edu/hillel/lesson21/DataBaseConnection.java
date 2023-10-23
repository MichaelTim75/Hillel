package edu.hillel.lesson21;

import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataBaseConnection implements AutoCloseable {
    private final static String USER_NAME = "api_user";
    private final static String PASSWORD = "password";
    private final static String URL = "jdbc:postgresql://localhost:58001/test";

    private final List<Connection> connections;

    public DataBaseConnection() {
        connections = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    protected Connection getConnection() {
        Connection connection;
        try {
            connection =DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            connections.add(connection);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    protected void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() throws Exception {
        connections.forEach(this::closeConnection);
    }
}
