package edu.hillel;

import edu.hillel.DAO.CourseDAO;
import edu.hillel.DAO.GroupDAO;
import edu.hillel.DAO.StudentDAO;
import edu.hillel.Entity.Course;
import edu.hillel.Entity.Group;
import edu.hillel.Entity.Student;

public class Main {


    public static void main(String[] args) {

        final StudentDAO studentDAO = new StudentDAO();
        final GroupDAO groupDAO = new GroupDAO();
        final CourseDAO courseDAO = new CourseDAO();

        Group group1 = new Group("group 1");
        groupDAO.save(group1);

        Group group2 = new Group("group 2");
        groupDAO.save(group2);

        Course course1 = new Course("course 1");
        courseDAO.save(course1);

        Course course2 = new Course("course 2");
        courseDAO.save(course2);

        Student student1 = new Student("student 1", "student 1 email", group1);
        student1.addCourse(course2);
        studentDAO.save(student1);

        Student student2 = new Student("student 2", "student 2 email", group2);
        student2.addCourse(course1);
        student2.addCourse(course2);
        studentDAO.save(student2);

        Student studentGet = studentDAO.getById(student2.getId());
        System.out.println("Student get - " + studentGet);
        System.out.println("Student get - group - " + studentGet.getGroup());
        System.out.println("Student get - courses - " + studentGet.getCourses());

        student2.setEmail("student 2 new email");
        studentDAO.save(student2);
        System.out.println("Student 2 after change - " + student2);

        System.out.println("List of students");
        studentDAO.getAll()
                .forEach(System.out::println);

        studentDAO.delete(student2);
        System.out.println("List of students after delete student 2");
        studentDAO.getAll()
                .forEach(System.out::println);

    }
}
