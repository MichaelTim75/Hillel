package edu.hillel.DAO;

import edu.hillel.HibernateSession;
import edu.hillel.Entity.Student;
import org.hibernate.Session;

import java.util.List;

public class StudentDAO {

    public List<Student> getAll() {
        try(final Session session=HibernateSession
                .getSessionFactory()
                .openSession())
        {
            return session.createQuery("From Student", Student.class)
                    .list();
        }
    }

    public Student getById(int id) {
        try(final Session session=HibernateSession
                .getSessionFactory()
                .openSession())
        {
            return session.get(Student.class, id);
        }
    }

    public void save(Student student) {
        try(final Session session=HibernateSession
                .getSessionFactory()
                .openSession())
        {
            session.beginTransaction();
            session.merge(student);
            session.getTransaction().commit();
        }
    }

    public void delete(Student student) {
        try(final Session session=HibernateSession
                .getSessionFactory()
                .openSession())
        {
            session.beginTransaction();
            session.remove(student);
            session.getTransaction().commit();
        }
    }

}
