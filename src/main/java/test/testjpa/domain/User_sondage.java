package test.testjpa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class User_sondage {

    private Long user_sondage_id;
    private Employee employee;
    private Sondage sondage;
    private Date date_sondage;

    public User_sondage() {

    }

    public User_sondage(Employee employee, Sondage sondage,Date date) {
        this.date_sondage=date;
        this.employee = employee;
        this.sondage = sondage;
    }

    @Id
    @GeneratedValue
    public Long getUser_sondage_id() {
        return user_sondage_id;
    }

    public void setUser_sondage_id(Long user_sondage_id) {
        this.user_sondage_id = user_sondage_id;
    }

    @ManyToOne
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @ManyToOne
    public Sondage getSondage() {
        return sondage;
    }

    public void setSondage(Sondage sondage) {
        this.sondage = sondage;
    }

    public Date getDate_sondage() {
        return date_sondage;
    }

    public void setDate_sondage(Date date_sondage) {
        this.date_sondage = date_sondage;
    }
}
