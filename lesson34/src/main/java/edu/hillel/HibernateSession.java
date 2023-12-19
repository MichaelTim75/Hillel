package edu.hillel;

import edu.hillel.Entity.Course;
import edu.hillel.Entity.Group;
import edu.hillel.Entity.Student;
import lombok.NoArgsConstructor;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@NoArgsConstructor
public class HibernateSession implements AutoCloseable{

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){
        if(sessionFactory==null){
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.html")
                    .addAnnotatedClass(Course.class)
                    .addAnnotatedClass(Group.class)
                    .addAnnotatedClass(Student.class)
                    .buildSessionFactory();
        }
        return sessionFactory;
    }

    @Override
    public void close() throws Exception {
        sessionFactory.close();
    }
}
