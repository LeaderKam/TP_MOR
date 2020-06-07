package servlet.dao;

import servlet.config.HibernateUtilEntityManager;
import test.testjpa.domain.User_sondage;

import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

public class UserSondageDao {

    /**
     * Get all User_sondages
     *
     * @return
     */
    //@SuppressWarnings("unchecked")
    public List<User_sondage> getAllUserSondage() {
        HibernateUtilEntityManager test = new HibernateUtilEntityManager();
        EntityTransaction tx = test.getManager().getTransaction();
        List<User_sondage> listOfUser_sondage = new ArrayList<User_sondage>();

        try {
            // start a transaction
            tx.begin();
            // return the list of user_sondage object

            listOfUser_sondage = test.getManager().createQuery("select a From User_sondage a", User_sondage.class).getResultList();
            // commit transaction
            tx.commit();                       //transaction.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        test.getManager().close();
        return listOfUser_sondage;
    }

    /**
     * Save User_sondage
     *
     * @param user_sondage
     */

    public void saveUserSondage(User_sondage user_sondage) {

        HibernateUtilEntityManager test = new HibernateUtilEntityManager();
        EntityTransaction tx = test.getManager().getTransaction();
        try {
            // start a transaction
            tx.begin();
            // save the student object
            test.getManager().persist(user_sondage);
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
     * Update User_sondage
     *
     * @param user_sondage
     */
    public void updateUserSondage(User_sondage user_sondage) {
        HibernateUtilEntityManager test = new HibernateUtilEntityManager();
        EntityTransaction tx = test.getManager().getTransaction();
        try {
            // start a transaction
            tx.begin();
            // save the student object
            boolean t=test.getManager().contains(user_sondage);
            if (t){
                test.getManager().merge(user_sondage);
                // commit transaction
                tx.commit();
            }

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        test.getManager().close();
    }

    /**
     * Delete User_sondage
     *
     * @param id
     */
    public void deleteUserSondage(Long id) {
        HibernateUtilEntityManager test = new HibernateUtilEntityManager();
        EntityTransaction tx = test.getManager().getTransaction();
        try {
            // start a transaction
            tx.begin();
            // save the student object
            User_sondage user_sondage = test.getManager().find(User_sondage.class, id);
            test.getManager().remove(user_sondage);
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
     * Get User_sondage By ID
     *
     * @param id
     * @return
     */
    public User_sondage getUserSondage(Long id) {
        HibernateUtilEntityManager test = new HibernateUtilEntityManager();
        EntityTransaction tx = test.getManager().getTransaction();
        User_sondage user_sondage = null;
        try {
            // start a transaction
            tx.begin();
            // save the user_sondage object
            user_sondage = test.getManager().find(User_sondage.class, id);
            // commit transaction
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        test.getManager().close();
        return user_sondage;
    }
}
