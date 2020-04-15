package test.testjpa.domain;

import javax.persistence.*;

/**
 * @author sievi
 *
 */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employee implements Serializable {
	
	
	private Long user_id;
	private String name;
	private List<Sondage> sondages=new ArrayList<Sondage>();
	private Department department;
	private List<User_reunion> user_reunions=new ArrayList<User_reunion>();

	public Employee() {

	}

	public Employee(String name, Department department) {
		this.name = name;
		this.department = department;
	}

	public Employee(String name) {
		this.name = name;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return user_id;
	}

	public void setId(Long id) {
		this.user_id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@OneToMany(mappedBy = "employee", cascade = CascadeType.PERSIST)
	public List<Sondage> getSondages() {
		return sondages;
	}

	public void setSondages(List<Sondage> sondages) {
		this.sondages = sondages;
	}

	@OneToMany(mappedBy = "employee",cascade = CascadeType.PERSIST)
	public List<User_reunion> getUser_reunions() {
		return user_reunions;
	}

	public void setUser_reunions(List<User_reunion> user_reunions) {
		this.user_reunions = user_reunions;
	}

	@Override
	public String toString() {
		return "Employee [id=" + user_id + ", name=" + name + ", department=" + department.getName() + "]";
	}
}
