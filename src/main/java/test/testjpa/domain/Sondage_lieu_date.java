package test.testjpa.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Sondage_lieu_date extends User_sondage implements Serializable {

    private String sondage_lieu_date;
    private Date sondage_date;
    public Sondage_lieu_date() {
        super();
    }

    public Sondage_lieu_date(Employee employee, Sondage sondage, String sondage_lieu_date, Date sondage_date) {
        super(employee, sondage);
        this.sondage_lieu_date = sondage_lieu_date;
        this.sondage_date = sondage_date;
    }

    public String getSondage_lieu_date() {
        return sondage_lieu_date;
    }

    public void setSondage_lieu_date(String sondage_lieu_date) {
        this.sondage_lieu_date = sondage_lieu_date;
    }

    public Date getSondage_date() {
        return sondage_date;
    }

    public void setSondage_date(Date sondage_date) {
        this.sondage_date = sondage_date;
    }
}