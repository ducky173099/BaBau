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
import android.widget.TextView;

import com.example.babauactivity.R;
import com.example.babauactivity.activity.DiaryActivity;
import com.example.babauactivity.activity.MainActivity;
import com.example.babauactivity.activity.SplashActivity;
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
import java.text.SimpleDateFormat;
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
    TextView namebeyeu, nickbeyeu,txtdatedshome,txtcothai,txtngaydu,txtlicham;


    String timeDiary;

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
        proGressBar(view);

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

    private void proGressBar(View view) {
        arc_progress = view.findViewById(R.id.arc_progress);

    }
    public void onSelect() {
        arc_progress.setProgress((int)(Math.random() * 100));

    }

    private  void getDataSplash(View view){
        namebeyeu = view.findViewById(R.id.namebeyeu);
        nickbeyeu = view.findViewById(R.id.nickbeyeu);
        txtdatedshome = view.findViewById(R.id.txtdatedshome);
        txtcothai = view.findViewById(R.id.txtcothai);
        txtngaydu = view.findViewById(R.id.txtngaydu);
        txtlicham = view.findViewById(R.id.txtlicham);

        SharedPreferences sharedSaveInfo = getContext().getSharedPreferences("saveInfo", MODE_PRIVATE);
        txtdatedshome.setText(sharedSaveInfo.getString("getTextDate",""));
        namebeyeu.setText(sharedSaveInfo.getString("keyname","Tên bé Yêu"));
        nickbeyeu.setText(sharedSaveInfo.getString("keynick","Nickname bé"));


        String dateSolar = sharedSaveInfo.getString("getTextDate","");
        String [] arrSolar = dateSolar.split("/");
//        Log.e("arrSolar", "getDataSplash: " +arrSolar[0] + "/" + arrSolar[1] + "/"  + arrSolar[2]  );

        if (arrSolar != null){
            String dateCothai = String.valueOf(30 - Integer.parseInt(arrSolar[0]));
            String ngaydu = String.valueOf(280 - Integer.parseInt(dateCothai));
            txtcothai.setText(dateCothai);
            txtngaydu.setText(ngaydu);
            amduong amduong = new amduong();
            dateLunar = amduong.Solar2Lunar(Integer.parseInt(arrSolar[0]),Integer.parseInt(arrSolar[1]),Integer.parseInt(arrSolar[2]))[0]+"/"+amduong.Solar2Lunar(Integer.parseInt(arrSolar[0]),Integer.parseInt(arrSolar[1]),Integer.parseInt(arrSolar[2]))[1]+"/"+amduong.Solar2Lunar(Integer.parseInt(arrSolar[0]),Integer.parseInt(arrSolar[1]),Integer.parseInt(arrSolar[2]))[2];

            txtlicham.setText(dateLunar);
        }



    }


    private void realTime() {
        Date today = new Date(System.currentTimeMillis());
        SimpleDateFormat timeFormat= new SimpleDateFormat("hh:mm dd/MM/yyyy");
        timeDiary = timeFormat.format(today.getTime());
    }
}
