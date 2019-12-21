package com.example.babauactivity.model;

public class DataCannang {
    private int Hinh;
    private String Time;
    private String Cannang;

    public DataCannang(int hinh, String time, String cannang) {
        Hinh = hinh;
        Time = time;
        Cannang = cannang;
    }

    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getCannang() {
        return Cannang;
    }

    public void setCannang(String cannang) {
        Cannang = cannang;
    }
}
