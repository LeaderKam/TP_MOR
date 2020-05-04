package servlet.dao.test;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import servlet.config.HibernateUtil;
import test.testjpa.domain.Employee;
import test.testjpa.domain.Sondage;
import test.testjpa.domain.User_sondage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
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
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(user);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * Update User
     *
     * @param employee
     */
    public void updateUser(Employee employee) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.update(employee);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * Delete User
     *
     * @param id
     */
    public void deleteUser(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a user object
            Employee user = (Employee) session.get(Employee.class, id);
            if (user != null) {
                session.delete(user);
                System.out.println("user is deleted");
            }

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * Get User By ID
     *
     * @param id
     * @return
     */
    public Employee getUser(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        Employee user = null;
        try {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            user = (Employee) session.get(Employee.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return user;
    }

    /**
     * Get all Users
     *
     * @return
     */
    // @SuppressWarnings("unchecked")
    public List<Employee> getAllUser() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<Employee> listOfUser = null;
        try {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            listOfUser = session.createQuery("from Employee").list();

           // Query q = session.createQuery("from Employee");

           // session.getTransaction().commit();
            transaction.commit();
            System.out.println("************************\n" + listOfUser.size());

            // commit transaction


        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        } finally {

            session.close();
        }

        return listOfUser;
    }
}