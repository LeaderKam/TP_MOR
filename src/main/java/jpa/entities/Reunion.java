package jpa.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Reunion implements Serializable {
  
	
	private Integer reunion_id;
	
	private String intitule_reunion;
	private String resume_reunion;
	private String date_reunion;	
	
	
	private List<User> users= new ArrayList<User>(); 
	
	public Reunion() {
		super();
	}
	public Reunion(String intitule_reunion, String resume_reunion, String date_reunion) {
		super();
		this.intitule_reunion = intitule_reunion;
		this.resume_reunion = resume_reunion;
		this.date_reunion = date_reunion;
	}
	@Id
	@GeneratedValue
	public Integer getReunion_id() {
		return reunion_id;
	}
	public void setReunion_id(Integer reunion_id) {
		this.reunion_id = reunion_id;
	}
	public String getIntitule_reunion() {
		return intitule_reunion;
	}
	public void setIntitule_reunion(String intitule_reunion) {
		this.intitule_reunion = intitule_reunion;
	}
	public String getResume_reunion() {
		return resume_reunion;
	}
	public void setResume_reunion(String resume_reunion) {
		this.resume_reunion = resume_reunion;
	}
	public String getDate_reunion() {
		return date_reunion;
	}
	public void setDate_reunion(String date_reunion) {
		this.date_reunion = date_reunion;
	}
	
	@ManyToMany(mappedBy="reunions",fetch=FetchType.LAZY)
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
}
