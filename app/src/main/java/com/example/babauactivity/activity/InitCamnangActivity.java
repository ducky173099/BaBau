package com.example.babauactivity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;

import com.example.babauactivity.R;

public class InitCamnangActivity extends AppCompatActivity {
    Toolbar toolbar_tp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init_camnang);

        setToolbar();
    }

    private void setToolbar() {
        toolbar_tp = findViewById(R.id.toolbar_tp);

        setSupportActionBar(toolbar_tp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar_tp.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
