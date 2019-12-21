package com.example.babauactivity.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

import androidx.annotation.NonNull;

public class DataDiary {

    private String Time;
    private String Content;
    private byte[] ImgDiary;

    public DataDiary(String time, String content, byte[] imgDiary) {
        Time = time;
        Content = content;
        ImgDiary = imgDiary;
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

    public byte[] getImgDiary() {
        return ImgDiary;
    }

    public void setImgDiary(byte[] imgDiary) {
        ImgDiary = imgDiary;
    }
}
