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
    String timereal;
    String updateNS;
    String ten;
    String nick;

    String ngays;
    String thangs;
    String nams;

    String SN;
    String ST;
    String SNam;

    String newdateds;
    Button btnluutt,btnboqua,btnTinhdusinh,btn_date;

    TextView edtname,edtnick;

    String takeDatenew;
    String newLunar;
    String lichamfirs;
    String getnewdate;
    String sendSolar;

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
        lichamfirs = getDate.getStringExtra("lichamfirs");
        sendSolar = getDate.getStringExtra("sendsolar");
        ngays = getDate.getStringExtra("keyngay");
        thangs = getDate.getStringExtra("keythang");
        nams = getDate.getStringExtra("keynam");


        Log.e("haha", "get solar: " + sendSolar );
        SharedPreferences NewDatesolar = getSharedPreferences("setSolar", MODE_PRIVATE);
        btn_date.setText(NewDatesolar.getString("keySolar","25/12/2019"));

//        SharedPreferences.Editor editsolar = NewDatesolar.edit();
//        editsolar.putString("keySolar",sendSolar);
//        editsolar.commit();

        if (sendSolar != null){
            Log.e("haha", "get solar khong null : " + sendSolar );
            btn_date.setText(NewDatesolar.getString("keySolar","25/12/2019"));
            btn_date.setText(sendSolar);

        }
//        btn_date.setText(sendSolar);




        if (updateNS == null){
            realTime();
            SharedPreferences sharedHomeActivity = getSharedPreferences("licham", MODE_PRIVATE);
            btn_date.setText(sharedHomeActivity.getString("keyDSHome", timereal));
        }else if (updateNS != null && sendSolar == null){
            Log.e("haha", "get solar NULL : " + sendSolar );

            btn_date.setText(updateNS);
            SharedPreferences sharedPreferences = getSharedPreferences("saveupdate", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("keyUpdate",updateNS);
            editor.commit();

        }




    }

    private void tinhNgaySinh() {

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
                String datebq = btn_date.getText().toString();

                t = new Intent(SplashActivity.this, MainActivity.class);
                t.putExtra("putnewdate",datebq);
                startActivity(t);
                finish();

            }
        });

        btnluutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                ten = edtname.getText().toString();
                nick = edtnick.getText().toString();

                edtname.setText(ten);
                edtnick.setText(nick);
                Log.e("edt", "name edittext: " + ten + nick );


                SharedPreferences sharedupdate = getSharedPreferences("saveupdate", MODE_PRIVATE);
                SharedPreferences.Editor editorupdate = sharedupdate.edit();
                editorupdate.putString("keyUpdate",updateNS);
                editorupdate.commit();

                SharedPreferences sharedPreferences = getSharedPreferences("saveTT", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("keyname",ten);
                editor.putString("keynick",nick);
                editor.commit();





                getnewdate = btn_date.getText().toString();
                Log.e("newlunar", "onClick: " + newLunar );

                SharedPreferences NewDatesolar = getSharedPreferences("setSolar", MODE_PRIVATE);
                SharedPreferences.Editor editsolar = NewDatesolar.edit();
                editsolar.putString("keySolar",sendSolar);
                editsolar.commit();





                Intent tt = new Intent(SplashActivity.this, MainActivity.class);
                tt.putExtra("putlichduong",updateNS);
                tt.putExtra("putnewdate",getnewdate);
                tt.putExtra("putnewLunar",newLunar);
                Log.e("newdate", "onClick: " + getnewdate );
                startActivity(tt);

                if (newLunar == null){
                    SharedPreferences NewDateds = getSharedPreferences("newDS", MODE_PRIVATE);
                    SharedPreferences.Editor editnewdateds = NewDateds.edit();
                    editnewdateds.putString("keyNewDS",newdateds);
//                    editnewdateds.putString("keyNewLunar",newLunar);
                    editnewdateds.putString("keyNewLunar",lichamfirs);
                    editnewdateds.putString("keyNewSolar",getnewdate);
                    editnewdateds.commit();
                } else {
                    SharedPreferences NewDateds = getSharedPreferences("newDS", MODE_PRIVATE);
                    SharedPreferences.Editor editnewdateds = NewDateds.edit();
                    editnewdateds.putString("keyNewDS",newdateds);
                    editnewdateds.putString("keyNewLunar",newLunar);
                    editnewdateds.putString("keyNewSolar",getnewdate);
//                    editnewdateds.putString("keyNewLunar",lichamfirs);
                    editnewdateds.commit();
                }



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
//                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//                newdateds = simpleDateFormat.format(calendar.getTime());
//                btn_date.setText(newdateds);

                SimpleDateFormat sn = new SimpleDateFormat("dd");
                SimpleDateFormat st = new SimpleDateFormat("MM");
                SimpleDateFormat snam = new SimpleDateFormat("yyyy");
                SN = sn.format(calendar.getTime());
                ST = st.format(calendar.getTime());
                SNam = snam.format(calendar.getTime());

                newdateds = SN + "/" + ST + "/" + SNam;
                amduong amduong = new amduong();
                newLunar = amduong.Solar2Lunar(Integer.parseInt(SN),Integer.parseInt(ST),Integer.parseInt(SNam))[0]+"/"+amduong.Solar2Lunar(Integer.parseInt(SN),Integer.parseInt(ST),Integer.parseInt(SNam))[1]+"/"+amduong.Solar2Lunar(Integer.parseInt(SN),Integer.parseInt(ST),Integer.parseInt(SNam))[2];






                btn_date.setText(newdateds);

                SharedPreferences NewDatesolar = getSharedPreferences("setSolar", MODE_PRIVATE);
                SharedPreferences.Editor editsolar = NewDatesolar.edit();
                editsolar.putString("keySolar",newdateds);
                editsolar.commit();

            }
        }, nam, thang, ngay);
        datePickerDialog.show();
    }


    private void realTime() {
        Date today = new Date(System.currentTimeMillis());
        SimpleDateFormat timeFormat= new SimpleDateFormat("dd/MM/yyyy");
        timereal = timeFormat.format(today.getTime());

//        btn_date.setText(timereal);
    }

//    private void licAmreal(){
//        Date today = new Date(System.currentTimeMillis());
//        SimpleDateFormat sn = new SimpleDateFormat("dd");
//        SimpleDateFormat st = new SimpleDateFormat("MM");
//        SimpleDateFormat snam = new SimpleDateFormat("yyyy");
//        SN = sn.format(today.getTime());
//        ST = st.format(today.getTime());
//        SNam = snam.format(today.getTime());
//
//        amduong amduong = new amduong();
//
//    }



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