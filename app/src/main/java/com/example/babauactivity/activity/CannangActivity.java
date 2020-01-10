package com.example.babauactivity.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.babauactivity.R;
import com.example.babauactivity.adapter.CannangAdapter;
import com.example.babauactivity.adapter.FeetAdapter;
import com.example.babauactivity.model.DataCannang;
import com.example.babauactivity.model.DataFeet;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class CannangActivity extends AppCompatActivity implements CannangAdapter.ItemClick {
    Toolbar toolbar_cannang;
    EditText edtWeight;
    ImageView imgAddWeight;
    RecyclerView recycler_Cannang;

    ArrayList<DataCannang> dataCannangs;
    CannangAdapter cannangAdapter;

    public String rtime;

    TextView tittletoolbar_camnang;
    ImageView back_tb_camnang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cannang);

        setToolbar();
        AddWeight();
        realTime();
    }


    private void AddWeight() {
        edtWeight = findViewById(R.id.edtWeight);
        imgAddWeight = findViewById(R.id.imgAddWeight);

        dataCannangs = new ArrayList<>();
        cannangAdapter = new CannangAdapter(getApplicationContext(), dataCannangs);

        imgAddWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String weight = edtWeight.getText().toString();

                recycler_Cannang = findViewById(R.id.recycler_Cannang);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
                recycler_Cannang.setLayoutManager(layoutManager);
                cannangAdapter.AddCannang(new DataCannang(R.drawable.three,rtime,weight));
                recycler_Cannang.setAdapter(cannangAdapter);

                edtWeight.setText(null);
            }
        });

        cannangAdapter.setClickCannang(this);

    }

    private void realTime() {
        Date today = new Date(System.currentTimeMillis());
        SimpleDateFormat timeFormat= new SimpleDateFormat("hh:mm - dd/MM/yyyy");
        rtime = timeFormat.format(today.getTime());
    }


    private void setToolbar() {
//        toolbar_cannang = findViewById(R.id.toolbar_cannang);
//
//        setSupportActionBar(toolbar_cannang);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//        toolbar_cannang.setNavigationOnClickListener(new View.OnClickListener() {
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
        tittletoolbar_camnang.setText("Theo dõi cân nặng Bà Bầu");
        back_tb_camnang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    @Override
    public void ClickDelCan(int position) {

    }
}
