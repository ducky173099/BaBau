package com.example.babauactivity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.babauactivity.R;
import com.example.babauactivity.adapter.ImageAdapter;
import com.example.babauactivity.model.DataPicturebaby;

import java.util.ArrayList;

public class ItemPictureActivity extends AppCompatActivity {
    ViewPager pager_baby;
    int poss;
    ArrayList<DataPicturebaby> pictureArr;
    ImageAdapter imageAdapter;
    ImageView imgpagerdel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_picture);
        imgpagerdel = findViewById(R.id.imgpagerdel);

        pictureArr = new ArrayList<>();
        pager_baby = findViewById(R.id.pager_baby);

        Intent intent = getIntent();

        poss = intent.getIntExtra("pos",0);
        pictureArr = (ArrayList<DataPicturebaby>) intent.getSerializableExtra("key_img");

        imageAdapter = new ImageAdapter( pictureArr,this);
        pager_baby.setAdapter(imageAdapter);
        pager_baby.setCurrentItem(poss);


        imgpagerdel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}
