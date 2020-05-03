package servlet.dao;

import servlet.config.HibernateUtil;
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
        HibernateUtil test = new HibernateUtil();
        EntityTransaction tx = test.getManager().getTransaction();
        List<Sondage> listOfSondage = new ArrayList<Sondage>();

        try {
            //Session session = HibernateUtil.getSessionFactory().openSession();

            // start a transaction
            tx.begin();             //transaction = session.beginTransaction();
            // return the list of student object
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
}
