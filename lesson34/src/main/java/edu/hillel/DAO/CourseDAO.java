package edu.hillel.DAO;

import edu.hillel.Entity.Course;
import edu.hillel.HibernateSession;
import org.hibernate.Session;

public class CourseDAO {

    public Course getById(int id) {
        try (final Session session = HibernateSession
                .getSessionFactory()
                .openSession()) {
            return session.get(Course.class, id);
        }
    }

    public void save(Course course) {
        try (final Session session = HibernateSession
                .getSessionFactory()
                .openSession()) {
            session.beginTransaction();
            session.persist(course);
            session.getTransaction().commit();
        }
    }


}
