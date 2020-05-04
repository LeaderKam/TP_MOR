package servlet.dao;


import servlet.config.HibernateUtil;
import servlet.config.HibernateUtilEntityManager;
import test.testjpa.domain.Employee;

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
        HibernateUtilEntityManager test = new HibernateUtilEntityManager();
        EntityTransaction tx = test.getManager().getTransaction();
        try {
            // start a transaction
            tx.begin();
            // save the student object
            test.getManager().persist(user);
            // commit transaction
            tx.commit();
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
        HibernateUtilEntityManager test = new HibernateUtilEntityManager();
        EntityTransaction tx = test.getManager().getTransaction();
        try {
            // start a transaction
            tx.begin();
            // save the student object
            test.getManager().merge(user);
            // commit transaction
            tx.commit();
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
     * @param id
     */
    public void deleteUser(Long id) {
        HibernateUtilEntityManager test = new HibernateUtilEntityManager();
        EntityTransaction tx = test.getManager().getTransaction();
        try {
            // start a transaction
            tx.begin();
            // save the student object
            Employee user = test.getManager().find(Employee.class, id);
            test.getManager().remove(user);
            // commit transaction
            tx.commit();
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
    public Employee getUser(Long id) {
        HibernateUtilEntityManager test = new HibernateUtilEntityManager();
        EntityTransaction tx = test.getManager().getTransaction();
        Employee user = null;
        try {
            // start a transaction
            tx.begin();
            // save the student object
            test.getManager().find(Employee.class, id);
            user = test.getManager().find(Employee.class, id);
            // commit transaction
            tx.commit();
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
        HibernateUtilEntityManager test = new HibernateUtilEntityManager();
        EntityTransaction tx = test.getManager().getTransaction();
        List<Employee> listOfUser = new ArrayList<Employee>();
        try {
            // start a transaction
            tx.begin();
            // return the list of student object
            listOfUser = test.getManager().createQuery("select a From Employee a", Employee.class).getResultList();
            // commit transaction
            tx.commit();
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