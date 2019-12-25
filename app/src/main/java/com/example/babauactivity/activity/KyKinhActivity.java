package com.example.babauactivity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.babauactivity.R;
import com.example.babauactivity.adapter.KykinhAdapter;
import com.example.babauactivity.model.DataKykinh;

import java.util.ArrayList;

public class KyKinhActivity extends AppCompatActivity implements KykinhAdapter.ItemClick {
    RecyclerView recycler_kykinh;
    ArrayList<DataKykinh> dataKykinhs;
    KykinhAdapter kykinhAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ky_kinh);

        addDateKyKinh();
    }

    private void addDateKyKinh() {
        recycler_kykinh = findViewById(R.id.recycler_kykinh);
        recycler_kykinh.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));
        dataKykinhs = new ArrayList<>();
        for (int i=15;i<41;i++){
            dataKykinhs.add(new DataKykinh(""+i));
        }

        kykinhAdapter = new KykinhAdapter(getApplicationContext(), dataKykinhs);
        recycler_kykinh.setAdapter(kykinhAdapter);

        kykinhAdapter.setClickKykinh(this);


    }

    @Override
    public void ClickKykinh(int posotion) {
    }
}
