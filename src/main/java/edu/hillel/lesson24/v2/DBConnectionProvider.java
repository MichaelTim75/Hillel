package edu.hillel.lesson24.v2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionProvider implements AutoCloseable {

    private static final String USER_NAME = "api_user";
    private static final String PASSWORD = "password";
    private static final String URL = "jdbc:postgresql://localhost:58001/test";

    private final Connection connection;
    private final DataDAO dataDAO;

    public DBConnectionProvider() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        dataDAO = new DataDAO(connection);

    }

    public DataDAO getDataDAO() {
        return dataDAO;
    }

    @Override
    public void close() throws Exception {
        connection.close();
    }
}
