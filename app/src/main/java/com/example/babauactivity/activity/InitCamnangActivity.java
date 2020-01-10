package com.example.babauactivity.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.babauactivity.R;

import java.util.Objects;

public class InitCamnangActivity extends AppCompatActivity {
//    Toolbar toolbar_initcamnang;
    String content;
    TextView tittletoolbar_camnang;
    ImageView back_tb_camnang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init_camnang);
        Intent intent = getIntent();
        content = intent.getStringExtra("key_camnang");
        Log.e("titlecamnag", "onCreate: " + content );
        setToolbar();
    }

    private void setToolbar() {

        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);

        getSupportActionBar().setDisplayShowHomeEnabled(false);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);

        View view = getLayoutInflater().inflate(R.layout.toolbar, null);
        ActionBar.LayoutParams layoutParams = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT,
                ActionBar.LayoutParams.MATCH_PARENT);
        getSupportActionBar().setCustomView(view, layoutParams);
        Toolbar parent = (Toolbar) view.getParent();
        parent.setContentInsetsAbsolute(0, 0);

        tittletoolbar_camnang = view.findViewById(R.id.tittletoolbar_camnang);
        back_tb_camnang = view.findViewById(R.id.back_tb_camnang);
        tittletoolbar_camnang.setText(content);
        back_tb_camnang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
