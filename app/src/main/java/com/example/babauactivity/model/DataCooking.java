package com.example.babauactivity.model;

public class DataCooking {
    private int id;
    private String DescCook;
    private String ContentCook;
    private int isstar ;

    public DataCooking(int id, String descCook, String contentCook, int isstar) {
        this.id = id;
        DescCook = descCook;
        ContentCook = contentCook;
        this.isstar = isstar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescCook() {
        return DescCook;
    }

    public void setDescCook(String descCook) {
        DescCook = descCook;
    }

    public String getContentCook() {
        return ContentCook;
    }

    public void setContentCook(String contentCook) {
        ContentCook = contentCook;
    }

    public int getIsstar() {
        return isstar;
    }

    public void setIsstar(int isstar) {
        this.isstar = isstar;
    }
}
