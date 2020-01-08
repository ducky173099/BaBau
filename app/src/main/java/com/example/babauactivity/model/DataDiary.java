package com.example.babauactivity.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

import androidx.annotation.NonNull;

public class DataDiary {

    private int id;
    private String Time;
    private String Content;
    private String ImgDiary;

    public DataDiary(int id, String time, String content, String imgDiary) {
        this.id = id;
        Time = time;
        Content = content;
        ImgDiary = imgDiary;
    }

    public DataDiary() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getImgDiary() {
        return ImgDiary;
    }

    public void setImgDiary(String imgDiary) {
        ImgDiary = imgDiary;
    }
}
