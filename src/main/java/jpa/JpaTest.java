package jpa;

import javax.persistence.*;

import test.testjpa.domain.*;
import test.testjpa.domain.rest.*;
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

		try {

			//test.createEmployees();
			//test.createSondage();
			//test.createReunion();
			//test.nSelect();
			//test.createUserSondage();
			test.createEmployeesRest();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

test.listEmployees();
test.listSondageLieu();
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

			manager.persist(new Reunion("Captain Nemo","reunion test",new Date(),true));

		}
		Department department = new Department("jpa");
		Department department1 = new Department("ML");
		manager.persist(department);
		manager.persist(department1);

		Employee marius=new Employee("marius",department);
		Employee kam=new Employee("Sie kam",department1);

		Context ctx=new Context(new ChoixMajoritaire());
		//ctx.appliquerStrategy(new ChoixMajoritaire(),);
		ctx.setStrategy(new ChoixMajoritaire());
		//ctx.appliquerStrategy();
		manager.persist(marius);

		Reunion reunion1=new Reunion("data ia","c'est un test 1",new Date(),false);
		Reunion reunion2=new Reunion("deep L","c'est un test 1",new Date(),false);
		manager.persist(reunion1);
		manager.persist(reunion2);
		manager.persist(new User_reunion(marius,reunion1,"ras"));
		manager.persist(new User_reunion(kam,reunion2,"ras"));
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
	private void createEmployeesRest() {
		int numOfEmployees = manager.createQuery("Select a From EmployeeRest a",
				EmployeeRest.class).getResultList().size();
		if (numOfEmployees == 0) {
			DepartmentRest department = new DepartmentRest("java");
			manager.persist(department);
			manager.persist(new EmployeeRest("KAM",department));
			manager.persist(new EmployeeRest("SIE",department));
		}

	}
	private void createSondage() {
		int numOfSondage = manager.createQuery("Select a From Sondage a",
				Sondage.class).getResultList().size();
		System.out.println("****************************\n"+numOfSondage);

		Department department = new Department("IA");
		Employee employee = new Employee("kam",department);

		DateSondage dateSondage=new DateSondage(new Date(),new Date(),new Date());
		LieuSondage lieuSondage=new LieuSondage("cocody","marcory","angré");

		//sondage date
		Sondage_date sondage_date=new Sondage_date("Big Data",new Date(),employee,dateSondage);

		//sondage lieu
		Sondage_lieu sondage_lieu= new Sondage_lieu("IA",new Date(),employee,lieuSondage);

		//sondage lieu et date
		Sondage_lieu_date sondage_lieu_date=new Sondage_lieu_date("Deep Learning",new Date(),employee,lieuSondage,dateSondage);

		manager.persist(department);
		manager.persist(employee);

		manager.persist(sondage_date);
		manager.persist(sondage_lieu);
		manager.persist(sondage_lieu_date);

	}
	private void createSondageRest() {
		int numOfSondage = manager.createQuery("Select a From SondageRest a",
				Sondage.class).getResultList().size();
		System.out.println("****************************\n"+numOfSondage);

		Department department = new Department("IA");
		Employee employee = new Employee("kam",department);

		DateSondage dateSondage=new DateSondage(new Date(),new Date(),new Date());
		LieuSondage lieuSondage=new LieuSondage("cocody","marcory","angré");

		//sondage date
		Sondage_date sondage_date=new Sondage_date("Big Data",new Date(),employee,dateSondage);

		//sondage lieu
		Sondage_lieu sondage_lieu= new Sondage_lieu("IA",new Date(),employee,lieuSondage);

		//sondage lieu et date
		Sondage_lieu_date sondage_lieu_date=new Sondage_lieu_date("Deep Learning",new Date(),employee,lieuSondage,dateSondage);

		manager.persist(department);
		manager.persist(employee);

		manager.persist(sondage_date);
		manager.persist(sondage_lieu);
		manager.persist(sondage_lieu_date);

	}

	private void createUserSondage(){
		Department departement= new Department("TR");
		Employee employee=new Employee("koupoh",departement);

		DateSondage dateSondage=new DateSondage(new Date(),new Date(),new Date());
		LieuSondage lieuSondage=new LieuSondage("cocody","marcory","angré");

		//sondage date
		Sondage_date sondage_date=new Sondage_date("Big Data",new Date(),employee,dateSondage);

		//sondage lieu
		Sondage_lieu sondage_lieu= new Sondage_lieu("IA",new Date(),employee,lieuSondage);

		//sondage lieu et date
		Sondage_lieu_date sondage_lieu_date=new Sondage_lieu_date("Deep Learning",new Date(),employee,lieuSondage,dateSondage);

		User_sondageDate  user_sondageDate=new User_sondageDate(employee,sondage_date,dateSondage.getDate1());
		User_sondageLieu user_sondageLieu=new User_sondageLieu(employee,sondage_date,lieuSondage.getLieu1());
		User_sondageLieuDate user_sondageLieuDate=new User_sondageLieuDate(employee,sondage_date,lieuSondage.getLieu1(),dateSondage.getDate1());

		manager.persist(departement);
		manager.persist(employee);

		manager.persist(sondage_date);
		manager.persist(sondage_lieu);
		manager.persist(sondage_lieu_date);
		manager.persist(user_sondageDate);
		manager.persist(user_sondageLieu);
		manager.persist(user_sondageLieuDate);


		//List<Sondage> resultListSondage = manager.createQuery("Select a From Sondage a",
		//		Sondage.class).getResultList();
	//	List<DateSondage> resultListDate = manager.createQuery("Select a From DateSondage a",
	//			DateSondage.class).getResultList();
		//if (resultListDate.size()!=0) {
		//	if (resultListSondage.size()!=0)
		//	User_sondage user_sondage = new User_sondage(employee,resultListDate.get(0));
		//	manager.persist(sondage);
		//}else {

		//}

		//User_sondage user_sondage=new Sondage_date(employee,sondage,new Date());
	//	manager.persist(user_sondage);
	}

	private void listEmployees() {
		List<Employee> resultList = manager.createQuery("Select a From Employee a",
				Employee.class).getResultList();
		System.out.println("num of employess:" + resultList.size());
		for (Employee next : resultList) {
			System.out.println("next employee: " + next);
		}
	}
	private void listSondageLieu(){
		//test pour voir si on peut avoir accès aux autres tables

		List<Sondage> resultList = manager.createQuery("Select a From Sondage a",
				Sondage.class).getResultList();

		for (Sondage next : resultList) {
			if (next instanceof Sondage_lieu){
;
				System.out.println("kammme: " + ((Sondage_lieu) next).getLieuSondage().getLieu1());
			}

		}

	}

	private void createUserReunion(){

	}
}
