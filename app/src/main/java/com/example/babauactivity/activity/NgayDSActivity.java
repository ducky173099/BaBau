package com.example.babauactivity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.util.ChineseCalendar;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.example.babauactivity.R;
import com.example.babauactivity.model.amduong;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class NgayDSActivity extends AppCompatActivity {
    Button btnboquads,btnngayds,btnupdateds;
    Button btndateds;
    Calendar calendar;
    String timenow;

    String timeDS;
    String updateNDS;

    TextView txtNDS;

    public static int day = 0;

    String ngay;
    String thang;
    String nam;

    String dateam;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngay_ds);
        initView();
        calendar = Calendar.getInstance();
//        ngayDuSinh(calendar,day);

        chuKyKinh();
        updateNDS();


    }

    private void updateNDS() {
        btnupdateds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent update = new Intent(NgayDSActivity.this, SplashActivity.class);
                update.putExtra("update",updateNDS);
                startActivity(update);
            }
        });


    }


    private void ngayDuSinh(Calendar calendar,int day) {
        calendar.add(Calendar.MONTH,9);
        calendar.add(Calendar.DAY_OF_MONTH,day);
        txtNDS.setText("Ngày dự sinh: " + calendar.get(Calendar.DAY_OF_MONTH)+ "/" + calendar.get(Calendar.MONTH) + "/" + calendar.get(Calendar.YEAR));
        updateNDS = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)+ "/" + calendar.get(Calendar.MONTH) + "/" + calendar.get(Calendar.YEAR));


        Log.e("lichds", "ngayDuSinh: " + updateNDS );



        String ngaycothai = String.valueOf(30 - calendar.get(Calendar.DAY_OF_MONTH));
        int ngaydu = 280 - Integer.parseInt(ngaycothai);

        Log.e("ngaycothai", "ngayDuSinh: " + ngaycothai);
        SharedPreferences sharedCothai = getSharedPreferences("ngaycothai", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedCothai.edit();
        editor.putString("keycothai",ngaycothai);
        editor.putString("keyngaydu", String.valueOf(ngaydu));
        editor.commit();





    }

    private void chuKyKinh() {
        SharedPreferences sharedPreferences = getSharedPreferences("savedate", MODE_PRIVATE);
//        btndateds.setText(sharedPreferences.getString("initDate", timeDS));
        if (sharedPreferences.getString("initDate", timeDS) == null){
            realTime();
        }else {
            btndateds.setText(sharedPreferences.getString("initDate", timeDS));
        }


        btndateds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chonngay();
            }
        });



        btnngayds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NgayDSActivity.this, KyKinhActivity.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        String ngayKinh = intent.getStringExtra("ngaykinh");
        Log.e("TA", "CHECK NGAY KINHL: " + ngayKinh);
        if (ngayKinh == null){
            day = 15;
            btnngayds.setText(day + " Ngày");
        } else{
            day = Integer.parseInt(ngayKinh);
            btnngayds.setText(ngayKinh + " Ngày");
        }


        ngayDuSinh(calendar, day);
    }

    private void initView() {
        btnngayds = findViewById(R.id.btnngayds);
        btndateds = findViewById(R.id.btndateds);
        btnboquads = findViewById(R.id.btnboquads);
        btnupdateds = findViewById(R.id.btnupdateds);
        txtNDS = findViewById(R.id.txtNDS);

        btnboquads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NgayDSActivity.this, SplashActivity.class);
                startActivity(intent);
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
                timeDS = simpleDateFormat.format(calendar.getTime());
                btndateds.setText(timeDS);


                SharedPreferences sharedPreferences = getSharedPreferences("savedate", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("initDate",timeDS);
                editor.apply();
                Log.e("date", "onDateSet: " + timeDS );

                ngayDuSinh(calendar,day);
            }
        }, nam, thang, ngay);
        datePickerDialog.show();
    }


    private void realTime() {
        Date today = new Date(System.currentTimeMillis());
        SimpleDateFormat timeFormat= new SimpleDateFormat("dd/MM/yyyy");
        timenow = timeFormat.format(today.getTime());
        btndateds.setText(timenow);
    }
}
