package com.example.babauactivity.model;

import java.io.Serializable;

public class DataPicturebaby implements Serializable {

    private int Hinh;

    public DataPicturebaby(int hinh) {
        Hinh = hinh;
    }


    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }
}
