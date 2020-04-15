package test.testjpa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Sondage implements Serializable {

    private Long sondage_id;
    private String intitule_sondage;
    private Date date_sondage;
    private Employee employee;

    public Sondage() {

    }

    public Sondage(String intitule_son, Date date, Employee employee) {
        this.intitule_sondage = intitule_son;
        this.date_sondage=date;
        this.employee = employee;
    }

    @Id
    @GeneratedValue
    public Long getSondage_id() {
        return sondage_id;
    }

    public void setSondage_id(Long sondage_id) {
        this.sondage_id = sondage_id;
    }

    public String getIntitule_son() {
        return intitule_sondage;
    }

    public void setIntitule_son(String intitule_son) {
        this.intitule_sondage = intitule_son;
    }

    public Date getDate_sondage() {
        return date_sondage;
    }

    public void setDate_sondage(Date date_sondage) {
        this.date_sondage = date_sondage;
    }

    @ManyToOne
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
