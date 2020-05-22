package test.testjpa.domain;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

@Entity
public class User_sondageDate extends User_sondage implements Serializable {
    private Date dateChoisi;

    public User_sondageDate() {
        super();
    }

    public User_sondageDate(Employee employee, Sondage sondage, Date dateChoisi) {
        super(employee, sondage);
        this.dateChoisi = dateChoisi;
    }

    public Date getDateChoisi() {
        return dateChoisi;
    }

    public void setDateChoisi(Date dateChoisi) {
        this.dateChoisi = dateChoisi;
    }
}
