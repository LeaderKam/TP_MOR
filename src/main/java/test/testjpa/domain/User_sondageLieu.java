package test.testjpa.domain;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class User_sondageLieu extends User_sondage implements Serializable {
    private String lieuChoisi;

    public User_sondageLieu() {
        super();
    }

    public User_sondageLieu(Employee employee, Sondage sondage, String lieuChoisi) {
        super(employee, sondage);
        this.lieuChoisi = lieuChoisi;
    }

    public String getLieuChoisi() {
        return lieuChoisi;
    }

    public void setLieuChoisi(String lieuChoisi) {
        this.lieuChoisi = lieuChoisi;
    }
}
