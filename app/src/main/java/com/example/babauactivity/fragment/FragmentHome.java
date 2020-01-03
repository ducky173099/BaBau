package com.example.babauactivity.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.babauactivity.R;
import com.example.babauactivity.activity.DiaryActivity;
import com.example.babauactivity.activity.MainActivity;
import com.example.babauactivity.activity.SplashActivity;
import com.example.babauactivity.activity.ThaiKiActivity;
import com.example.babauactivity.adapter.DiaryAdapter;
import com.example.babauactivity.database.Database;
import com.example.babauactivity.database.DatabaseHelper;
import com.example.babauactivity.model.DataDiary;
import com.example.babauactivity.model.DataPicturebaby;
import com.example.babauactivity.model.amduong;
import com.github.lzyzsd.circleprogress.ArcProgress;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;
import com.shinelw.library.ColorArcProgressBar;

import java.lang.reflect.Type;
import java.sql.Blob;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static android.app.Activity.RESULT_OK;
import static android.content.Context.MODE_PRIVATE;

public class FragmentHome extends Fragment {
    Button btnNhatky;
    ImageView imgSetting;

    RecyclerView recycler_Diary;
    ArrayList<DataDiary> dataDiaries;
    DiaryAdapter diaryAdapter;
    DatabaseHelper databaseHelper;
    TextView txtDiary;
    TextView namebeyeu, nickbeyeu,txtdatedshome,txtcothai,txtngaydu,txtlicham,txtWeekdate,txtDaydate,txtWeightoffWeek,txtSizeoffWeek;

    long getDiff,getDaysDiff;
    RelativeLayout selectchitiettk;

    String timeCurrent;

    int REQUEST_CODE_EDIT = 123;
    String contentNhatky;
    byte[] anh;

    String Ngay;
    String month;
    String year;

    String newdateds;

    String dateLunar;


    ArcProgress arc_progress;

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home, container, false);

        getDataSplash(view);
        SelectTK(view);

        imgSetting = view.findViewById(R.id.imgSetting);
        imgSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String solarchild = txtdatedshome.getText().toString();
                Intent intent = new Intent(getContext(), SplashActivity.class);
