package test.testjpa.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Sondage_lieu_date extends Sondage implements Serializable {

    private LieuSondage lieuSondage;
    private DateSondage dateSondage;
    public Sondage_lieu_date() {
        super();
    }

    public Sondage_lieu_date(String intitule_son, Date date, Employee employee, LieuSondage lieuSondage, DateSondage dateSondage) {
        super(intitule_son, date, employee);
        this.lieuSondage = lieuSondage;
        this.dateSondage = dateSondage;
    }

    @OneToOne
    public LieuSondage getLieuSondage() {
        return lieuSondage;
    }

    public void setLieuSondage(LieuSondage lieuSondage) {
        this.lieuSondage = lieuSondage;
    }

    @OneToOne
    public DateSondage getDateSondage() {
        return dateSondage;
    }

    public void setDateSondage(DateSondage dateSondage) {
        this.dateSondage = dateSondage;
    }
}