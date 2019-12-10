package com.example.babauactivity.model;

public class DataMom {
    private int Hinhmom;
    private String Tenmom;

    public DataMom(int hinhmom, String tenmom) {
        Hinhmom = hinhmom;
        Tenmom = tenmom;
    }

    public int getHinhmom() {
        return Hinhmom;
    }

    public void setHinhmom(int hinhmom) {
        Hinhmom = hinhmom;
    }

    public String getTenmom() {
        return Tenmom;
    }

    public void setTenmom(String tenmom) {
        Tenmom = tenmom;
    }
}
