package jpa;

import javax.persistence.*;

import test.testjpa.domain.Department;
import test.testjpa.domain.Employee;
import test.testjpa.domain.Reunion;
import test.testjpa.domain.Sondage;

import java.util.Date;
import java.util.List;

public class JpaTest {

	private final EntityManager manager;
	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * @param args:string
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory =
				Persistence.createEntityManagerFactory("mysql");
		//EntityManager manager = EntityManagerHelper.getEntityManager();
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		
//		Department d=new Department();
//		User u= new User();
//		manager.persist(u);
//
//		
//		Reunion r= new Reunion();
//		

		try {
			test.createEmployees();
			test.createSondage();
			test.creatReunion();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

test.listEmployees();
		manager.close();
		System.out.println(".. done");
		//EntityManagerHelper.closeEntityManagerFactory();
		//		factory.close();
	}

	private void creatReunion() {
		int numOfEmployees = manager.createQuery("Select a From Reunion a",
				Reunion.class).getResultList().size();
		if (numOfEmployees == 0) {
			Department department = new Department("java");
			manager.persist(department);
			manager.persist(new Employee("Jakab Gipsz",department));
			manager.persist(new Employee("Captain Nemo",department));
		}
	}

	private void createEmployees() {
		int numOfEmployees = manager.createQuery("Select a From Employee a",
				Employee.class).getResultList().size();
		if (numOfEmployees == 0) {
			Department department = new Department("java");
			manager.persist(department);
			manager.persist(new Employee("Jakab Gipsz",department));
			manager.persist(new Employee("Captain Nemo",department));
		}
	}

	private void createSondage() {
		int numOfSondage = manager.createQuery("Select a From Sondage a",
				Sondage.class).getResultList().size();
		if (numOfSondage == 0) {
			Department department = new Department("IA");
			Employee employee = new Employee("kam",department);
			manager.persist(department);
			manager.persist(employee);
			manager.persist(new Sondage("data",new Date(),employee));
		}
	}

	private void listEmployees() {
		List<Employee> resultList = manager.createQuery("Select a From Employee a",
				Employee.class).getResultList();
		System.out.println("num of employess:" + resultList.size());
		for (Employee next : resultList) {
			System.out.println("next employee: " + next);
		}
	}



}
