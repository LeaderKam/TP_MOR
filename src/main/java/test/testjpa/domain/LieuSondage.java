package test.testjpa.domain;

import javax.persistence.*;

@Entity
public class LieuSondage {

    private Long lieuSondageId;
    private String lieu1;
    private String lieu2;
    private String lieu3;

    private Sondage_lieu sondage_lieu;
    private Sondage_lieu_date sondage_lieu_date;

    public LieuSondage() {
    }

    public LieuSondage(String lieu1, String lieu2, String lieu3) {
        this.lieu1 = lieu1;
        this.lieu2 = lieu2;
        this.lieu3 = lieu3;
    }

    @Id
    @GeneratedValue
    public Long getLieuSondageId() {
        return lieuSondageId;
    }

    public void setLieuSondageId(Long lieuSondageId) {
        this.lieuSondageId = lieuSondageId;
    }

    public String getLieu1() {
        return lieu1;
    }

    public void setLieu1(String lieu1) {
        this.lieu1 = lieu1;
    }

    public String getLieu2() {
        return lieu2;
    }

    public void setLieu2(String lieu2) {
        this.lieu2 = lieu2;
    }

    public String getLieu3() {
        return lieu3;
    }

    public void setLieu3(String lieu3) {
        this.lieu3 = lieu3;
    }

    @OneToOne
    public Sondage_lieu getSondage_lieu() {
        return sondage_lieu;
    }

    public void setSondage_lieu(Sondage_lieu sondage_lieu) {
        this.sondage_lieu = sondage_lieu;
    }

    @OneToOne
    public Sondage_lieu_date getSondage_lieu_date() {
        return sondage_lieu_date;
    }

    public void setSondage_lieu_date(Sondage_lieu_date sondage_lieu_date) {
        this.sondage_lieu_date = sondage_lieu_date;
    }
}
