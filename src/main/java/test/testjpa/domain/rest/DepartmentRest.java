/**
 * 
 */
package test.testjpa.domain.rest;

import org.codehaus.jackson.annotate.JsonManagedReference;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class DepartmentRest {
	private Long id;
	private String name;
	private List<EmployeeRest> employees = new ArrayList<EmployeeRest>();

	public DepartmentRest() {
		super();
	}

	public DepartmentRest(String name) {
		this.name = name;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(mappedBy = "department")
	@JsonManagedReference
	public List<EmployeeRest> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeRest> employees) {
		this.employees = employees;
	}

}
