package servlet.dao;

import servlet.config.HibernateUtil;
import servlet.config.HibernateUtilEntityManager;
import test.testjpa.domain.Employee;
import test.testjpa.domain.Department;

import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDao {

    /**
     * Get all Departments
     *
     * @return
     */
    //@SuppressWarnings("unchecked")
    public List<Department> getAllDepartment() {

        HibernateUtilEntityManager test = new HibernateUtilEntityManager();
        EntityTransaction tx = test.getManager().getTransaction();

        List<Department> listOfDepartment = new ArrayList<Department>();

        try {
            // start a transaction
            tx.begin();
            // return the list of department object

            listOfDepartment = test.getManager().createQuery("select a From Department a", Department.class).getResultList();
            // commit transaction
            tx.commit();                       //transaction.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        test.getManager().close();
        return listOfDepartment;
    }

    /**
     * Save Department
     *
     * @param department
     */


    public void saveDepartment(Department department) {

        HibernateUtilEntityManager test = new HibernateUtilEntityManager();
        EntityTransaction tx = test.getManager().getTransaction();

        try {
            // start a transaction
            tx.begin();
            // save the student object
            test.getManager().persist(department);
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
     * Update Department
     *
     * @param department
     */
    public void updateDepartment(Department department) {

        HibernateUtilEntityManager test = new HibernateUtilEntityManager();
        EntityTransaction tx = test.getManager().getTransaction();

        try {
            // start a transaction
            tx.begin();
            // save the student object
            boolean t=test.getManager().contains(department);
            if (t){
                test.getManager().merge(department);
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
     * Delete Department
     *
     * @param id
     */
    public void deleteDepartment(Long id) {

        HibernateUtilEntityManager test = new HibernateUtilEntityManager();
        EntityTransaction tx = test.getManager().getTransaction();

        try {
            // start a transaction
            tx.begin();
            // save the student object
            Department department = test.getManager().find(Department.class, id);
            test.getManager().remove(department);
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
     * Get Department By ID
     *
     * @param id
     * @return
     */
    public Department getDepartment(Long id) {

        HibernateUtilEntityManager test = new HibernateUtilEntityManager();
        EntityTransaction tx = test.getManager().getTransaction();

        Department department = null;
        try {
            // start a transaction
            tx.begin();
            // save the department object
            department = test.getManager().find(Department.class, id);
            // commit transaction
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        test.getManager().close();
        return department;
    }
}