package com.example.babauactivity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.babauactivity.R;
import com.example.babauactivity.adapter.TabStoryAdapter;
import com.google.android.material.tabs.TabLayout;

public class StoryActivity extends AppCompatActivity {
    Toolbar toolbar_story;
    ViewPager pager_story;
    TabLayout tab_story;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        actiontoolbar();
        initView();
    }

    private void initView() {
        pager_story = findViewById(R.id.pager_story);
        tab_story = findViewById(R.id.tab_story);

        TabStoryAdapter tabStoryAdapter = new TabStoryAdapter(getSupportFragmentManager());
        pager_story.setAdapter(tabStoryAdapter);
        tab_story.setupWithViewPager(pager_story);

        pager_story.setOffscreenPageLimit(2);
        pager_story.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.e("AAA", "onPageSelected: sssssssssssss");
                FragmentTransaction tf = getSupportFragmentManager().beginTransaction();
                tf.detach(tabStoryAdapter.getItem(position));
                tf.attach(tabStoryAdapter.getItem(position));
                tf.commit();
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.e("TTT", "onPageScrolled: 3     "+state );
            }
        });


    }

    private void actiontoolbar() {
        toolbar_story = findViewById(R.id.toolbar_story);

        setSupportActionBar(toolbar_story);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar_story.setNavigationIcon(R.drawable.back24);
        toolbar_story.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
