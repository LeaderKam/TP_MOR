package jpa.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Sondage implements Serializable {
	
	
	private Integer sondage_id;
	
	private String intitule_sondage;
	
	private Date date_sondage;
	
	private List<User_sondage> user_sondages = new ArrayList<User_sondage>();
	

	@OneToMany(mappedBy="sondage",fetch=FetchType.LAZY)
	public List<User_sondage> getUser_sondages() {
		return user_sondages;
	}

	public void setUser_sondages(List<User_sondage> user_sondages) {
		this.user_sondages = user_sondages;
	}

	public Sondage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sondage(String intitule_sondage, Date date_sondage) {
		super();
		this.intitule_sondage = intitule_sondage;
		this.date_sondage = date_sondage;
	}

	@Id
	@GeneratedValue
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

	public Date getDate_sondage() {
		return date_sondage;
	}

	public void setDate_sondage(Date date_sondage) {
		this.date_sondage = date_sondage;
	}

	
	
	
	
	
}
