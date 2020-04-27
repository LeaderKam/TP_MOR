package test.testjpa.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Sondage_date extends User_sondage implements Serializable {

    private Date sondage_date;

    public Sondage_date() {
        super();
    }

    public Sondage_date(Employee employee, Sondage sondage, Date sondage_date) {
        super(employee, sondage);
        this.sondage_date = sondage_date;
    }

    public Date getSondage_date() {
        return sondage_date;
    }

    public void setSondage_date(Date sondage_date) {
        this.sondage_date = sondage_date;
    }
}