//                intent.putExtra("sendDatenew",newdateds);
                intent.putExtra("sendsolar",solarchild);
                startActivity(intent);

            }
        });



        recycler_Diary = view.findViewById(R.id.recycler_Diary);
        txtDiary = view.findViewById(R.id.txtDiary);
        recycler_Diary.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));

        dataDiaries = new ArrayList<>();
        databaseHelper = new DatabaseHelper(getContext());

        diaryAdapter = new DiaryAdapter(getContext(), databaseHelper.getAllDatas(), databaseHelper);

        recycler_Diary.setAdapter(diaryAdapter);
        diaryAdapter.notifyDataSetChanged();


        btnNhatky = view.findViewById(R.id.btnNhatky);
        btnNhatky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nhatky = new Intent(getContext(), DiaryActivity.class);
                startActivityForResult(nhatky,REQUEST_CODE_EDIT);


            }
        });




        return view;
    }




    private  void getDataSplash(View view){
        namebeyeu = view.findViewById(R.id.namebeyeu);
        nickbeyeu = view.findViewById(R.id.nickbeyeu);
        txtdatedshome = view.findViewById(R.id.txtdatedshome);
        txtcothai = view.findViewById(R.id.txtcothai);
        txtngaydu = view.findViewById(R.id.txtngaydu);
        txtlicham = view.findViewById(R.id.txtlicham);
        txtWeekdate = view.findViewById(R.id.txtWeekdate);
        txtDaydate = view.findViewById(R.id.txtDaydate);
        txtWeightoffWeek = view.findViewById(R.id.txtWeightoffWeek);
        txtSizeoffWeek = view.findViewById(R.id.txtSizeoffWeek);

        arc_progress = view.findViewById(R.id.arc_progress);

        SharedPreferences sharedSaveInfo = getContext().getSharedPreferences("saveInfo", MODE_PRIVATE);
        txtdatedshome.setText(sharedSaveInfo.getString("getTextDate",""));
        namebeyeu.setText(sharedSaveInfo.getString("keyname","Tên bé Yêu"));
        nickbeyeu.setText(sharedSaveInfo.getString("keynick","Nickname bé"));




        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = null;
        Date date2 = null;


        String dateSolar = sharedSaveInfo.getString("getTextDate","");

        realTime();
        Log.e("khoang", "getDataSplash: "+timeCurrent);
        Log.e("khoang", "getDataSplash: "+dateSolar);
        try {

            date1 = simpleDateFormat.parse(timeCurrent);
            date2 = simpleDateFormat.parse(dateSolar);
            Log.e("khoangcach", "date 1: " + date1);
            Log.e("khoangcach", "date 2: " + date2);


            getDiff = date2.getTime() - date1.getTime();
            if (getDiff == 0){
                getDaysDiff = 0;
            } else {
                getDaysDiff = getDiff / (24 * 60 * 60 * 1000);

            }



            Log.e("khoangcach", "khoảng cách : " + getDaysDiff);
            Log.e("khoangcach", "??? : " + getDiff);

            int numDate = (int) (280 - getDaysDiff);
            int weekDate = numDate/7;
            int dayDate = numDate%7;

            txtngaydu.setText(String.valueOf(getDaysDiff));
            txtcothai.setText(String.valueOf(numDate));

            txtWeekdate.setText(String.valueOf(weekDate));
            txtDaydate.setText(String.valueOf(dayDate));

            if (weekDate == 0 || weekDate == 1 || weekDate == 2){
                txtWeightoffWeek.setText("0");
                txtSizeoffWeek.setText("0");
            }
            else if (weekDate == 3 || weekDate == 4){
                txtWeightoffWeek.setText("0 g");
                txtSizeoffWeek.setText("1");
            } else if (weekDate == 5){
                txtWeightoffWeek.setText("0.1 g");
                txtSizeoffWeek.setText("2");
            }else if (weekDate == 6){
                txtWeightoffWeek.setText("0.2 g");
                txtSizeoffWeek.setText("6");
            }else if (weekDate == 7){
                txtWeightoffWeek.setText("0.5 g");
                txtSizeoffWeek.setText("1.5");
            }else if (weekDate == 8){
                txtWeightoffWeek.setText("1 g");
                txtSizeoffWeek.setText("1.6");
            }else if (weekDate == 9){
                txtWeightoffWeek.setText("2 g");
                txtSizeoffWeek.setText("2.3");
            }else if (weekDate == 10){
                txtWeightoffWeek.setText("3.1 g");
                txtSizeoffWeek.setText("4");
            }else if (weekDate == 11){
                txtWeightoffWeek.setText("7 g");
                txtSizeoffWeek.setText("4.1");
            }else if (weekDate == 12){
                txtWeightoffWeek.setText("14 g");
                txtSizeoffWeek.setText("5.4");
            }else if (weekDate == 13){
                txtWeightoffWeek.setText("23 g");
                txtSizeoffWeek.setText("7.4");
            }else if (weekDate == 14){
                txtWeightoffWeek.setText("43 g");
                txtSizeoffWeek.setText("8.7");
            }else if (weekDate == 15){
                txtWeightoffWeek.setText("70 g");
                txtSizeoffWeek.setText("10.1");
            }else if (weekDate == 16){
                txtWeightoffWeek.setText("100 g");
                txtSizeoffWeek.setText("11.6");
            }else if (weekDate == 17){
                txtWeightoffWeek.setText("140 g");
                txtSizeoffWeek.setText("13.0");
            }else if (weekDate == 18){
                txtWeightoffWeek.setText("190 g");
                txtSizeoffWeek.setText("14.2");
            }else if (weekDate == 19){
                txtWeightoffWeek.setText("240 g");
                txtSizeoffWeek.setText("15.3");
            }else if (weekDate == 20){
                txtWeightoffWeek.setText("300 g");
                txtSizeoffWeek.setText("25.6");
            }else if (weekDate == 21){
                txtWeightoffWeek.setText("360 g");
                txtSizeoffWeek.setText("26.7");
            }else if (weekDate == 22 || weekDate == 23 || weekDate == 24){
                txtWeightoffWeek.setText("430-600 g");
                txtSizeoffWeek.setText("28-30");
            }else if (weekDate == 25 || weekDate == 26 || weekDate == 27 || weekDate == 28){
                txtWeightoffWeek.setText("600-1000 g");
                txtSizeoffWeek.setText("34-37");
            }else if (weekDate == 29 || weekDate == 30 || weekDate == 31 || weekDate == 32){
                txtWeightoffWeek.setText("1,15-1,7 kg");
                txtSizeoffWeek.setText("38-42");
            }else if (weekDate == 33 || weekDate == 34 || weekDate == 35 || weekDate == 36){
                txtWeightoffWeek.setText("1,9-2,6 kg");
                txtSizeoffWeek.setText("43-47");
            }else if (weekDate == 37 || weekDate == 38 || weekDate == 39 || weekDate == 40){
                txtWeightoffWeek.setText("2,8-4 kg");
                txtSizeoffWeek.setText("48-52");
            }




//            if(date1.after(date2)){
//                Log.e("khoangcach", "date1 sau dat2 ");
//                txtngaydu.setText(String.valueOf(getDaysDiff));
//                txtcothai.setText(String.valueOf("-"+numDate));
//            } else if (date1.before(date2)){
//                txtngaydu.setText(String.valueOf(getDaysDiff));
//                txtcothai.setText(String.valueOf(numDate));
//
//                txtWeekdate.setText(String.valueOf(weekDate));
//                txtDaydate.setText(String.valueOf(dayDate));
//            }


            arc_progress.setMax(100);
            arc_progress.setProgress((int) (numDate / 2.8));


        } catch (ParseException e) {
            Log.e("khoang", "Error "+e.toString() );
            e.printStackTrace();
        }


        String [] arrSolar = dateSolar.split("/");
        if (arrSolar != null){
//            String dateCothai = String.valueOf(30 - Integer.parseInt(arrSolar[0]));
//            String ngaydu = String.valueOf(280 - Integer.parseInt(dateCothai));
//            txtcothai.setText(dateCothai);
//            txtngaydu.setText(ngaydu);
            amduong amduong = new amduong();
            dateLunar = amduong.Solar2Lunar(Integer.parseInt(arrSolar[0]),Integer.parseInt(arrSolar[1]),Integer.parseInt(arrSolar[2]))[0]+"/"+amduong.Solar2Lunar(Integer.parseInt(arrSolar[0]),Integer.parseInt(arrSolar[1]),Integer.parseInt(arrSolar[2]))[1]+"/"+amduong.Solar2Lunar(Integer.parseInt(arrSolar[0]),Integer.parseInt(arrSolar[1]),Integer.parseInt(arrSolar[2]))[2];

            txtlicham.setText(dateLunar);
        }


    }
    private void SelectTK(View view) {
        selectchitiettk = view.findViewById(R.id.selectchitiettk);
        selectchitiettk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ThaiKiActivity.class);
                startActivity(intent);
            }
        });
    }

    private void realTime() {
        Date today = new Date(System.currentTimeMillis());
        SimpleDateFormat timeFormat = new SimpleDateFormat("dd/MM/yyyy");
        timeCurrent = timeFormat.format(today.getTime());
    }
}
