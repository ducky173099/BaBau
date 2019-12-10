package com.example.babauactivity.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.babauactivity.model.DataNameSon;

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
        Cursor cursor= mDatabase.rawQuery("SELECT * FROM namebaby WHERE sex = 1",null);
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


    public void UpdateName(int id, int status){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("status",status);
        db.update("namebaby", contentValues, "id=" +id,null);
        db.close();
    }

    public void QueryData(String sql){
        SQLiteDatabase database= getWritableDatabase();
        database.execSQL(sql);
    }

}
