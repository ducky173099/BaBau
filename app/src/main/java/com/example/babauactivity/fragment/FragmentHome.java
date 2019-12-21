package com.example.babauactivity.fragment;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.babauactivity.R;
import com.example.babauactivity.activity.DiaryActivity;
import com.example.babauactivity.adapter.DiaryAdapter;
import com.example.babauactivity.database.Database;
import com.example.babauactivity.database.DatabaseHelper;
import com.example.babauactivity.model.DataDiary;
import com.example.babauactivity.model.DataPicturebaby;

import java.sql.Blob;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static android.app.Activity.RESULT_OK;

public class FragmentHome extends Fragment {
    Button btnNhatky;
    RecyclerView recycler_Diary;
    ArrayList<DataDiary> dataDiaries;
    DiaryAdapter diaryAdapter;
    TextView txtDiary;


    String timeDiary;

    int REQUEST_CODE_EDIT = 123;
    String contentNhatky;
    byte[] anh;

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        realTime();
        dataDiaries = new ArrayList<>();

        if (requestCode == REQUEST_CODE_EDIT && resultCode == RESULT_OK && data != null){
            contentNhatky = data.getStringExtra("dairy");
            anh = data.getByteArrayExtra("anh");
            Log.e("Diaryyyyyy", "data diary: " + contentNhatky );

        }
        Log.e("Diary", "data diary: " + contentNhatky );
        Log.e("Diary", "time diary: " + timeDiary );
        Log.e("Diary", "picture: " + anh );
        diaryAdapter = new DiaryAdapter(getContext(),dataDiaries);


        diaryAdapter.AddDairy(new DataDiary(timeDiary,contentNhatky,anh));

        recycler_Diary.setAdapter(diaryAdapter);
        diaryAdapter.notifyDataSetChanged();
        Log.e("Diary", "data size: " + dataDiaries.size() );

    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home, container, false);

        recycler_Diary = view.findViewById(R.id.recycler_Diary);
        txtDiary = view.findViewById(R.id.txtDiary);
        recycler_Diary.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));



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


    private void realTime() {
        Date today = new Date(System.currentTimeMillis());
        SimpleDateFormat timeFormat= new SimpleDateFormat("hh:mm dd/MM/yyyy");
        timeDiary = timeFormat.format(today.getTime());
    }
}
