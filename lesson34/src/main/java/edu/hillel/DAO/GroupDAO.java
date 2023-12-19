package edu.hillel.DAO;

import edu.hillel.Entity.Group;
import edu.hillel.HibernateSession;
import org.hibernate.Session;

public class GroupDAO {

    public Group getById(int id) {
        try (final Session session = HibernateSession
                .getSessionFactory()
                .openSession()) {
            return session.get(Group.class, id);
        }
    }

    public void save(Group group) {
        try (final Session session = HibernateSession
                .getSessionFactory()
                .openSession()) {
            session.beginTransaction();
            session.persist(group);
            session.getTransaction().commit();
        }
    }


}
