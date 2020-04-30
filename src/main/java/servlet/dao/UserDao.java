package servlet.dao;


import jpa.JpaTest;
import org.hibernate.Session;
import org.hibernate.Transaction;
import servlet.config.HibernateUtil;
import test.testjpa.domain.Employee;
import test.testjpa.domain.User_sondage;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

/**
 * CRUD database operations
 *
 * @author Ramesh Fadatare
 */
public class UserDao {

    /**
     * Save User
     *
     * @param user
     */


    public void saveUser(Employee user) {
       // Transaction transaction = null;
        HibernateUtil test = new HibernateUtil();
        EntityTransaction tx = test.getManager().getTransaction();

        try {
            //Session session = HibernateUtil.getSessionFactory().openSession();

            // start a transaction
            tx.begin();             //transaction = session.beginTransaction();
            // save the student object
              test.getManager().persist(user);                      //session.save(user);
            // commit transaction
             tx.commit();                       //transaction.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        test.getManager().close();
    }

    /**
     * Update User
     *
     * @param user
     */
    public void updateUser(Employee user) {
        HibernateUtil test = new HibernateUtil();
        EntityTransaction tx = test.getManager().getTransaction();

        try {
            //Session session = HibernateUtil.getSessionFactory().openSession();

            // start a transaction
            tx.begin();             //transaction = session.beginTransaction();
            // save the student object
            test.getManager().merge(user);                      //session.save(user);
            // commit transaction
            tx.commit();                       //transaction.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        test.getManager().close();
    }

    /**
     * Delete User
     *
     * @param user
     */
    public void deleteUser(Employee user) {

        HibernateUtil test = new HibernateUtil();
        EntityTransaction tx = test.getManager().getTransaction();

        try {
            //Session session = HibernateUtil.getSessionFactory().openSession();

            // start a transaction
            tx.begin();             //transaction = session.beginTransaction();
            // save the student object
            user=test.getManager().merge(user);
            test.getManager().remove(user);                      //session.save(user);
            // commit transaction
            tx.commit();                       //transaction.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        test.getManager().close();
    }

    /**
     * Get User By ID
     *
     * @param id
     * @return
     */
    public Employee getUser(int id) {

        HibernateUtil test = new HibernateUtil();
        EntityTransaction tx = test.getManager().getTransaction();

        Employee user = null;
        try {
            //Session session = HibernateUtil.getSessionFactory().openSession();

            // start a transaction
            tx.begin();             //transaction = session.beginTransaction();
            // save the student object
            user = test.getManager().createQuery("select a From Employee a", Employee.class).getSingleResult();
            // commit transaction
            tx.commit();                       //transaction.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        test.getManager().close();
        return user;
    }

    /**
     * Get all Users
     *
     * @return
     */
    //@SuppressWarnings("unchecked")
    public List<Employee> getAllUser() {
        HibernateUtil test = new HibernateUtil();
        EntityTransaction tx = test.getManager().getTransaction();
        List<Employee> listOfUser=new ArrayList<Employee>();

        try {
            //Session session = HibernateUtil.getSessionFactory().openSession();

            // start a transaction
            tx.begin();             //transaction = session.beginTransaction();
            // return the list of student object
            listOfUser = test.getManager().createQuery("select a From Employee a",Employee.class).getResultList();
            // commit transaction
            tx.commit();                       //transaction.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        test.getManager().close();
        return listOfUser;
    }
}