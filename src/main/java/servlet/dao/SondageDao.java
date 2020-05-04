package servlet.dao;

import servlet.config.HibernateUtil;
import servlet.config.HibernateUtilEntityManager;
import test.testjpa.domain.Sondage;


import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

public class SondageDao {


    /**
     * Get all Sondages
     *
     * @return
     */
    //@SuppressWarnings("unchecked")
    public List<Sondage> getAllSondage() {
        HibernateUtilEntityManager test = new HibernateUtilEntityManager();
        EntityTransaction tx = test.getManager().getTransaction();
        List<Sondage> listOfSondage = new ArrayList<Sondage>();

        try {
            // start a transaction
            tx.begin();
            // return the list of sondage object

            listOfSondage = test.getManager().createQuery("select a From Sondage a", Sondage.class).getResultList();
            // commit transaction
            tx.commit();                       //transaction.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        test.getManager().close();
        return listOfSondage;
    }

    /**
     * Save Sondage
     *
     * @param sondage
     */


    public void saveSondage(Sondage sondage) {
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
     * Update Sondage
     *
     * @param sondage
     */
    public void updateSondage(Sondage sondage) {
        HibernateUtilEntityManager test = new HibernateUtilEntityManager();
        EntityTransaction tx = test.getManager().getTransaction();
        try {
            // start a transaction
            tx.begin();
            // save the student object
            boolean t = test.getManager().contains(sondage);
            if (t) {
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
     * Delete Sondage
     *
     * @param id
     */
    public void deleteSondage(Long id) {
        HibernateUtilEntityManager test = new HibernateUtilEntityManager();
        EntityTransaction tx = test.getManager().getTransaction();
        try {
            // start a transaction
            tx.begin();
            // save the student object
            Sondage sondage = test.getManager().find(Sondage.class, id);
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
     * Get Sondage By ID
     *
     * @param id
     * @return
     */
    public Sondage getSondage(Long id) {
        HibernateUtilEntityManager test = new HibernateUtilEntityManager();
        EntityTransaction tx = test.getManager().getTransaction();
        Sondage sondage = null;
        try {
            // start a transaction
            tx.begin();
            // save the sondage object
            sondage = test.getManager().find(Sondage.class, id);
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
