package com.example.babauactivity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.babauactivity.R;
import com.example.babauactivity.adapter.TabNameAdapter;
import com.google.android.material.tabs.TabLayout;

public class ChonTenActivity extends AppCompatActivity {
    Toolbar toolbarChonten;
    ViewPager viewPagerSelectname;
    TabLayout tabLayoutSelectName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chon_ten);
        Anhxa();
        actiontoolbar();
        initView();

    }

    private void initView() {
        viewPagerSelectname = findViewById(R.id.viewpagerselectname);
        tabLayoutSelectName = findViewById(R.id.tab_selectname);

        TabNameAdapter tabNameAdapter = new TabNameAdapter(getSupportFragmentManager());
        viewPagerSelectname.setAdapter(tabNameAdapter);
        tabLayoutSelectName.setupWithViewPager(viewPagerSelectname);

        viewPagerSelectname.setOffscreenPageLimit(3);


        viewPagerSelectname.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                Log.e("TTT", "onPageScrolled: 1  " );
            }

            @Override
            public void onPageSelected(int position) {

                FragmentTransaction tf = getSupportFragmentManager().beginTransaction();
                tf.detach(tabNameAdapter.getItem(position));
                tf.attach(tabNameAdapter.getItem(position));
                tf.commit();
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.e("TTT", "onPageScrolled: 3     "+state );
            }
        });

    }

    private void actiontoolbar() {
        setSupportActionBar(toolbarChonten);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarChonten.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void Anhxa() {
        toolbarChonten = findViewById(R.id.toolbar_chonten);

    }
}
