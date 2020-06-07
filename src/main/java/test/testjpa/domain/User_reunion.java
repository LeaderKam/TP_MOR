package test.testjpa.domain;

import javax.persistence.*;

@Entity
public class User_reunion {

    private Long user_reunion_id;
    private Employee employee;
    private Reunion reunion;
    private String allergie;

    public User_reunion() {

    }

    public User_reunion(Employee employee, Reunion reunion,String allergie) {
        this.employee = employee;
        this.reunion = reunion;
        this.allergie=allergie;
    }

    @Id
    @GeneratedValue
    public Long getUser_reunion_id() {
        return user_reunion_id;
    }

    public void setUser_reunion_id(Long user_reunion_id) {
        this.user_reunion_id = user_reunion_id;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @ManyToOne
    public Reunion getReunion() {
        return reunion;
    }

    public void setReunion(Reunion reunion) {
        this.reunion = reunion;
    }

    public String getAllergie() {
        return allergie;
    }

    public void setAllergie(String allergie) {
        this.allergie = allergie;
    }
}