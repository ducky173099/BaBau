package com.example.babauactivity.model;

public class DataShop {
    private int id;
    private String Desc;
    private String Contet;
    private int isstar ;
    private int type;

    public DataShop(int id, String desc, String contet, int isstar, int type) {
        this.id = id;
        Desc = desc;
        Contet = contet;
        this.isstar = isstar;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public String getContet() {
        return Contet;
    }

    public void setContet(String contet) {
        Contet = contet;
    }

    public int getIsstar() {
        return isstar;
    }

    public void setIsstar(int isstar) {
        this.isstar = isstar;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
