package com.example.babauactivity.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void QueryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

    public Cursor GetData(String sql){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);
    }

    // dung de insert thuoc tinh hinh anh
    public void INSERT_DIARY(String time, String content, byte[] hinh){ // nhan vao ten, mota va hinh
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO diary VALUES(null, ?, ?, ?)"; // ? lan luot la: ten, mota va hinh
        // bien dich sql o tren
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings(); // phan nao phan tich du lieu xong thi clear no

        statement.bindString(1, time); // nhan vao 1 index va string, thi null=0,ten=1,mota=2...
        statement.bindString(2, content);
        statement.bindBlob(3, hinh);
        statement.executeInsert(); // thuc thi lenh insert

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
