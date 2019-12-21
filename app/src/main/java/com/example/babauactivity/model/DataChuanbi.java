package com.example.babauactivity.model;

public class DataChuanbi {
    private int Hinh;
    private String Content;

    public DataChuanbi(int hinh, String content) {
        Hinh = hinh;
        Content = content;
    }

    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
