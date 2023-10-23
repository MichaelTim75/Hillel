package edu.hillel.lesson21;

import edu.hillel.lesson21.dao.HomeworkDAO;
import edu.hillel.lesson21.dao.LessonDAO;
import edu.hillel.lesson21.dto.Homework;
import edu.hillel.lesson21.dto.Lesson;

import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        Connection connection = dataBaseConnection.getConnection();
        HomeworkDAO homeworkDAO = new HomeworkDAO(connection);
        LessonDAO lessonDAO = new LessonDAO(connection);

        if (!homeworkDAO.checkExistsById(1)) {
            homeworkDAO.addHomework(new Homework("First homework", "some description"));
        }
        List<Homework> homeworks = homeworkDAO.getHomeworks();
        homeworks.forEach(System.out::println);

        lessonDAO.addLesson(new Lesson("lesson 1",1));
        List<Lesson> lessons = lessonDAO.getLessons();
        lessons.forEach(System.out::println);

        Lesson lesson = lessonDAO.getLessonById(2);
        System.out.println(lesson);

        lessonDAO.deleteLesson(1);

        dataBaseConnection.closeConnection(connection);
    }
}
