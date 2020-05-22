package test.testjpa.domain;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

@Entity
public class User_sondageLieuDate extends User_sondage implements Serializable {
    private String lieuChoisi;
    private Date dateChoisi;

    public User_sondageLieuDate() {
        super();
    }

    public User_sondageLieuDate(Employee employee, Sondage sondage, String lieuChoisi, Date dateChoisi) {
        super(employee, sondage);
        this.lieuChoisi = lieuChoisi;
        this.dateChoisi = dateChoisi;
    }

    public String getLieuChoisi() {
        return lieuChoisi;
    }

    public void setLieuChoisi(String lieuChoisi) {
        this.lieuChoisi = lieuChoisi;
    }

    public Date getDateChoisi() {
        return dateChoisi;
    }

    public void setDateChoisi(Date dateChoisi) {
        this.dateChoisi = dateChoisi;
    }
}
