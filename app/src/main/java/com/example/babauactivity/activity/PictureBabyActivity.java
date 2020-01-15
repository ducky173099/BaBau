package com.example.babauactivity.activity;

import androidx.appcompat.app.ActionBar;
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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.babauactivity.R;
import com.example.babauactivity.adapter.PicturebabyAdapter;
import com.example.babauactivity.model.DataPicturebaby;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PictureBabyActivity extends AppCompatActivity implements PicturebabyAdapter.ItemClick { // buco 6 interface alt + emter
    Toolbar toolbarPicture;
    RecyclerView recyclerViewPicture;
    ArrayList<DataPicturebaby> dataPicturebabies;
    PicturebabyAdapter picturebabyAdapter;

    TextView tittletoolbar_camnang;
    ImageView back_tb_camnang;
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
            dataPicturebabies.add(new DataPicturebaby(R.drawable.bb));
        }

        picturebabyAdapter = new PicturebabyAdapter(getApplicationContext(), dataPicturebabies);
        recyclerViewPicture.setAdapter(picturebabyAdapter);

        picturebabyAdapter.setClick(this); // buoc 5 interface
    }

    private void setToolbar() {
//        toolbarPicture = findViewById(R.id.toolbar_picturebaby);
//
//        setSupportActionBar(toolbarPicture);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//        toolbarPicture.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                finish();
//            }
//        });

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
        tittletoolbar_camnang.setText("Ảnh Đẹp Bé Yêu");
        back_tb_camnang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }


    @Override
    public void ClickPicture(int position) { // buco 7 interface
        Intent intent = new Intent(this, ItemPictureActivity.class);
        intent.putExtra("key_img",dataPicturebabies);
        intent.putExtra("pos", position);
        startActivity(intent);

    }
}
