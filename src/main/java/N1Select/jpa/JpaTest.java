package N1Select.jpa;


import test.testjpa.domain.Department;
import test.testjpa.domain.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class JpaTest {

	private final EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("mysqlSelect");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		// TODO create entity
try {


	for (int j = 0; j < 5000; j++) {


		Department d = new Department("dep" + j);
		manager.persist(d);
		for (int i = 0; i < 2; i++) {
			Employee e = new Employee("emp_" + j + "_" + i);
			manager.persist(e);
			e.setDepartment(d);
			d.getEmployees().add(e);
		}


	}
}catch (Exception e) {
}	tx.commit();

		// TODO persist entity
manager.close();

		// TODO run request

		System.out.println(".. done");
	}


}
