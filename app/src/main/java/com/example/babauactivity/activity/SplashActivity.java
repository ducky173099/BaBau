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
import com.example.babauactivity.fragment.FragmentHome;
import com.example.babauactivity.model.amduong;

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
    String updateNDS;
    String ten;
    String nick;

    String newDateSolar;
    Button btnluutt,btnboqua,btnTinhdusinh,btn_date;

    TextView edtname,edtnick;
    String dateNDS;


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
        updateNDS = getDate.getStringExtra("update");

        if (updateNDS != null){
            btn_date.setText(updateNDS);
            Log.e("time", "onCreate: 1" );
        }else {
            SharedPreferences sharedSaveInfo = getSharedPreferences("saveInfo", MODE_PRIVATE);
            updateNDS = sharedSaveInfo.getString("getTextDate",null);
            Log.e("time", "onCreate: 2" );

            if (updateNDS == null){
                Log.e("timemmm", "onCreate: " + realTime());
                btn_date.setText(realTime());
            }else{
                btn_date.setText(updateNDS);

            }

        }






    }

    private void tinhNgaySinh() {

        btnTinhdusinh = findViewById(R.id.btnTinhdusinh);

        btnTinhdusinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ten = edtname.getText().toString();
                nick = edtnick.getText().toString();


                SharedPreferences sharedSaveInfo = getSharedPreferences("saveInfo", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedSaveInfo.edit();
                editor.putString("keyname",ten);
                editor.putString("keynick",nick);
                editor.commit();


                Intent intent = new Intent(SplashActivity.this, NgayDSActivity.class);
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


        SharedPreferences sharedSaveInfo = getSharedPreferences("saveInfo", MODE_PRIVATE);
        edtname.setText(sharedSaveInfo.getString("keyname",""));
        edtnick.setText(sharedSaveInfo.getString("keynick", ""));

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
                dateNDS = btn_date.getText().toString();

                SharedPreferences sharedSaveInfo = getSharedPreferences("saveInfo", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedSaveInfo.edit();
                editor.putString("getTextDate",dateNDS);
                editor.commit();

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


                dateNDS = btn_date.getText().toString();

                SharedPreferences sharedSaveInfo = getSharedPreferences("saveInfo", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedSaveInfo.edit();
                editor.putString("getTextDate",dateNDS);
                editor.putString("keyname",ten);
                editor.putString("keynick",nick);
                editor.commit();



                Intent tt = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(tt);
                finish();

            }
        });



    }

    private void chonngay(){
        final Calendar calendar = Calendar.getInstance();
        int ngay = calendar.get(Calendar.DATE);
        int thang = calendar.get(Calendar.MONTH);
        int nam = calendar.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                calendar.set(i,i1,i2);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                newDateSolar = simpleDateFormat.format(calendar.getTime());
                btn_date.setText(newDateSolar);

            }
        }, nam, thang, ngay);
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        datePickerDialog.show();
    }


    private String realTime() {
        Date today = new Date(System.currentTimeMillis());
        SimpleDateFormat timeFormat= new SimpleDateFormat("dd/MM/yyyy");
//        timereal = timeFormat.format(today.getTime());

        return timeFormat.format(today.getTime());

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