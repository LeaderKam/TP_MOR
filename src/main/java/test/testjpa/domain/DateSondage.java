package test.testjpa.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class DateSondage {

    private Long dateSondageId;
    private Date date1;
    private Date date2;
    private Date date3;

    public DateSondage() {
    }

    public DateSondage(Date date1, Date date2, Date date3) {
        this.date1 = date1;
        this.date2 = date2;
        this.date3 = date3;
    }

    @Id
    @GeneratedValue
    public Long getDateSondageId() {
        return dateSondageId;
    }

    public void setDateSondageId(Long dateSondageId) {
        this.dateSondageId = dateSondageId;
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }

    public Date getDate3() {
        return date3;
    }

    public void setDate3(Date date3) {
        this.date3 = date3;
    }
}