package com.example.babauactivity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.babauactivity.R;
import com.example.babauactivity.fragment.FragKhongan;
import com.example.babauactivity.fragment.FragNenan;

public class HoatDongActivity extends AppCompatActivity {
    Toolbar toolbar_hoatdong;
    LinearLayout linear_nenan,linear_khongan;
    TextView txtnenan, txtkhongan;
    FrameLayout frame_hoatdong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoat_dong);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_hoatdong, new FragNenan()).commit();
        setToolbar();
        initView();
    }

    private void initView() {
        linear_nenan = findViewById(R.id.linear_nenan);
        linear_khongan = findViewById(R.id.linear_khongan);
        txtnenan = findViewById(R.id.txtnenan);
        txtkhongan = findViewById(R.id.txtkhongan);
        frame_hoatdong = findViewById(R.id.frame_hoatdong);

        linear_nenan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linear_nenan.setBackgroundResource(R.drawable.custom_radiusleft);
                txtnenan.setTextColor(Color.WHITE);

                linear_khongan.setBackgroundResource(R.drawable.custom_radiusrightfff);
                txtkhongan.setTextColor(getResources().getColor(R.color.xanhtop));

                getSupportFragmentManager().beginTransaction().replace(R.id.frame_hoatdong, new FragNenan()).commit();

            }
        });
        linear_khongan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linear_khongan.setBackgroundResource(R.drawable.custom_radiusright);
                txtkhongan.setTextColor(Color.WHITE);

                linear_nenan.setBackgroundResource(R.drawable.custom_radiusleftfff);
                txtnenan.setTextColor(getResources().getColor(R.color.xanhtop));

                getSupportFragmentManager().beginTransaction().replace(R.id.frame_hoatdong, new FragKhongan()).commit();
            }
        });
    }

    private void setToolbar() {
        toolbar_hoatdong = findViewById(R.id.toolbar_hoatdong);
        setSupportActionBar(toolbar_hoatdong);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar_hoatdong.setNavigationIcon(R.drawable.back24);
        toolbar_hoatdong.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
