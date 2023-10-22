package edu.hillel.lesson21;

import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@AllArgsConstructor
public class DataBaseConnection {
    private final static String USER_NAME ="api_user";
    private final static String PASSWORD = "password";
    private final static String URL="jdbc:postgresql://localhost:58001/test";

    protected Connection getConnection(){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            return DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    protected void closeConnection(Connection connection){
        try{
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
