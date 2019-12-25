package com.example.babauactivity.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
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

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class SplashActivity extends AppCompatActivity {
    Intent t;
    String db_name = "babau.db";
    String db_path = "/databases/";
    InputStream is;
    Toolbar toolbar;

    Button btnluutt,btnboqua,btnTinhdusinh,edtdate;

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
        ngayDuSInh();


    }

    private void ngayDuSInh() {
//        chonngay();
        btnTinhdusinh = findViewById(R.id.btnTinhdusinh);

        btnTinhdusinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dateDS = edtdate.getText().toString();
//                String ngayKinh = dataKykinhs.get(position).getKinh();
                Log.e("TAG","CHECK ITEM CLICK1: "+dateDS);
                Intent intent = new Intent(SplashActivity.this, NgayDSActivity.class);

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                intent.putExtra("ngaykinh", dateDS);
//                intent.putExtra("dateds", dateDS);
                startActivity(intent);
            }
        });

    }

    private void initView() {
        btnboqua = findViewById(R.id.btnboqua);
        btnluutt = findViewById(R.id.btnluutt);

        edtname = findViewById(R.id.edtname);
        edtnick = findViewById(R.id.edtnick);
        edtdate = findViewById(R.id.edtdate);
    }

    private void setInfo() {
        edtdate.setOnClickListener(new View.OnClickListener() {
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
                String ten = edtname.getText().toString();
                String nick = edtnick.getText().toString();
                String date = edtdate.getText().toString();

                Intent tt = new Intent(SplashActivity.this, MainActivity.class);
//                Bundle bundle = new Bundle();
//                bundle.putString("namett", ten);
//                bundle.putString("nicktt", nick);
//                bundle.putString("datett", date);

                tt.putExtra("namett", ten);
                tt.putExtra("nicktt", nick);

//                tt.putExtra("pushdata", bundle);

                startActivity(tt);
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
                edtdate.setText(simpleDateFormat.format(calendar.getTime()));
            }
        }, nam, thang, ngay);
        datePickerDialog.show();
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