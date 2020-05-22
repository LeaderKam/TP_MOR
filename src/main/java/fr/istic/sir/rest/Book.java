package fr.istic.sir.rest;

public class Book {
    int i;
    String s;
    String s1;
    int i1;

    public Book(int i, String s, String s1, int i1) {
        this.i = i;
        this.s = s;
        this.s1 = s1;
        this.i1 = i1;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String getS1() {
        return s1;
    }

    public void setS1(String s1) {
        this.s1 = s1;
    }

    public int getI1() {
        return i1;
    }

    public void setI1(int i1) {
        this.i1 = i1;
    }
}
