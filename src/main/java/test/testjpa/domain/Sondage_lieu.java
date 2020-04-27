package test.testjpa.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Sondage_lieu extends User_sondage implements Serializable {

    private String sondage_lieu;

    public Sondage_lieu() {
        super();
    }

    public Sondage_lieu(Employee employee, Sondage sondage, String sondage_lieu) {
        super(employee, sondage);
        this.sondage_lieu = sondage_lieu;
    }

    public String getSondage_lieu() {
        return sondage_lieu;
    }

    public void setSondage_lieu(String sondage_lieu) {
        this.sondage_lieu = sondage_lieu;
    }
}