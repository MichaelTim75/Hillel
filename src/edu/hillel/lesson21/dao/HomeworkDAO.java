package edu.hillel.lesson21.dao;

import edu.hillel.lesson21.dto.Homework;
import edu.hillel.lesson21.dto.Lesson;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HomeworkDAO {
    private final Connection connection;

    public HomeworkDAO(Connection connection) {
        this.connection = connection;
    }

    public int addHomework(Homework homework) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("insert into hillel.homeworks(name,description) values (?,?)")) {
            preparedStatement.setString(1, homework.getName());
            preparedStatement.setString(2, homework.getDescription());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Homework> getHomeworks() {
        List<Homework> homeworkList = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery("select * from hillel.homeworks")) {
                while (resultSet.next()) {
                    homeworkList.add(new Homework(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("description")));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return homeworkList;
    }

    public boolean checkExistsById(int id){
        try (PreparedStatement preparedStatement = connection.prepareStatement("select exists(select 1 from hillel.homeworks as h where h.id=?) as exist")) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getBoolean("exist");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
