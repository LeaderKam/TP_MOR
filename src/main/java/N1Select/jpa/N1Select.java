package N1Select.jpa;


import test.testjpa.domain.Department;
import test.testjpa.domain.Employee;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


public class N1Select {

	private EntityManager manager;

	public N1Select(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("withoutcreate");
		EntityManager manager = factory.createEntityManager();
		N1Select test = new N1Select(manager);

		
		TypedQuery<Department> q = test.manager.createQuery("select d from Department d",Department.class);
		long start = System.currentTimeMillis();
		List<Department> res = q.getResultList();
		
		
		for (Department d : res){
			for (Employee e : d.getEmployees()){
				e.getName();
			}
		}

		long end = System.currentTimeMillis();
		long duree = end - start;
		System.err.println("temps d'exec = " +  duree);

		// TODO persist entity


		// TODO run request

		System.out.println(".. done");
	}

}
