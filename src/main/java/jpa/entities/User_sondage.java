package jpa.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class User_sondage {

	private Date date_voulu;
	
	private Integer user_sondage_id;
	
	private User user;
	
	private Sondage sondage;

	
	public User_sondage() {
		super();
		
	}
	
	public User_sondage(Date date_voulu, Integer user_sondage_id, User user) {
		super();
		this.date_voulu = date_voulu;
		this.user_sondage_id = user_sondage_id;
		this.user = user;
	}

	public Date getDate_voulu() {
		return date_voulu;
	}

	public void setDate_voulu(Date date_voulu) {
		this.date_voulu = date_voulu;
	}

	@Id
	@GeneratedValue
	public Integer getUser_sondage_id() {
		return user_sondage_id;
	}

	public void setUser_sondage_id(Integer user_sondage_id) {
		this.user_sondage_id = user_sondage_id;
	}

	@ManyToOne
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne
	public Sondage getSondage() {
		return sondage;
	}

	public void setSondage(Sondage sondage) {
		this.sondage = sondage;
	}
	
	
	
}
