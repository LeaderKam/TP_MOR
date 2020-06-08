package servlet.dao;

import servlet.config.HibernateUtil;
import servlet.config.HibernateUtilEntityManager;
import test.testjpa.domain.Employee;
import test.testjpa.domain.Reunion;
import test.testjpa.domain.Reunion;

import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

public class ReunionDao {


    /**
     * Get all Reunions
     *
     * @return
     */
    //@SuppressWarnings("unchecked")
    public List<Reunion> getAllReunion() {
        HibernateUtilEntityManager test = new HibernateUtilEntityManager();
        EntityTransaction tx = test.getManager().getTransaction();
        List<Reunion> listOfReunion = new ArrayList<Reunion>();

        try {
            // start a transaction
            tx.begin();
            // return the list of reunion object
            listOfReunion = test.getManager().createQuery("select a From Reunion a", Reunion.class).getResultList();
            // commit transaction
            tx.commit();                       //transaction.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        test.getManager().close();
        return listOfReunion;
    }

    /**
     * Save Reunion
     *
     * @param reunion
     */


    public void saveReunion(Reunion reunion) {
        HibernateUtilEntityManager test = new HibernateUtilEntityManager();
        EntityTransaction tx = test.getManager().getTransaction();
        try {
            // start a transaction
            tx.begin();
            // save the student object
            test.getManager().persist(reunion);
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
     * Update Reunion
     *
     * @param reunion
     */
    public void updateReunion(Reunion reunion) {
        HibernateUtilEntityManager test = new HibernateUtilEntityManager();
        EntityTransaction tx = test.getManager().getTransaction();
        try {
            // start a transaction
            tx.begin();
            // save the student object

                test.getManager().merge(reunion);
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
     * Delete Reunion
     *
     * @param id
     */
    public void deleteReunion(Long id) {
        HibernateUtilEntityManager test = new HibernateUtilEntityManager();
        EntityTransaction tx = test.getManager().getTransaction();
        try {
            // start a transaction
            tx.begin();
            // save the student object
            Reunion reunion = test.getManager().find(Reunion.class, id);
            test.getManager().remove(reunion);
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
     * Get Reunion By ID
     *
     * @param id
     * @return
     */
    public Reunion getReunion(Long id) {
        HibernateUtilEntityManager test = new HibernateUtilEntityManager();
        EntityTransaction tx = test.getManager().getTransaction();
        Reunion reunion = null;
        try {
            // start a transaction
            tx.begin();
            // save the reunion object
            reunion = test.getManager().find(Reunion.class, id);
            // commit transaction
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        test.getManager().close();
        return reunion;
    }
}