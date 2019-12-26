package com.example.babauactivity.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.babauactivity.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class SplashActivity extends AppCompatActivity {
    Intent t;
    String db_name = "babau.db";
    String db_path = "/databases/";
    InputStream is;
    Toolbar toolbar;
    String timereal;
    String updateNS;
    String ten;
    String nick;

    String ngays;
    String thangs;
    String nams;

    Button btnluutt,btnboqua,btnTinhdusinh,btn_date;

    TextView edtname,edtnick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        xuLiSaoChepCSDL();



//
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                t = new Intent(SplashActivity.this, MainActivity.class);
//                startActivity(t);
//                finish();
//            }
//        }, 500);

        initView();
        setInfo();
        tinhNgaySinh();


        Intent getDate = getIntent();
        updateNS = getDate.getStringExtra("update");
        ngays = getDate.getStringExtra("keyngay");
        thangs = getDate.getStringExtra("keythang");
        nams = getDate.getStringExtra("keynam");



        Log.e("update", "lay date: " + updateNS);
        if (updateNS==null){
            realTime();
        }else{
            btn_date.setText(updateNS);
            SharedPreferences sharedPreferences = getSharedPreferences("saveupdate", MODE_PRIVATE);
//            btn_date.setText(sharedPreferences.getString("keyUpdate", updateNS));
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("keyUpdate",updateNS);
            editor.commit();

        }
    }

    private void tinhNgaySinh() {
//        chonngay();
        btnTinhdusinh = findViewById(R.id.btnTinhdusinh);

        btnTinhdusinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ten = edtname.getText().toString();
                nick = edtnick.getText().toString();

                edtname.setText(ten);
                edtnick.setText(nick);
                Log.e("edt", "name edittext: " + ten + nick );
                SharedPreferences sharedPreferences = getSharedPreferences("saveTT", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("keyname",ten);
                editor.putString("keynick",nick);
                editor.commit();

                String dateDS = btn_date.getText().toString();
                Log.e("TAG","CHECK ITEM CLICK1: "+dateDS);
                Intent intent = new Intent(SplashActivity.this, NgayDSActivity.class);
                intent.putExtra("ngayds",timereal);
                Log.e("ngayds","CHECK ngay ds: "+ timereal);
                startActivity(intent);
            }
        });

    }

    private void initView() {
        btnboqua = findViewById(R.id.btnboqua);
        btnluutt = findViewById(R.id.btnluutt);

        edtname = findViewById(R.id.edtname);
        edtnick = findViewById(R.id.edtnick);
        btn_date = findViewById(R.id.btn_date);

        SharedPreferences sharedPreferences = getSharedPreferences("saveTT", MODE_PRIVATE);
        edtname.setText(sharedPreferences.getString("keyname",""));
        edtnick.setText(sharedPreferences.getString("keynick", ""));

    }

    private void setInfo() {
        btn_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chonngay();
            }
        });



        btnboqua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                t = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(t);
                finish();

            }
        });

        btnluutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ten = edtname.getText().toString();
                nick = edtnick.getText().toString();

                Intent tt = new Intent(SplashActivity.this, MainActivity.class);
                tt.putExtra("putngay",ngays);
                tt.putExtra("putthang",thangs);
                tt.putExtra("putnam",nams);
                tt.putExtra("putlichduong",updateNS);
                startActivity(tt);

                edtname.setText(ten);
                edtnick.setText(nick);
                Log.e("edt", "name edittext: " + ten + nick );
                SharedPreferences sharedPreferences = getSharedPreferences("saveTT", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("keyname",ten);
                editor.putString("keynick",nick);

                editor.commit();
            }
        });



    }

    private void chonngay(){
        final Calendar calendar = Calendar.getInstance();
        int ngay = calendar.get(Calendar.DATE);
        int thang = calendar.get(Calendar.MONTH);
        int nam = calendar.get(Calendar.YEAR);

//        realTime();

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                calendar.set(i,i1,i2);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                btn_date.setText(simpleDateFormat.format(calendar.getTime()));
            }
        }, nam, thang, ngay);
        datePickerDialog.show();
    }


    private void realTime() {
        Date today = new Date(System.currentTimeMillis());
        SimpleDateFormat timeFormat= new SimpleDateFormat("dd/MM/yyyy");
        timereal = timeFormat.format(today.getTime());
        btn_date.setText(timereal);
    }



    public void xuLiSaoChepCSDL() {
//       check file database đã tồn tại chưa? nếu chưa thì coppy vào
        if (!getDatabasePath(this.db_name).exists()) {
            try {
                copyCSDLtuAssetvaoApp();
                System.out.println("thanh cong");
            } catch (Exception e) {
                System.out.println("loi:" + e.toString());
            }
        }
    }

    public void copyCSDLtuAssetvaoApp() {
        try {
            this.is = getAssets().open(this.db_name);
            File f = new File(getApplicationInfo().dataDir + this.db_path);
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
        return getApplicationInfo().dataDir + this.db_path + this.db_name;
    }




}