package com.example.babauactivity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.example.babauactivity.R;
import com.example.babauactivity.adapter.TabCamnangAdapter;
import com.google.android.material.tabs.TabLayout;

public class CamnangActivity extends AppCompatActivity {
    Toolbar toolbar_camnang;
    ViewPager pager_camnang;
    TabLayout tab_camnang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camnang);
        actiontoolbar();
        initView();

    }

    private void initView() {
        pager_camnang = findViewById(R.id.pager_camnang);
        tab_camnang = findViewById(R.id.tab_camnang);

        TabCamnangAdapter tabCamnangAdapter = new TabCamnangAdapter(getSupportFragmentManager());
        pager_camnang.setAdapter(tabCamnangAdapter);
        tab_camnang.setupWithViewPager(pager_camnang);

    }

    private void actiontoolbar() {
        toolbar_camnang = findViewById(R.id.toolbar_camnang);

        setSupportActionBar(toolbar_camnang);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar_camnang.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
