package com.dictionary.model;

public class Dictionary {
    private int id;
    private String e;
    private String v;

    public Dictionary() {
    }

    public Dictionary(String e, String v) {
        this.e = e;
        this.v = v;
    }

    public Dictionary(int id, String e, String v) {
        this.id = id;
        this.e = e;
        this.v = v;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getE() {
        return e;
    }

    public void setE(String e) {
        this.e = e;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }
}
