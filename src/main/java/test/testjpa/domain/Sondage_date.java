package test.testjpa.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Sondage_date extends Sondage implements Serializable {

    private DateSondage dateSondage;

    public Sondage_date() {
        super();
    }

    public Sondage_date(String intitule_son, Date date, Employee employee, DateSondage dateSondage) {
        super(intitule_son, date, employee);
        this.dateSondage = dateSondage;
    }

    @OneToOne
    public DateSondage getDateSondage() {
        return dateSondage;
    }

    public void setDateSondage(DateSondage dateSondage) {
        this.dateSondage = dateSondage;
    }
}