package com.example.babauactivity.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.babauactivity.R;
import com.example.babauactivity.database.Database;
import com.example.babauactivity.database.DatabaseHelper;
import com.example.babauactivity.fragment.FragmentHome;
import com.example.babauactivity.model.DataDiary;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DiaryActivity extends AppCompatActivity {
    Toolbar toolbar_Diary;
    EditText edtDiary;
    ImageView btnImage,btnPustDiary,anhduocchon;
    public static DatabaseHelper databaseHelper;

    final int REQUEST_CODE_CAMERA = 123;
    final int REQUEST_CODE_FOLDER = 456;

    ArrayList<DataDiary> dataDiaries;
    public static String timeDiary;
    public static String contentDiary;


    BitmapDrawable bitmapDrawable;
    byte[] hinhAnh;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);


        initView();
        actionToolbar();

    }

    private void initView() {
        edtDiary = findViewById(R.id.edtDiary);
        btnImage = findViewById(R.id.btnImage);
        btnPustDiary = findViewById(R.id.btnPustDiary);
        anhduocchon = findViewById(R.id.anhduocchon);

        AddDiary();

    }



    private void AddDiary() {

        btnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ActivityCompat.requestPermissions(
                        DiaryActivity.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_CODE_FOLDER
                );

//                ActivityCompat.requestPermissions(
//                        DiaryActivity.this,
//                        new String[]{android.Manifest.permission.CAMERA},
//                        REQUEST_CODE_CAMERA
//                );


            }
        });

        btnPustDiary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contentDiary = edtDiary.getText().toString().trim();
                // chuyen data imageview -> bye[]
                bitmapDrawable = (BitmapDrawable) anhduocchon.getDrawable(); // lay hinh tu resuorce
                if (bitmapDrawable != null){
                    // chuyen tu bitmapDrawable ve bitmap
                    Bitmap bitmap = bitmapDrawable.getBitmap();
                    // chuyen ve kieu mang byte
                    ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
                    // compress dinh dang lai kieu du lieu xuat ra
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArray);
                    // mang byte hinhAnh chua du lieu
                    hinhAnh = byteArray.toByteArray();

                    Intent intent = new Intent();
                    intent.putExtra("dairy",contentDiary);
                    intent.putExtra("anh",hinhAnh);
                    setResult(RESULT_OK,intent);
                    finish();
                } else {

                    Intent intent = new Intent();
                    intent.putExtra("dairy",contentDiary);
                    intent.putExtra("anh",hinhAnh);
                    setResult(RESULT_OK,intent);
                    finish();
                }


//                Intent intent = new Intent(DiaryActivity.this, MainActivity.class);
//                intent.putExtra("dairy",contentDiary);
//                startActivity(intent);


            }
        });
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case REQUEST_CODE_CAMERA:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, REQUEST_CODE_CAMERA);
                } else {
                    Toast.makeText(this, "k cho phep mo camera", Toast.LENGTH_SHORT).show();
                }
                break;
            case REQUEST_CODE_FOLDER:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Intent intent = new Intent(Intent.ACTION_PICK);
                    intent.setType("image/*");
                    startActivityForResult(intent, REQUEST_CODE_FOLDER);
                } else {
                    Toast.makeText(this, "k cho phep mo thu vien anh", Toast.LENGTH_SHORT).show();
                }
                break;
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    // do hinh anh chup dc vao day, nhan ket qua ve
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == REQUEST_CODE_CAMERA && resultCode == RESULT_OK && data!= null){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            anhduocchon.setImageBitmap(bitmap);
        }

        if (requestCode == REQUEST_CODE_FOLDER && resultCode == RESULT_OK && data != null){
            // lay duong dan trong android
            Uri uri = data.getData();
            try {
                // mo cho der doc du lieu
                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                anhduocchon.setImageBitmap(bitmap);


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    private void actionToolbar() {
        toolbar_Diary = findViewById(R.id.toolbar_Diary);

        setSupportActionBar(toolbar_Diary);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar_Diary.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
