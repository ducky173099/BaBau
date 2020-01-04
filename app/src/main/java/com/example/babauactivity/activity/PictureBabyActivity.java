package com.example.babauactivity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.example.babauactivity.R;
import com.example.babauactivity.adapter.PicturebabyAdapter;
import com.example.babauactivity.model.DataPicturebaby;

import java.util.ArrayList;
import java.util.List;

public class PictureBabyActivity extends AppCompatActivity implements PicturebabyAdapter.ItemClick { // buco 6 interface alt + emter
    Toolbar toolbarPicture;
    RecyclerView recyclerViewPicture;
    ArrayList<DataPicturebaby> dataPicturebabies;
    PicturebabyAdapter picturebabyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_baby);
        setToolbar();
        setData();


    }

    private void setData() {
        recyclerViewPicture = findViewById(R.id.recycler_picturebaby);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerViewPicture.setLayoutManager(gridLayoutManager);

        dataPicturebabies = new ArrayList<>();
        for (int i = 0; i <= 20 ; i++) {
            dataPicturebabies.add(new DataPicturebaby(R.drawable.mushroom));
        }
//        dataPicturebabies.add(new DataPicturebaby(R.drawable.bb));
//        dataPicturebabies.add(new DataPicturebaby(R.drawable.bb2));
//        dataPicturebabies.add(new DataPicturebaby(R.drawable.bb3));
//        dataPicturebabies.add(new DataPicturebaby(R.drawable.bb4));
//        dataPicturebabies.add(new DataPicturebaby(R.drawable.bb5));
//        dataPicturebabies.add(new DataPicturebaby(R.drawable.bb6));
//        dataPicturebabies.add(new DataPicturebaby(R.drawable.bb));
//        dataPicturebabies.add(new DataPicturebaby(R.drawable.bb2));

        picturebabyAdapter = new PicturebabyAdapter(getApplicationContext(), dataPicturebabies);
        recyclerViewPicture.setAdapter(picturebabyAdapter);

        picturebabyAdapter.setClick(this); // buoc 5 interface
    }

    private void setToolbar() {
        toolbarPicture = findViewById(R.id.toolbar_picturebaby);

        setSupportActionBar(toolbarPicture);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbarPicture.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


    @Override
    public void ClickPicture(int position) { // buco 7 interface
        Toast.makeText(this, "anh " + position, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, ItemPictureActivity.class);
        intent.putExtra("key_img",dataPicturebabies);
        intent.putExtra("pos", position);
        startActivity(intent);

    }
}
