package com.example.babauactivity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.babauactivity.R;
import com.example.babauactivity.adapter.TabNameAdapter;
import com.example.babauactivity.adapter.TabNickAdapter;
import com.google.android.material.tabs.TabLayout;

public class NickActivity extends AppCompatActivity {
    Toolbar toolbar_nickname;
    ViewPager pager_selectnick;
    TabLayout tab_selectnick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nick);

        actiontoolbar();
        initView();
    }

    private void initView() {
        pager_selectnick = findViewById(R.id.pager_selectnick);
        tab_selectnick = findViewById(R.id.tab_selectnick);

        TabNickAdapter tabNickAdapter = new TabNickAdapter(getSupportFragmentManager());
        pager_selectnick.setAdapter(tabNickAdapter);
        tab_selectnick.setupWithViewPager(pager_selectnick);

        pager_selectnick.setOffscreenPageLimit(3);
        pager_selectnick.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.e("AAA", "onPageSelected: sssssssssssss");
                FragmentTransaction tf = getSupportFragmentManager().beginTransaction();
                tf.detach(tabNickAdapter.getItem(position));
                tf.attach(tabNickAdapter.getItem(position));
                tf.commit();
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.e("TTT", "onPageScrolled: 3     "+state );
            }
        });
    }

    private void actiontoolbar() {
        toolbar_nickname = findViewById(R.id.toolbar_nickname);

        setSupportActionBar(toolbar_nickname);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar_nickname.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
