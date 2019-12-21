package com.example.babauactivity.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import com.example.babauactivity.model.DataCooking;
import com.example.babauactivity.model.DataDiary;
import com.example.babauactivity.model.DataNameSon;
import com.example.babauactivity.model.DataNickName;
import com.example.babauactivity.model.DataShop;
import com.example.babauactivity.model.DataStory;

import java.sql.Blob;
import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DB_NAME ="babau.db";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }




    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

    public ArrayList<DataNameSon> getAll() {
        Log.d("log", "getAll: " );
        ArrayList<DataNameSon> list= new ArrayList<>();
        SQLiteDatabase mDatabase= getReadableDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM namebaby WHERE sex = 1",null);
        cursor.moveToFirst();
        Log.e("AAA", "getAll: "+cursor.moveToFirst() );
        while (!cursor.isAfterLast()){
            int id= cursor.getInt(0);
            String name=cursor.getString(1);
            String content = cursor.getString(2);
            int status= cursor.getInt(3);
            int sex= cursor.getInt(4);
            Log.d("log", "getAll: " + name);
            Log.d("log", "getAll: " + content);
            Log.d("log", "getAll: " + status);
            DataNameSon e= new DataNameSon(id,name,content,status,sex);
            list.add(e);
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public ArrayList<DataNameSon> getDauter() {

        ArrayList<DataNameSon> list= new ArrayList<>();
        SQLiteDatabase mDatabase= getReadableDatabase();
        Cursor cursor= mDatabase.rawQuery("SELECT * FROM namebaby WHERE sex = 2",null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int id= cursor.getInt(0);
            String name=cursor.getString(1);
            String content = cursor.getString(2);
            int status= cursor.getInt(3);
            int sex= cursor.getInt(4);

            Log.d("log", "getAll: " + name);
            Log.d("log", "getAll: " + content);
            Log.d("log", "getAll: " + status);
            DataNameSon e= new DataNameSon(id,name,content,status,sex);
            list.add(e);
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public ArrayList<DataNameSon> getLike() {
        ArrayList<DataNameSon> list= new ArrayList<>();

        SQLiteDatabase mDatabase= getReadableDatabase();
        Cursor cursor= mDatabase.rawQuery("SELECT * FROM namebaby  WHERE status = 1",null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int id= cursor.getInt(0);
            String name=cursor.getString(1);
            String content = cursor.getString(2);
            int status= cursor.getInt(3);
            int sex= cursor.getInt(4);

            Log.d("log", "getAll: " + name);
            Log.d("log", "getAll: " + content);
            Log.d("log", "getAll: " + status);
            DataNameSon e= new DataNameSon(id,name,content,status,sex);
            list.add(e);
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public ArrayList<DataNickName> getNickSon() {
        ArrayList<DataNickName> dataNickNames = new ArrayList<>();
        SQLiteDatabase mDatabase= getReadableDatabase();
        Cursor cursor= mDatabase.rawQuery("SELECT * FROM nickbaby WHERE sex = 1",null);
        cursor.moveToFirst();
        Log.e("AAA", "getAll: "+cursor.moveToFirst() );
        while (!cursor.isAfterLast()){
            int id= cursor.getInt(0);
            String name=cursor.getString(1);
            int status= cursor.getInt(2);
            int sex= cursor.getInt(3);
            Log.d("log", "getAll: " + name);
            Log.d("log", "getAll: " + status);
            DataNickName data = new DataNickName(id,name,status,sex);
            dataNickNames.add(data);
            cursor.moveToNext();
        }
        cursor.close();
        return dataNickNames;
    }

    public ArrayList<DataNickName> getNickDauter() {
        ArrayList<DataNickName> dataNickNames = new ArrayList<>();
        SQLiteDatabase mDatabase= getReadableDatabase();
        Cursor cursor= mDatabase.rawQuery("SELECT * FROM nickbaby WHERE sex = 2",null);
        cursor.moveToFirst();
        Log.e("AAA", "getAll: "+cursor.moveToFirst() );
        while (!cursor.isAfterLast()){
            int id= cursor.getInt(0);
            String name=cursor.getString(1);
            int status= cursor.getInt(2);
            int sex= cursor.getInt(3);
            Log.d("log", "getAll: " + name);
            Log.d("log", "getAll: " + status);
            DataNickName data = new DataNickName(id,name,status,sex);
            dataNickNames.add(data);
            cursor.moveToNext();
        }
        cursor.close();
        return dataNickNames;
    }

    public ArrayList<DataNickName> getNickLike() {
        ArrayList<DataNickName> dataNickNames = new ArrayList<>();
        SQLiteDatabase mDatabase= getReadableDatabase();
        Cursor cursor= mDatabase.rawQuery("SELECT * FROM nickbaby WHERE status = 1",null);
        cursor.moveToFirst();
        Log.e("AAA", "getAll: "+cursor.moveToFirst() );
        while (!cursor.isAfterLast()){
            int id= cursor.getInt(0);
            String name=cursor.getString(1);
            int status= cursor.getInt(2);
            int sex= cursor.getInt(3);
            Log.d("log", "getAll: " + name);
            Log.d("log", "getAll: " + status);
            DataNickName data = new DataNickName(id,name,status,sex);
            dataNickNames.add(data);
            cursor.moveToNext();
        }
        cursor.close();
        return dataNickNames;
    }

    public ArrayList<DataCooking> getCooking() {
        ArrayList<DataCooking> dataCookings = new ArrayList<>();
        SQLiteDatabase mDatabase= getReadableDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM cooking",null);
        cursor.moveToFirst();
        Log.e("AAA", "getAll: "+cursor.moveToFirst() );
        while (!cursor.isAfterLast()){
            int id= cursor.getInt(0);
            String name=cursor.getString(1);
            String content = cursor.getString(2);
            int status= cursor.getInt(3);

            DataCooking data = new DataCooking(id,name,content,status);
            dataCookings.add(data);
            cursor.moveToNext();
        }
        cursor.close();
        return dataCookings;
    }

    public ArrayList<DataCooking> getCookLike() {
        ArrayList<DataCooking> dataCookings = new ArrayList<>();
        SQLiteDatabase mDatabase= getReadableDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM cooking WHERE status = 1",null);
        cursor.moveToFirst();
        Log.e("AAA", "getAll: "+cursor.moveToFirst() );
        while (!cursor.isAfterLast()){
            int id= cursor.getInt(0);
            String name=cursor.getString(1);
            String content = cursor.getString(2);
            int status= cursor.getInt(3);

            DataCooking data = new DataCooking(id,name,content,status);
            dataCookings.add(data);
            cursor.moveToNext();
        }
        cursor.close();
        return dataCookings;
    }

    public ArrayList<DataShop> getShopbaby() {
        Log.d("log", "getAll: " );
        ArrayList<DataShop> dataShops= new ArrayList<>();
        SQLiteDatabase mDatabase= getReadableDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM shop WHERE type = 1",null);
        cursor.moveToFirst();
        Log.e("AAA", "getAll: "+cursor.moveToFirst() );
        while (!cursor.isAfterLast()){
            int id = cursor.getInt(0);
            String name =cursor.getString(1);
            String content = cursor.getString(2);
            int status = cursor.getInt(3);
            int type = cursor.getInt(4);

            DataShop e= new DataShop(id,name,content,status,type);
            dataShops.add(e);
            cursor.moveToNext();
        }
        cursor.close();
        return dataShops;
    }

    public ArrayList<DataShop> getShopmom() {
        Log.d("log", "getAll: " );
        ArrayList<DataShop> dataShops= new ArrayList<>();
        SQLiteDatabase mDatabase= getReadableDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM shop WHERE type = 2",null);
        cursor.moveToFirst();
        Log.e("AAA", "getAll: "+cursor.moveToFirst() );
        while (!cursor.isAfterLast()){
            int id = cursor.getInt(0);
            String name =cursor.getString(1);
            String content = cursor.getString(2);
            int status = cursor.getInt(3);
            int type = cursor.getInt(4);

            DataShop e= new DataShop(id,name,content,status,type);
            dataShops.add(e);
            cursor.moveToNext();
        }
        cursor.close();
        return dataShops;
    }

    public ArrayList<DataShop> getShopsk() {
        Log.d("log", "getAll: " );
        ArrayList<DataShop> dataShops= new ArrayList<>();
        SQLiteDatabase mDatabase= getReadableDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM shop WHERE type = 3",null);
        cursor.moveToFirst();
        Log.e("AAA", "getAll: "+cursor.moveToFirst() );
        while (!cursor.isAfterLast()){
            int id = cursor.getInt(0);
            String name =cursor.getString(1);
            String content = cursor.getString(2);
            int status = cursor.getInt(3);
            int type = cursor.getInt(4);

            DataShop e= new DataShop(id,name,content,status,type);
            dataShops.add(e);
            cursor.moveToNext();
        }
        cursor.close();
        return dataShops;
    }

    public ArrayList<DataShop> getShopBuy() {
        Log.d("log", "getAll: " );
        ArrayList<DataShop> dataShops= new ArrayList<>();
        SQLiteDatabase mDatabase= getReadableDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM shop WHERE status = 1",null);
        cursor.moveToFirst();
        Log.e("AAA", "getAll: "+cursor.moveToFirst() );
        while (!cursor.isAfterLast()){
            int id = cursor.getInt(0);
            String name =cursor.getString(1);
            String content = cursor.getString(2);
            int status = cursor.getInt(3);
            int type = cursor.getInt(4);

            DataShop e= new DataShop(id,name,content,status,type);
            dataShops.add(e);
            cursor.moveToNext();
        }
        cursor.close();
        return dataShops;
    }

    public ArrayList<DataStory> getStory() {
        ArrayList<DataStory> dataStories = new ArrayList<>();
        SQLiteDatabase mDatabase= getReadableDatabase();
        Cursor cursor= mDatabase.rawQuery("SELECT * FROM story",null);
        cursor.moveToFirst();
        Log.e("AAA", "getAll: "+cursor.moveToFirst() );
        while (!cursor.isAfterLast()){
            int id= cursor.getInt(0);
            String name=cursor.getString(1);
            int status= cursor.getInt(2);

            DataStory data = new DataStory(id,name,status);
            dataStories.add(data);
            cursor.moveToNext();
        }
        cursor.close();
        return dataStories;
    }

    public ArrayList<DataStory> getStoryHis() {
        ArrayList<DataStory> dataStories = new ArrayList<>();
        SQLiteDatabase mDatabase= getReadableDatabase();
        Cursor cursor= mDatabase.rawQuery("SELECT * FROM story WHERE status = 1",null);
        cursor.moveToFirst();
        Log.e("AAA", "getAll: "+cursor.moveToFirst() );
        while (!cursor.isAfterLast()){
            int id= cursor.getInt(0);
            String name=cursor.getString(1);
            int status= cursor.getInt(2);

            DataStory data = new DataStory(id,name,status);
            dataStories.add(data);
            cursor.moveToNext();
        }
        cursor.close();
        return dataStories;
    }

//    public ArrayList<DataDiary> getDiary(String time, String content) {
//        ArrayList<DataDiary> dataDiaries = new ArrayList<>();
//        SQLiteDatabase mDatabase= getReadableDatabase();
//
//        String sql = "INSERT INTO diary VALUES(null, ?, ?, ?)";
//        SQLiteStatement statement = mDatabase.compileStatement(sql);
//
//        Cursor cursor= mDatabase.rawQuery("SELECT * FROM diary",null);
//        cursor.moveToFirst();
//        Log.e("AAA", "getAll: "+cursor.moveToFirst() );
//        while (!cursor.isAfterLast() && cursor.moveToNext()){
//            int id= cursor.getInt(0);
//            time = cursor.getString(0);
//            content = cursor.getString(1);
////            image = cursor.getBlob(2);
//
//            DataDiary data = new DataDiary(time,content);
//            dataDiaries.add(data);
//            cursor.moveToNext();
//        }
//        cursor.close();
//        return dataDiaries;
//    }



    public void UpdateName(int id, int status){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("status",status);
        db.update("namebaby", contentValues, "id=" +id,null);
        db.update("nickbaby", contentValues, "id=" +id,null);
        db.update("cooking", contentValues, "id=" +id,null);
        db.update("shop", contentValues, "id=" +id,null);
        db.update("story", contentValues, "id=" +id,null);
        db.close();
    }

    public void QueryData(String sql){
        SQLiteDatabase database= getWritableDatabase();
        database.execSQL(sql);
    }

}
