package com.example.babauactivity.model;

public class DataInject {
    private int Hinhinject;
    private String Old;
    private String Contetn;

    public DataInject(int hinhinject, String old, String contetn) {
        Hinhinject = hinhinject;
        Old = old;
        Contetn = contetn;
    }

    public int getHinhinject() {
        return Hinhinject;
    }

    public void setHinhinject(int hinhinject) {
        Hinhinject = hinhinject;
    }

    public String getOld() {
        return Old;
    }

    public void setOld(String old) {
        Old = old;
    }

    public String getContetn() {
        return Contetn;
    }

    public void setContetn(String contetn) {
        Contetn = contetn;
    }
}
