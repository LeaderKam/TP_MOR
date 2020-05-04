package servlet.dao.test;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import servlet.config.HibernateUtil;
import test.testjpa.domain.Employee;
import test.testjpa.domain.Sondage;

import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

public class SondageDao {

    /**
     * Get all Users
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<Sondage> getAllSondage() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<Sondage> listOfSondage = null;
        try {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object

            Query query = session.createQuery("From Sondage");
            listOfSondage = query.list();

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return listOfSondage;
    }
}