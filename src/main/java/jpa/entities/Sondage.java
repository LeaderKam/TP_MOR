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

@Entity
public class Sondage implements Serializable {
	
	@Id
	@GeneratedValue
	private Integer sondage_id;
	
	private String intitule_sondage;
	
	private String date_sondage;
	
	@ManyToMany(mappedBy="sondages",fetch=FetchType.LAZY)
	private List<User> users = new ArrayList<User>();
	

	public Sondage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sondage(String intitule_sondage, String date_sondage) {
		super();
		this.intitule_sondage = intitule_sondage;
		this.date_sondage = date_sondage;
	}

	public Integer getSondage_id() {
		return sondage_id;
	}

	public void setSondage_id(Integer sondage_id) {
		this.sondage_id = sondage_id;
	}

	public String getIntitule_sondage() {
		return intitule_sondage;
	}

	public void setIntitule_sondage(String intitule_sondage) {
		this.intitule_sondage = intitule_sondage;
	}

	public String getDate_sondage() {
		return date_sondage;
	}

	public void setDate_sondage(String date_sondage) {
		this.date_sondage = date_sondage;
	}
	
	
	
	
}
