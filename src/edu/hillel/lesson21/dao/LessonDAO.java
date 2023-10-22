package edu.hillel.lesson21.dao;

import edu.hillel.lesson21.dto.Homework;
import edu.hillel.lesson21.dto.Lesson;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LessonDAO {
    private final Connection connection;

    public LessonDAO(Connection connection) {
        this.connection = connection;
    }

    public int addLesson(Lesson lesson){
        try(PreparedStatement preparedStatement = connection.prepareStatement("insert into hillel.lessons(name,updated_at,homework_id) values (?,?,?)")){
            preparedStatement.setString(1, lesson.getName());
            preparedStatement.setTimestamp(2,Timestamp.valueOf(LocalDateTime.now()));
            preparedStatement.setInt(3, lesson.getHomeworkId());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteLesson(int id){
        try(PreparedStatement preparedStatement = connection.prepareStatement("delete from hillel.lessons as l where l.id=?")){
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Lesson> getLessons() {
        List<Lesson> lessonList = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery("select l.id,l.name,l.homework_id,h.name as homework from hillel.lessons as l join hillel.homeworks h on h.id = l.homework_id")) {
                while (resultSet.next()) {
                    lessonList.add(new Lesson(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("homework"),
                            resultSet.getInt("homework_id")));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lessonList;
    }
    public Lesson getLessonById(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("select l.id,l.name,l.homework_id,h.name as homework " +
                "from hillel.lessons as l join hillel.homeworks h on h.id = l.homework_id " +
                "where l.id=?")) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Lesson(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("homework"),
                            resultSet.getInt("homework_id"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}
