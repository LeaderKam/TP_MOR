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
public class User implements Serializable {


	private Integer user_id;

	private String nom;

	private String prenom;
	

	private List<User_sondage> user_sondages = new ArrayList<User_sondage>();


	private List<Reunion> reunions= new ArrayList<Reunion>();

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	@Id
	@GeneratedValue
	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_reunion", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "reunion_id") })
	public List<Reunion> getReunions() {
		return reunions;
	}

	public void setReunions(List<Reunion> reunions) {
		this.reunions = reunions;
	}

	@OneToMany(mappedBy="user",fetch=FetchType.LAZY)
	public List<User_sondage> getUser_sondages() {
		return user_sondages;
	}

	public void setUser_sondages(List<User_sondage> user_sondages) {
		this.user_sondages = user_sondages;
	}


	
	
	
	

}
