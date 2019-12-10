package com.example.babauactivity.model;

import java.io.Serializable;

public class DataChild implements Serializable {
    private int Hinhchild;
    private String Tenchild;

    public DataChild(int hinhchild, String tenchild) {
        Hinhchild = hinhchild;
        Tenchild = tenchild;
    }

    public int getHinhchild() {
        return Hinhchild;
    }

    public void setHinhchild(int hinhchild) {
        Hinhchild = hinhchild;
    }

    public String getTenchild() {
        return Tenchild;
    }

    public void setTenchild(String tenchild) {
        Tenchild = tenchild;
    }
}
