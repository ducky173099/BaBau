package com.example.babauactivity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.babauactivity.R;
import com.example.babauactivity.adapter.TabQuatationAdapter;
import com.google.android.material.tabs.TabLayout;

public class QuatationActivity extends AppCompatActivity {
    Toolbar toolbar_quatation;
    ViewPager pager_quatation;
    TabLayout tab_quatation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quatation);

        actiontoolbar();
        initView();

    }

    private void initView() {
        pager_quatation = findViewById(R.id.pager_quatation);
        tab_quatation = findViewById(R.id.tab_quatation);

        TabQuatationAdapter tabQuatationAdapter = new TabQuatationAdapter(getSupportFragmentManager());
        pager_quatation.setAdapter(tabQuatationAdapter);
        tab_quatation.setupWithViewPager(pager_quatation);

        pager_quatation.setOffscreenPageLimit(2);

        pager_quatation.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.e("AAA", "onPageSelected: sssssssssssss");
                FragmentTransaction tf = getSupportFragmentManager().beginTransaction();
                tf.detach(tabQuatationAdapter.getItem(position));
                tf.attach(tabQuatationAdapter.getItem(position));
                tf.commit();
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.e("TTT", "onPageScrolled: 3     "+state );
            }
        });
    }

    private void actiontoolbar() {
        toolbar_quatation = findViewById(R.id.toolbar_quatation);

        setSupportActionBar(toolbar_quatation);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar_quatation.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
