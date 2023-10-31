package edu.hillel.lesson24.v2;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataDAO {
    private final Connection connection;

    public DataDAO(Connection connection) {
        this.connection = connection;
    }

    @SneakyThrows(SQLException.class)
    public int[] addData(List<String> data) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("insert into hillel.data(data) values (?)")) {
            for (String c : data) {
                preparedStatement.setString(1, c);
                preparedStatement.addBatch();
            }
            return preparedStatement.executeBatch();
        }
    }

    @SneakyThrows(SQLException.class)
    public List<String> getData() {
        List<String> data = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery("select data from hillel.data")) {
                while (resultSet.next()) {
                    data.add(resultSet.getString("data"));
                }
            }
        }
        return data;
    }

    @SneakyThrows(SQLException.class)
    public int clearData() {
        try (PreparedStatement preparedStatement = connection.prepareStatement("delete from hillel.data")) {
            return preparedStatement.executeUpdate();
        }
    }
}
