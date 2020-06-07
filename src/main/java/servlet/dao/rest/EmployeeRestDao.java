package servlet.dao.rest;


import servlet.config.HibernateUtil;
import servlet.config.HibernateUtilEntityManager;
import test.testjpa.domain.rest.EmployeeRest;

import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

/**
 * CRUD database operations
 *
 * @author Ramesh Fadatare
 */
public class EmployeeRestDao {


    /**
     * Save User
     *
     * @param user
     */
    public void saveUser(EmployeeRest user) {
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
    public void updateUser(EmployeeRest user) {
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
            EmployeeRest user = test.getManager().find(EmployeeRest.class, id);
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
    public EmployeeRest getUser(Long id) {
        HibernateUtilEntityManager test = new HibernateUtilEntityManager();
        EntityTransaction tx = test.getManager().getTransaction();
        EmployeeRest user = null;
        try {
            // start a transaction
            tx.begin();
            // save the student object
            test.getManager().find(EmployeeRest.class, id);
            user = test.getManager().find(EmployeeRest.class, id);
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
    public List<EmployeeRest> getAllUser() {
        HibernateUtilEntityManager test = new HibernateUtilEntityManager();
        EntityTransaction tx = test.getManager().getTransaction();
        List<EmployeeRest> listOfUser = new ArrayList<EmployeeRest>();
        try {
            // start a transaction
            tx.begin();
            // return the list of student object
            listOfUser = test.getManager().createQuery("select a From EmployeeRest a", EmployeeRest.class).getResultList();
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