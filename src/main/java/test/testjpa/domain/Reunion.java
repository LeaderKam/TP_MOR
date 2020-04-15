package test.testjpa.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Reunion {
    private Long reunion_id;
    private String intitule_reunion;
    private Date date_reunion;
    private List<User_reunion> user_reunions=new ArrayList<User_reunion>();


    public Reunion() {

    }

    public Reunion(String intitule_reunion, Date date_reunion) {
        this.intitule_reunion = intitule_reunion;
        this.date_reunion = date_reunion;
    }

    @Id
    @GeneratedValue
    public Long getReunion_id() {
        return reunion_id;
    }

    public void setReunion_id(Long reunion_id) {
        this.reunion_id = reunion_id;
    }

    public String getIntitule_reunion() {
        return intitule_reunion;
    }

    public void setIntitule_reunion(String intitule_reunion) {
        this.intitule_reunion = intitule_reunion;
    }

    public Date getDate_reunion() {
        return date_reunion;
    }

    public void setDate_reunion(Date date_reunion) {
        this.date_reunion = date_reunion;
    }

    @OneToMany(mappedBy = "reunion",cascade = CascadeType.PERSIST)
    public List<User_reunion> getUser_reunion() {
        return user_reunions;
    }

    public void setUser_reunion(List<User_reunion> user_reunions) {
        this.user_reunions = user_reunions;
    }
}
