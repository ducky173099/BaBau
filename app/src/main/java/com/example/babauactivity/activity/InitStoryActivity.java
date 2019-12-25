package com.example.babauactivity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.babauactivity.R;

public class InitStoryActivity extends AppCompatActivity {
    Toolbar toolbar_initStory;
    TextView nameStory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init_story);

        actionToolbar();
        initView();
    }

    private void initView() {
        nameStory = findViewById(R.id.nameStory);

        Intent intent = getIntent();

        String getStory = intent.getStringExtra("story");

        nameStory.setText(getStory);


    }

    private void actionToolbar() {
        toolbar_initStory = findViewById(R.id.toolbar_initStory);
        setSupportActionBar(toolbar_initStory);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar_initStory.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}
