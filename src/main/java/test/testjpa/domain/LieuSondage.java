package test.testjpa.domain;

import javax.persistence.*;

@Entity
public class LieuSondage {

    private Long lieuSondageId;
    private String lieu1;
    private String lieu2;
    private String lieu3;

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

}
