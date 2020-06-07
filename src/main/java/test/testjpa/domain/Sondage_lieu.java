package test.testjpa.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Sondage_lieu extends Sondage implements Serializable {

    private LieuSondage lieuSondage;

    public Sondage_lieu() {
        super();
    }

    public Sondage_lieu(String intitule_son, Date date, Employee employee, LieuSondage lieuSondage) {
        super(intitule_son, date, employee);
        this.lieuSondage = lieuSondage;
    }

    @OneToOne(fetch = FetchType.EAGER)
    public LieuSondage getLieuSondage() {
        return lieuSondage;
    }

    public void setLieuSondage(LieuSondage lieuSondage) {
        this.lieuSondage = lieuSondage;
    }
}