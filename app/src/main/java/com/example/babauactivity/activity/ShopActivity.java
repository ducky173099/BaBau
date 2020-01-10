package com.example.babauactivity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.babauactivity.R;
import com.example.babauactivity.adapter.TabCamnangAdapter;
import com.example.babauactivity.adapter.TabShopAdapter;
import com.google.android.material.tabs.TabLayout;

public class ShopActivity extends AppCompatActivity {
    Toolbar toolbar_shop;
    TabLayout tab_shop;
    ViewPager pager_shop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        actiontoolbar();
        initView();
    }

    private void initView() {
        pager_shop = findViewById(R.id.pager_shop);
        tab_shop = findViewById(R.id.tab_shop);

        TabShopAdapter tabShopAdapter = new TabShopAdapter(getSupportFragmentManager());
        pager_shop.setAdapter(tabShopAdapter);
        tab_shop.setupWithViewPager(pager_shop);

        pager_shop.setOffscreenPageLimit(3);
        pager_shop.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                FragmentTransaction tf = getSupportFragmentManager().beginTransaction();
                tf.detach(tabShopAdapter.getItem(position));
                tf.attach(tabShopAdapter.getItem(position));
                tf.commit();
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.e("TTT", "onPageScrolled: 3     "+state );
            }
        });

    }

    private void actiontoolbar() {
        toolbar_shop = findViewById(R.id.toolbar_shop);

        setSupportActionBar(toolbar_shop);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar_shop.setNavigationIcon(R.drawable.back24);
        toolbar_shop.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
