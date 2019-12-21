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
import com.example.babauactivity.fragment.FragTPKan;
import com.example.babauactivity.fragment.FragTPan;

public class ThucphamActivity extends AppCompatActivity {
    Toolbar toolbar_thucpham;
    LinearLayout l_nenan, l_khongan;
    TextView txt_nenan, txt_khongan;
    FrameLayout frame_thucpham;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thucpham);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_thucpham, new FragTPan()).commit();
        setToolbar();
        initView();
    }

    private void initView() {
        l_nenan = findViewById(R.id.l_nenan);
        l_khongan = findViewById(R.id.l_khongan);
        txt_nenan = findViewById(R.id.txt_nenan);
        txt_khongan = findViewById(R.id.txt_khongan);
        frame_thucpham = findViewById(R.id.frame_thucpham);

        l_nenan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                l_nenan.setBackgroundResource(R.drawable.custom_radiusleft);
                txt_nenan.setTextColor(Color.WHITE);

                l_khongan.setBackgroundResource(R.drawable.custom_radiusrightfff);
                txt_khongan.setTextColor(getResources().getColor(R.color.xanhtop));

                getSupportFragmentManager().beginTransaction().replace(R.id.frame_thucpham, new FragTPan()).commit();

            }
        });
        l_khongan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                l_khongan.setBackgroundResource(R.drawable.custom_radiusright);
                txt_khongan.setTextColor(Color.WHITE);

                l_nenan.setBackgroundResource(R.drawable.custom_radiusleftfff);
                txt_nenan.setTextColor(getResources().getColor(R.color.xanhtop));

                getSupportFragmentManager().beginTransaction().replace(R.id.frame_thucpham, new FragTPKan()).commit();
            }
        });

    }

    private void setToolbar() {
        toolbar_thucpham = findViewById(R.id.toolbar_thucpham);

        setSupportActionBar(toolbar_thucpham);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar_thucpham.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
