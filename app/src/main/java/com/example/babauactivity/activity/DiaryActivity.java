package com.example.babauactivity.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.babauactivity.R;
import com.example.babauactivity.database.Database;
import com.example.babauactivity.database.DatabaseHelper;
import com.example.babauactivity.fragment.FragmentHome;
import com.example.babauactivity.model.DataDiary;
import com.github.lzyzsd.circleprogress.Utils;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class DiaryActivity extends AppCompatActivity {
    Toolbar toolbar_Diary;
    EditText edtDiary;
    ImageView btnImage,btnPustDiary,anhduocchon;
    public static DatabaseHelper databaseHelper;

    final int REQUEST_CODE_CAMERA = 123;
    final int REQUEST_CODE_FOLDER = 456;
    final int REQUEST_KITKAT_CODE_FOLDER = 789;

    ArrayList<DataDiary> dataDiaries;
    String timeDiary;
    String contentDiary;


    BitmapDrawable bitmapDrawable;
    byte[] hinhAnh;

    String fileName;

    String currentPhotoPath;
    Uri urlPicture;

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
        realTime();

        btnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Dialog dialog = new Dialog(DiaryActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_cam);
                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                lp.copyFrom(dialog.getWindow().getAttributes());
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                lp.height = WindowManager.LayoutParams.WRAP_CONTENT;

                dialog.getWindow().setAttributes(lp);

                Button backcam = dialog.findViewById(R.id.backcam);

                TextView txtChonanh = dialog.findViewById(R.id.txtChonanh);
                TextView txtChupanh = dialog.findViewById(R.id.txtChupanh);
                TextView txtAnhdachup = dialog.findViewById(R.id.txtAnhdachup);

                txtChonanh.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                        ActivityCompat.requestPermissions(
//                                DiaryActivity.this,
//                                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
//                                REQUEST_CODE_FOLDER
//                        );

                        TakePictureFolder();
                        dialog.dismiss();
                    }
                });
                txtAnhdachup.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                        ActivityCompat.requestPermissions(
//                                DiaryActivity.this,
//                                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
//                                REQUEST_CODE_FOLDER
//                        );
                        TakePictureFolder();
                        dialog.dismiss();
                    }
                });

                txtChupanh.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                        ActivityCompat.requestPermissions(
//                            DiaryActivity.this,
//                            new String[]{android.Manifest.permission.CAMERA},
//                            REQUEST_CODE_CAMERA
//                        );

                        TakeCamera();
                        dialog.dismiss();
                    }
                });


                backcam.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                dialog.show();






            }
        });

        btnPustDiary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseHelper = new DatabaseHelper(getApplicationContext());
                contentDiary = edtDiary.getText().toString().trim();


                if (urlPicture != null){
                    long id  = databaseHelper.insertDiary(timeDiary,contentDiary,urlPicture.toString());

                    Intent intent = new Intent(DiaryActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    long id  = databaseHelper.insertDiary(timeDiary,contentDiary,null);
                    Intent intent = new Intent(DiaryActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }



                // chuyen data imageview -> bye[]
//                bitmapDrawable = (BitmapDrawable) anhduocchon.getDrawable(); // lay hinh tu resuorce
//                if (bitmapDrawable != null){
//                    // chuyen tu bitmapDrawable ve bitmap
//                    Bitmap bitmap = bitmapDrawable.getBitmap();
//
//                    // chuyen ve kieu mang byte
//                    ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
//                    // compress dinh dang lai kieu du lieu xuat ra
//                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArray);
//                    // mang byte hinhAnh chua du lieu
//                    hinhAnh = byteArray.toByteArray();
//
//                    long id  = databaseHelper.insertDiary(timeDiary,contentDiary,hinhAnh);
//
//                    Intent intent = new Intent(DiaryActivity.this, MainActivity.class);
//                    startActivity(intent);
//                    finish();
//
//                } else {
//                    long id  = databaseHelper.insertDiary(timeDiary,contentDiary,null);
//
//                    Intent intent = new Intent(DiaryActivity.this, MainActivity.class);
//                    startActivity(intent);
//                    finish();
//
//                }

            }
        });
    }

    private void realTime() {
        Date today = new Date(System.currentTimeMillis());
        SimpleDateFormat timeFormat= new SimpleDateFormat("hh:mm dd/MM/yyyy");
        timeDiary = timeFormat.format(today.getTime());
    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        switch (requestCode){
//            case REQUEST_CODE_CAMERA:
//                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
//                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                    startActivityForResult(intent, REQUEST_CODE_CAMERA);
//                } else {
//                    Toast.makeText(this, "k cho phep mo camera", Toast.LENGTH_SHORT).show();
//                }
//
//                break;
//            case REQUEST_CODE_FOLDER:
//                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
//                    Intent intent = new Intent(Intent.ACTION_PICK);
//                    intent.setType("image/*");
//                    startActivityForResult(intent, REQUEST_CODE_FOLDER);
//                } else {
//                    Toast.makeText(this, "k cho phep mo thu vien anh", Toast.LENGTH_SHORT).show();
//                }
//                break;
//        }
//
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//    }





    @Override
    // do hinh anh chup dc vao day, nhan ket qua ve
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == REQUEST_CODE_CAMERA && resultCode == RESULT_OK) {
//            urlPicture = data.getData();

            Log.e("RequestCam", "anh chup dc : " + urlPicture);
//            Bundle extras = data.getExtras();
//            Bitmap imageBitmap = (Bitmap) extras.get("data");
//            anhduocchon.setImageBitmap(imageBitmap);

            Picasso.get().load(urlPicture).into(anhduocchon);

        }

        if (requestCode == REQUEST_CODE_FOLDER && resultCode == RESULT_OK && data != null){
            if (Build.VERSION.SDK_INT < 19) {
                // lay duong dan trong android
                urlPicture = data.getData();
                Log.e("RequestCam", "folderrrrrr 11111: " + urlPicture);

            } else {
                // lay duong dan trong android
                urlPicture = data.getData();
                Log.e("RequestCam", "folderrrrrr 22222: " + urlPicture);

                final int takeFlags = data.getFlags()
                        & (Intent.FLAG_GRANT_READ_URI_PERMISSION
                        | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);

                try {
                    getContentResolver().takePersistableUriPermission(urlPicture, takeFlags);
                }
                catch (SecurityException e){
                    e.printStackTrace();
                }
            }

            Log.e("RequestCam", "folderrrrrr 3333: " + urlPicture);

            try {
                // mo cho der doc du lieu
//                InputStream inputStream = getContentResolver().openInputStream(urlPicture);
//                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

                Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(urlPicture));
                anhduocchon.setImageBitmap(bitmap);


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }

        super.onActivityResult(requestCode, resultCode, data);
    }


    private void TakeCamera() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {

            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                urlPicture = FileProvider.getUriForFile(this,
                        "com.example.android.fileprovider",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, urlPicture);
                startActivityForResult(takePictureIntent, REQUEST_CODE_CAMERA);
            }
        }
    }


    private void TakePictureFolder() {
//        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
//        intent.setType("image/*");
//        startActivityForResult(intent, REQUEST_CODE_FOLDER);

        if (Build.VERSION.SDK_INT <19){
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("image/*");
            startActivityForResult(intent, REQUEST_CODE_FOLDER);
        } else {
            Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
            intent.addCategory(Intent.CATEGORY_OPENABLE);
            intent.setType("image/*");
            startActivityForResult(intent, REQUEST_CODE_FOLDER);
        }

    }

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        currentPhotoPath = image.getAbsolutePath();
        return image;
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
