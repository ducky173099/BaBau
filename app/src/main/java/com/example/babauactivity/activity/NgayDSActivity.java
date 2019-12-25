package com.example.babauactivity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.example.babauactivity.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class NgayDSActivity extends AppCompatActivity {
    Button btnboquads,btnngayds;
    Button btndateds;
    Calendar calendar;
    String timenow;
    String timeDS;

    TextView txtNDS;

    public static int day = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngay_ds);


        initView();


        calendar = Calendar.getInstance();
//        ngayDuSinh(calendar,day);

        chuKyKinh();

    }

    private void ngayDuSinh(Calendar calendar,int day) {

        Log.e("TAG","CHECK befor PLUS MONTH:"+calendar.get(Calendar.YEAR)+"/"+calendar.get(Calendar.MONTH)+"/"+calendar.get(Calendar.DAY_OF_MONTH));
        calendar.add(Calendar.MONTH,9);
        calendar.add(Calendar.DAY_OF_MONTH,day);
        txtNDS.setText("Ngày dự sinh: " + calendar.get(Calendar.DAY_OF_MONTH)+ "/" + calendar.get(Calendar.MONTH) + "/" + calendar.get(Calendar.YEAR));




    }

    private void chuKyKinh() {
        btnngayds = findViewById(R.id.btnngayds);

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
            day = 0;
        } else{
            day = Integer.parseInt(ngayKinh);
        }
        btnngayds.setText(ngayKinh + " Ngày");
        ngayDuSinh(calendar, day);
    }

    private void initView() {
        btndateds = findViewById(R.id.btndateds);
        txtNDS = findViewById(R.id.txtNDS);

        btnboquads = findViewById(R.id.btnboquads);
        btnboquads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NgayDSActivity.this, SplashActivity.class);
                startActivity(intent);
            }
        });

        btndateds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                chonngay();
                btndateds.setText(timenow);
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
                btndateds.setText(simpleDateFormat.format(calendar.getTime()));
                ngayDuSinh(calendar,day);
            }
        }, nam, thang, ngay);
        datePickerDialog.show();
    }



//    private void realTime() {
//        Date today = new Date(System.currentTimeMillis());
//        SimpleDateFormat timeFormat= new SimpleDateFormat("dd/MM/yyyy");
//        timenow = timeFormat.format(today.getTime());
//
//    }
}
