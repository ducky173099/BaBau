package com.example.babauactivity.model;

public class DataHoatdong {
    private int Hinh;
    private String Desc;
    private String Val;
    private String Content;

    public DataHoatdong(int hinh, String desc, String val, String content) {
        Hinh = hinh;
        Desc = desc;
        Val = val;
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

    public String getVal() {
        return Val;
    }

    public void setVal(String val) {
        Val = val;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
