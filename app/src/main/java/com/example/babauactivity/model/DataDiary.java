package com.example.babauactivity.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

import androidx.annotation.NonNull;

public class DataDiary {
//    public static final String TABLE_NAME = "diary";
//
//    public static final String COLUMN_ID = "id";
//    public static final String COLUMN_TIMESTAMP = "time";
//    public static final String COLUMN_CONTENT = "content";
//    public static final String COLUMN_IMAGE = "image";

    private int id;
    private String Time;
    private String Content;
    private byte[] ImgDiary;

//    public static final String CREATE_TABLE =
//            "CREATE TABLE " + TABLE_NAME + "("
//                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
//                    + COLUMN_TIMESTAMP + " TEXT,"
//                    + COLUMN_CONTENT + " TEXT,"
//                    + COLUMN_IMAGE + " BLOB"
//                    + ")";

    public DataDiary(int id, String time, String content, byte[] imgDiary) {
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

    public byte[] getImgDiary() {
        return ImgDiary;
    }

    public void setImgDiary(byte[] imgDiary) {
        ImgDiary = imgDiary;
    }
}
