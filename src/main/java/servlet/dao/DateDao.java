package servlet.dao;

import servlet.config.HibernateUtilEntityManager;
import test.testjpa.domain.DateSondage;

import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

public class DateDao {

    /**
     * Get all DateSondages
     *
     * @return
     */
    //@SuppressWarnings("unchecked")
    public List<DateSondage> getAllDateSondage() {
        HibernateUtilEntityManager test = new HibernateUtilEntityManager();
        EntityTransaction tx = test.getManager().getTransaction();
        List<DateSondage> listOfDateSondage = new ArrayList<DateSondage>();

        try {
            // start a transaction
            tx.begin();
            // return the list of sondage object

            listOfDateSondage = test.getManager().createQuery("select a From DateSondage a", DateSondage.class).getResultList();
            // commit transaction
            tx.commit();                       //transaction.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        test.getManager().close();
        return listOfDateSondage;
    }

    /**
     * Save DateSondage
     *
     * @param sondage
     */


    public void saveDateSondage(DateSondage sondage) {
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
     * Update DateSondage
     *
     * @param sondage
     */
    public void updateDateSondage(DateSondage sondage) {
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
     * Delete DateSondage
     *
     * @param id
     */
    public void deleteDateSondage(Long id) {
        HibernateUtilEntityManager test = new HibernateUtilEntityManager();
        EntityTransaction tx = test.getManager().getTransaction();
        try {
            // start a transaction
            tx.begin();
            // save the student object
            DateSondage sondage = test.getManager().find(DateSondage.class, id);
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
     * Get DateSondage By ID
     *
     * @param id
     * @return
     */
    public DateSondage getDateSondage(Long id) {
        HibernateUtilEntityManager test = new HibernateUtilEntityManager();
        EntityTransaction tx = test.getManager().getTransaction();
        DateSondage sondage = null;
        try {
            // start a transaction
            tx.begin();
            // save the sondage object
            sondage = test.getManager().find(DateSondage.class, id);
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
