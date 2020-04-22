package test.testjpa.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Sondage implements Serializable {

    private Long sondage_id;
    private String intitule_sondage;
    private Date date_sondage;
    private Employee employee;
    private List<User_sondage> user_sondages=new ArrayList<User_sondage>();

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

    @OneToMany(mappedBy = "employee",cascade = CascadeType.PERSIST)
    public List<User_sondage> getUser_sondages() {
        return user_sondages;
    }

    public void setUser_sondages(List<User_sondage> user_sondages) {
        this.user_sondages = user_sondages;
    }
}
