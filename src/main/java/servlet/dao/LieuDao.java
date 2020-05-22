package servlet.dao;

import servlet.config.HibernateUtilEntityManager;
import test.testjpa.domain.LieuSondage;
import test.testjpa.domain.LieuSondage;
import test.testjpa.domain.Sondage;
import test.testjpa.domain.Sondage_lieu;

import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

public class LieuDao {

    /**
     * Get all LieuSondages
     *
     * @return
     */
    //@SuppressWarnings("unchecked")
    public List<LieuSondage> getAllLieuSondage() {
        HibernateUtilEntityManager test = new HibernateUtilEntityManager();
        EntityTransaction tx = test.getManager().getTransaction();
        List<LieuSondage> listOfLieuSondage = new ArrayList<LieuSondage>();

        try {
            // start a transaction
            tx.begin();
            // return the list of sondage object

            listOfLieuSondage = test.getManager().createQuery("select a From LieuSondage a", LieuSondage.class).getResultList();
            // commit transaction
            tx.commit();                       //transaction.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        test.getManager().close();
        return listOfLieuSondage;
    }

    /**
     * Save LieuSondage
     *
     * @param sondage
     */


    public void saveLieuSondage(LieuSondage sondage) {
        HibernateUtilEntityManager test = new HibernateUtilEntityManager();
        EntityTransaction tx = test.getManager().getTransaction();
        try {
            // start a transaction
            tx.begin();
            // save the student object
            test.getManager().persist(sondage);
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
     * Update LieuSondage
     *
     * @param sondage
     */
    public void updateLieuSondage(LieuSondage sondage) {
        HibernateUtilEntityManager test = new HibernateUtilEntityManager();
        EntityTransaction tx = test.getManager().getTransaction();
        try {
            // start a transaction
            tx.begin();
            // save the student object
            boolean t = test.getManager().contains(sondage);
            if (!t) {
                test.getManager().merge(sondage);
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
     * Delete LieuSondage
     *
     * @param id
     */
    public void deleteLieuSondage(Long id) {
        HibernateUtilEntityManager test = new HibernateUtilEntityManager();
        EntityTransaction tx = test.getManager().getTransaction();
        try {
            // start a transaction
            tx.begin();
            // save the student object
            LieuSondage sondage = test.getManager().find(LieuSondage.class, id);
            test.getManager().remove(sondage);
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
     * Get LieuSondage By ID
     *
     * @param id
     * @return
     */
    public LieuSondage getLieuSondage(Long id) {
        HibernateUtilEntityManager test = new HibernateUtilEntityManager();
        EntityTransaction tx = test.getManager().getTransaction();
        LieuSondage sondage = null;
        try {
            // start a transaction
            tx.begin();
            // save the sondage object
            sondage = test.getManager().find(LieuSondage.class, id);
            // commit transaction
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        test.getManager().close();
        return sondage;
    }

}
