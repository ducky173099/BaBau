package com.example.babauactivity.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;

public class DataNameSon {
    private int id;
    private String Nameson;
    private String Ynghia;
    private int isstar ;
    private int sex;

    public DataNameSon(int id, String nameson, String ynghia, int isstar, int sex) {
        this.id = id;
        Nameson = nameson;
        Ynghia = ynghia;
        this.isstar = isstar;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameson() {
        return Nameson;
    }

    public void setNameson(String nameson) {
        Nameson = nameson;
    }

    public String getYnghia() {
        return Ynghia;
    }

    public void setYnghia(String ynghia) {
        Ynghia = ynghia;
    }

    public int getIsstar() {
        return isstar;
    }

    public void setIsstar(int isstar) {
        this.isstar = isstar;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}
