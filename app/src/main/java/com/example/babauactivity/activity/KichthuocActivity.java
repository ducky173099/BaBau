package com.example.babauactivity.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.babauactivity.R;
import com.example.babauactivity.adapter.SizeBabyAdapter;
import com.example.babauactivity.model.DataSizebaby;

import java.util.ArrayList;
import java.util.Objects;

public class KichthuocActivity extends AppCompatActivity {
    Toolbar toolbarKichthuoc;
    RecyclerView recyclerViewSizeBaby;
    ArrayList<DataSizebaby> dataSizebaby;
    SizeBabyAdapter sizeBabyAdapter;

    TextView tittletoolbar_camnang;
    ImageView back_tb_camnang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kichthuoc);
        setToolbar();
        setRecycler();

    }

    private void setRecycler() {
        recyclerViewSizeBaby = findViewById(R.id.recycler_kichthuoc);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
        recyclerViewSizeBaby.setLayoutManager(layoutManager);

        dataSizebaby = new ArrayList<>();
        for (int i = 0; i <= 20; i ++){
            dataSizebaby.add(new DataSizebaby(R.drawable.ic_sesame,"Tuần 5","Hạt mè","2 mm - 0.1 g (Đo từ đầu đến mông)"));
        }

        sizeBabyAdapter = new SizeBabyAdapter(this, dataSizebaby);
        recyclerViewSizeBaby.setAdapter(sizeBabyAdapter);


    }

    private void setToolbar() {
//        toolbarKichthuoc = findViewById(R.id.toolbar_kichthuoc);
//        setSupportActionBar(toolbarKichthuoc);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        toolbarKichthuoc.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                finish();
//            }
//        });


        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);

        getSupportActionBar().setDisplayShowHomeEnabled(false);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);

        View view = getLayoutInflater().inflate(R.layout.toolbar, null);
        ActionBar.LayoutParams layoutParams = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT,
                ActionBar.LayoutParams.MATCH_PARENT);
        getSupportActionBar().setCustomView(view, layoutParams);
        Toolbar parent = (Toolbar) view.getParent();
        parent.setContentInsetsAbsolute(0, 0);

        tittletoolbar_camnang = view.findViewById(R.id.tittletoolbar_camnang);
        back_tb_camnang = view.findViewById(R.id.back_tb_camnang);
        tittletoolbar_camnang.setText("Kích thước thai nhi");
        back_tb_camnang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }


}
