package test.testjpa.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class User_sondage {

    private Long user_sondage_id;
    private Employee employee;
    private Sondage sondage;

    public User_sondage() {

    }

    public User_sondage(Employee employee, Sondage sondage) {
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

}
