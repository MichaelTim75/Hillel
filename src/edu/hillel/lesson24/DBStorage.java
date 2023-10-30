package edu.hillel.lesson24;

import edu.hillel.lesson21.dao.HomeworkDAO;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBStorage implements Storage, AutoCloseable {

    private static final String USER_NAME = "api_user";
    private static final String PASSWORD = "password";
    private static final String URL = "jdbc:postgresql://localhost:58001/test";

    private final Connection connection;
    private final DataDAO dataDAO;

    @SneakyThrows({SQLException.class, ClassNotFoundException.class})
    public DBStorage() {
        Class.forName("org.postgresql.Driver");

        connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        dataDAO = new DataDAO(connection);
    }

    @Override
    public void saveData(List<String> data) {
        dataDAO.addData(data);
    }

    @Override
    public List<String> getData() {
        return dataDAO.getData();
    }

    @Override
    public void clearData() {
        dataDAO.clearData();
    }

    @Override
    public void close() throws Exception {
        connection.close();
    }
}
