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

    private final Connection connection;

    public DataBaseConnection() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            connection =DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    protected Connection getConnection() {
        return connection;
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
        connection.close();
    }
}
