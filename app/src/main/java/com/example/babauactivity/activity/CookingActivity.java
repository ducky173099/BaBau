package com.example.babauactivity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.babauactivity.R;
import com.example.babauactivity.adapter.TabPregnancyAdapter;
import com.example.babauactivity.adapter.TabShopAdapter;
import com.google.android.material.tabs.TabLayout;

public class CookingActivity extends AppCompatActivity {
    Toolbar toolbar_pregnancy;
    TabLayout tab_pregnancy;
    ViewPager pager_pregnancy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cooking);

        actiontoolbar();
        initView();
    }

    private void initView() {
        pager_pregnancy = findViewById(R.id.pager_pregnancy);
        tab_pregnancy = findViewById(R.id.tab_pregnancy);

        TabPregnancyAdapter tabPregnancyAdapter = new TabPregnancyAdapter(getSupportFragmentManager());
        pager_pregnancy.setAdapter(tabPregnancyAdapter);
        tab_pregnancy.setupWithViewPager(pager_pregnancy);

        pager_pregnancy.setOffscreenPageLimit(3);
        pager_pregnancy.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.e("AAA", "onPageSelected: sssssssssssss");
                FragmentTransaction tf = getSupportFragmentManager().beginTransaction();
                tf.detach(tabPregnancyAdapter.getItem(position));
                tf.attach(tabPregnancyAdapter.getItem(position));
                tf.commit();
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.e("TTT", "onPageScrolled: 3     "+state );
            }
        });

    }

    private void actiontoolbar() {
        toolbar_pregnancy = findViewById(R.id.toolbar_pregnancy);

        setSupportActionBar(toolbar_pregnancy);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar_pregnancy.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
