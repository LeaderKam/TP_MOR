package servlet.dao;

import servlet.config.HibernateUtilEntityManager;
import test.testjpa.domain.User_reunion;

import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

public class UserReunionDao {


    HibernateUtilEntityManager test = new HibernateUtilEntityManager();
    EntityTransaction tx = test.getManager().getTransaction();

    /**
     * Get all UserReunions
     *
     * @return
     */
    //@SuppressWarnings("unchecked")
    public List<User_reunion> getAllUserReunion() {

        List<User_reunion> listOfUserReunion = new ArrayList<User_reunion>();

        try {
            // start a transaction
            tx.begin();
            // return the list of userReunion object

            listOfUserReunion = test.getManager().createQuery("select a From User_reunion a", User_reunion.class).getResultList();
            // commit transaction
            tx.commit();                       //transaction.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        test.getManager().close();
        return listOfUserReunion;
    }

    /**
     * Save UserReunion
     *
     * @param userReunion
     */


    public void saveUserReunion(User_reunion userReunion) {

        try {
            // start a transaction
            tx.begin();
            // save the student object
            test.getManager().persist(userReunion);
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
     * Update UserReunion
     *
     * @param userReunion
     */
    public void updateUserReunion(User_reunion userReunion) {
        try {
            // start a transaction
            tx.begin();
            // save the student object
            boolean t=test.getManager().contains(userReunion);
            if (t){
                test.getManager().merge(userReunion);
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
     * Delete UserReunion
     *
     * @param id
     */
    public void deleteUserReunion(Long id) {
        try {
            // start a transaction
            tx.begin();
            // save the student object
            User_reunion userReunion = test.getManager().find(User_reunion.class, id);
            test.getManager().remove(userReunion);
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
     * Get UserReunion By ID
     *
     * @param id
     * @return
     */
    public User_reunion getUserReunion(Long id) {
        User_reunion userReunion = null;
        try {
            // start a transaction
            tx.begin();
            // save the userReunion object
            userReunion = test.getManager().find(User_reunion.class, id);
            // commit transaction
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        test.getManager().close();
        return userReunion;
    }
}
