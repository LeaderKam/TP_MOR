package test.testjpa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class Sondage implements Serializable {

    private Long sondage_id;
    private String intitule_son;
    private Employee employee;

    public Sondage(Long sondage_id) {

    }

    public Sondage(Long sondage_id, String intitule_son, Employee employee) {
        this.sondage_id = sondage_id;
        this.intitule_son = intitule_son;
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
        return intitule_son;
    }

    public void setIntitule_son(String intitule_son) {
        this.intitule_son = intitule_son;
    }

    @ManyToOne
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
