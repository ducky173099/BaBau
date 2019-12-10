package com.example.babauactivity.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "image")
public class DataFeet {
    private int Hinhtt;
    private String Timer;
    private String Realtime;
    private String Feet;

    public DataFeet(int hinhtt, String timer, String realtime, String feet) {
        Hinhtt = hinhtt;
        Timer = timer;
        Realtime = realtime;
        Feet = feet;

    }

    public int getHinhtt() {
        return Hinhtt;
    }

    public void setHinhtt(int hinhtt) {
        Hinhtt = hinhtt;
    }

    public String getTimer() {
        return Timer;
    }

    public void setTimer(String timer) {
        Timer = timer;
    }

    public String getRealtime() {
        return Realtime;
    }

    public void setRealtime(String realtime) {
        Realtime = realtime;
    }

    public String getFeet() {
        return Feet;
    }

    public void setFeet(String feet) {
        Feet = feet;
    }

}
