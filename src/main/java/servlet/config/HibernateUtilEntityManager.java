package servlet.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import test.testjpa.domain.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.Properties;


/**
 * Java based configuration
 *
 * @author ramesh Fadatare
 */
public class HibernateUtilEntityManager {
   private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3308/testesir1?useLegacyDatetimeCode=false&serverTimezone=UTC");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

                settings.put(Environment.SHOW_SQL, "true");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                settings.put(Environment.HBM2DDL_AUTO, "create-drop");

                configuration.setProperties(settings);
                configuration.addAnnotatedClass(Employee.class);
                configuration.addAnnotatedClass(Department.class);
                configuration.addAnnotatedClass(Sondage.class);
                configuration.addAnnotatedClass(Reunion.class);
                configuration.addAnnotatedClass(User_sondage.class);
                configuration.addAnnotatedClass(User_reunion.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                System.out.println("Hibernate Java Config serviceRegistry created");
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                return sessionFactory;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

    private final EntityManager manager;

    public HibernateUtilEntityManager(){
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("mysql");
        //EntityManager manager = EntityManagerHelper.getEntityManager();
        EntityManager manager = factory.createEntityManager();
        this.manager=manager;
    }

    public HibernateUtilEntityManager(EntityManager manager) {
        this.manager = manager;
    }

    public EntityManager getManager() {
        return this.manager;
    }


}
