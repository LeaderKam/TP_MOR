package servlet.dao.rest;

import servlet.config.HibernateUtil;
import servlet.config.HibernateUtilEntityManager;
import test.testjpa.domain.rest.SondageRest;


import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

public class SondageRestDao {


    /**
     * Get all SondageRests
     *
     * @return
     */
    //@SuppressWarnings("unchecked")
    public List<SondageRest> getAllSondageRest() {
        HibernateUtilEntityManager test = new HibernateUtilEntityManager();
        EntityTransaction tx = test.getManager().getTransaction();
        List<SondageRest> listOfSondageRest = new ArrayList<SondageRest>();

        try {
            // start a transaction
            tx.begin();
            // return the list of sondage object

            listOfSondageRest = test.getManager().createQuery("select a From SondageRest a", SondageRest.class).getResultList();
            listOfSondageRest.get(0);
            // commit transaction
            tx.commit();                       //transaction.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        test.getManager().close();
        return listOfSondageRest;
    }

    /**
     * Save SondageRest
     *
     * @param sondage
     */


    public void saveSondageRest(SondageRest sondage) {
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
     * Update SondageRest
     *
     * @param sondage
     */
    public void updateSondageRest(SondageRest sondage) {
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
     * Delete SondageRest
     *
     * @param id
     */
    public void deleteSondageRest(Long id) {
        HibernateUtilEntityManager test = new HibernateUtilEntityManager();
        EntityTransaction tx = test.getManager().getTransaction();
        try {
            // start a transaction
            tx.begin();
            // save the student object
            SondageRest sondage = test.getManager().find(SondageRest.class, id);
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
     * Get SondageRest By ID
     *
     * @param id
     * @return
     */
    public SondageRest getSondageRest(Long id) {
        HibernateUtilEntityManager test = new HibernateUtilEntityManager();
        EntityTransaction tx = test.getManager().getTransaction();
        SondageRest sondage = null;
        try {
            // start a transaction
            tx.begin();
            // save the sondage object
            sondage = test.getManager().find(SondageRest.class, id);
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
