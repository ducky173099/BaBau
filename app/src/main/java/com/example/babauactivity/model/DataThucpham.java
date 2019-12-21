package com.example.babauactivity.model;

public class DataThucpham {
    private int Hinh;
    private String Desc;
    private String Content;

    public DataThucpham(int hinh, String desc, String content) {
        Hinh = hinh;
        Desc = desc;
        Content = content;
    }

    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
