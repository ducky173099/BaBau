package com.example.babauactivity.database;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteBlobTooBigException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.babauactivity.activity.SplashActivity;
import com.example.babauactivity.model.DataCooking;
import com.example.babauactivity.model.DataDiary;
import com.example.babauactivity.model.DataNameSon;
import com.example.babauactivity.model.DataNickName;
import com.example.babauactivity.model.DataQuation;
import com.example.babauactivity.model.DataShop;
import com.example.babauactivity.model.DataStory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DB_NAME ="babau.db";

    private static String database_name = "diary_db";
    private static final int DATABASE_VERSION = 3;
    private static final String TABLE_NAME = "diary";

    private static final String KEY_ID = "id";
    private static final String KEY_TIME = "time";
    private static final String KEY_CONTENT = "content";
    private static final String KEY_IMAGE = "image";

    Intent t;
    String db_name = "babau.db";
    String db_path = "/databases/";
    InputStream is;
    private Context mContext;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DATABASE_VERSION);
//        super(context, database_name, null, 1);
        this.mContext = context;
    }






    @Override
    public void onCreate(SQLiteDatabase db) {
//        db.execSQL("CREATE TABLE " + TABLE_NAME + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
//                + KEY_TIME + " TEXT,"
//                + KEY_CONTENT + " TEXT,"
//                + KEY_IMAGE + " BLOB"
//                + ")" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
//        onCreate(db);
        if(newVersion>oldVersion){
            copyCSDLtuAssetvaoApp();
        }

    }


    public long insertDiary(String time, String content, String image){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_TIME,time);
        cv.put(KEY_CONTENT,content);
        cv.put(KEY_IMAGE,image);
        long id = db.insert(TABLE_NAME,null, cv);
        db.close();
        return id;
    }

    public ArrayList<DataDiary> getDiary() {
        ArrayList<DataDiary> dataDiaries = new ArrayList<>();
        SQLiteDatabase mDatabase= getReadableDatabase();

        Cursor cursor= mDatabase.rawQuery("SELECT * FROM diary",null);
        cursor.moveToFirst();
        Log.e("AAA", "getAll: "+cursor.moveToFirst() );
        while (!cursor.isAfterLast() && cursor.moveToNext()){
            int id= cursor.getInt(0);
            String time = cursor.getString(0);
            String content = cursor.getString(1);
            String image = cursor.getString(2);

            DataDiary data = new DataDiary(id,time,content,image);
            dataDiaries.add(data);
            cursor.moveToNext();
        }
        cursor.close();
        return dataDiaries;
    }

    public ArrayList<DataDiary> getAllDatas() {
        ArrayList<DataDiary> dataDiaries = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME + " ORDER BY " +
                KEY_TIME + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);


        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                DataDiary dataDiary = new DataDiary();
                dataDiary.setId(cursor.getInt(cursor.getColumnIndex(KEY_ID)));
                dataDiary.setTime(cursor.getString(cursor.getColumnIndex(KEY_TIME)));
                dataDiary.setContent(cursor.getString(cursor.getColumnIndex(KEY_CONTENT)));
                dataDiary.setImgDiary(cursor.getString(cursor.getColumnIndex(KEY_IMAGE)));

                dataDiaries.add(dataDiary);
            } while (cursor.moveToNext());
        }
        // close db connection
        db.close();
        // return notes list
        return dataDiaries;
    }


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

    public ArrayList<DataQuation> getQuatation() {
        ArrayList<DataQuation> dataQuations = new ArrayList<>();
        SQLiteDatabase mDatabase= getReadableDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM quatation",null);
        cursor.moveToFirst();
        Log.e("AAA", "getAll: "+cursor.moveToFirst() );
        while (!cursor.isAfterLast()){
            int id= cursor.getInt(0);
            String content = cursor.getString(1);
            String name = cursor.getString(2);
            int status = cursor.getInt(3);

            DataQuation data = new DataQuation(id,content,name,status);
            dataQuations.add(data);
            cursor.moveToNext();
        }
        cursor.close();
        return dataQuations;
    }

    public ArrayList<DataQuation> getQuataLike() {
        ArrayList<DataQuation> dataQuations = new ArrayList<>();
        SQLiteDatabase mDatabase= getReadableDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM quatation WHERE status = 1",null);
        cursor.moveToFirst();
        Log.e("AAA", "getAll: "+cursor.moveToFirst() );
        while (!cursor.isAfterLast()){
            int id= cursor.getInt(0);
            String content = cursor.getString(1);
            String name = cursor.getString(2);
            int status = cursor.getInt(3);

            DataQuation data = new DataQuation(id,content,name,status);
            dataQuations.add(data);
            cursor.moveToNext();
        }
        cursor.close();
        return dataQuations;
    }



    public void UpdateName(int id, int status){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("status",status);
        db.update("namebaby", contentValues, "id=" +id,null);
        db.update("nickbaby", contentValues, "id=" +id,null);
        db.update("cooking", contentValues, "id=" +id,null);
        db.update("shop", contentValues, "id=" +id,null);
        db.update("story", contentValues, "id=" +id,null);
        db.update("quatation", contentValues, "id=" +id,null);
        db.close();
    }

    public void QueryData(String sql){
        SQLiteDatabase database= getWritableDatabase();
        database.execSQL(sql);
    }


    public void copyCSDLtuAssetvaoApp() {
        try {
            this.is = mContext.getAssets().open(this.db_name);
            File f = new File(mContext.getApplicationInfo().dataDir + this.db_path);
            if (!f.exists()) {
                f.mkdir();
            }
            OutputStream os = new FileOutputStream(getUrl());
            byte[] buffer = new byte[1024];
            while (true) {
                int length = this.is.read(buffer);
                if (length > 0) {
                    os.write(buffer, 0, length);
                }
                else {
                    os.flush();
                    os.close();
                    this.is.close();
                    return;
                }
            }

        } catch (Exception e) {
            System.out.println("loi:" + e.toString());
        }
    }

    public String getUrl() {
        return mContext.getApplicationInfo().dataDir + this.db_path + this.db_name;
    }
}
