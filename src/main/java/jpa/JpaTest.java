package jpa;

import javax.persistence.*;

import test.testjpa.domain.*;
import test.testjpa.domain.strategy.ChoixMajoritaire;
import test.testjpa.domain.strategy.Context;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
			test.createReunion();
			//test.nSelect();
			test.createUserSondageDateLieu();
			test.createUserSondageDate();
			test.createUserSondageLieu();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

test.listEmployees();
		List<User_sondage> user_reunionsA = manager.createQuery("Select a From User_sondage a",User_sondage.class).getResultList();
		List<Date> dateTest=new ArrayList<Date>();
		for (User_sondage a:user_reunionsA){
			dateTest.add(a.getSondage().getDate_sondage());
			System.out.println("*************** \n"+ a.getSondage().getDate_sondage());
		}
		manager.close();

		System.out.println(".. done");
		//EntityManagerHelper.closeEntityManagerFactory();
		//		factory.close();
	}

	private void createReunion() {
		int numOfEmployees = manager.createQuery("Select a From Reunion a",Reunion.class).getResultList().size();
		if (numOfEmployees == 0) {
			Department department = new Department("jpa");
			manager.persist(department);
			manager.persist(new Employee("koussaila",department));

			manager.persist(new Reunion("Captain Nemo","reunion test",new Date()));


		}
		Department department = new Department("jpa");
		manager.persist(department);
		Employee marius=new Employee("marius",department);


		Context ctx=new Context(new ChoixMajoritaire());
		//ctx.appliquerStrategy(new ChoixMajoritaire(),);
		ctx.setStrategy(new ChoixMajoritaire());
		//ctx.appliquerStrategy();
		manager.persist(marius);

		Reunion reu=new Reunion("data ia","c'est un test",new Date());
		manager.persist(reu);
		manager.persist(new User_reunion(marius,reu));
	}

	private void nSelect(){

		for (int j = 0; j < 5000; j++) {


			Department d = new Department("dep"+j);
			manager.persist(d);
			for (int i = 0; i < 2; i++) {
				Employee e = new Employee("emp_"+j + "_"+i);
				manager.persist(e);
				e.setDepartment(d);
				d.getEmployees().add(e);
			}


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
			//new Sondage_date();
			manager.persist(new Sondage("data",new Date(),employee));
		}
	}

	private void createUserSondageDate(){
		Department departement= new Department("ML");
		Employee employee=new Employee("salam",departement);
		manager.persist(employee);
		Sondage sondage=new Sondage("data", new Date(),employee);
		manager.persist(sondage);
		User_sondage user_sondage=new Sondage_date(employee,sondage,new Date());
		manager.persist(user_sondage);
	}

	private void createUserSondageLieu(){
		Department departement= new Department("ML");
		Employee employee=new Employee("salam",departement);
		manager.persist(employee);
		Sondage sondage=new Sondage("data", new Date(),employee);
		manager.persist(sondage);
		User_sondage user_sondage=new Sondage_lieu(employee,sondage,"Rennes");
		manager.persist(user_sondage);
	}
	private void createUserSondageDateLieu(){
		Department departement= new Department("MI");
		Employee employee=new Employee("salam",departement);
		manager.persist(employee);
		Sondage sondage=new Sondage("data", new Date(),employee);
		manager.persist(sondage);
		User_sondage user_sondage=new Sondage_lieu_date(employee,sondage,"Rennes",new Date());
		manager.persist(user_sondage);
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
