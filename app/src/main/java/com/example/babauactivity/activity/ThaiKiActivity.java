package com.example.babauactivity.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.babauactivity.R;
import com.example.babauactivity.adapter.DateThaikiAdapter;
import com.example.babauactivity.fragment.FragThaiki;
import com.example.babauactivity.fragment.FragmentHome;
import com.example.babauactivity.model.DataDatetk;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class ThaiKiActivity extends AppCompatActivity implements DateThaikiAdapter.clickRecycler{
    Toolbar toolbarThaiki;
    TabLayout tabLayout;
    private ViewPager viewPager_tk;
    private int[] tabIcons = {
            R.drawable.ic_one,
            R.drawable.ic_one,
            R.drawable.ic_one
    };

    ArrayList<DataDatetk> dataDatetk;
    DateThaikiAdapter dateThaikiAdapter;

    RecyclerView recyclerViewDatetk;
    FrameLayout frame_cont;
    int item_recycler = 0;

    TextView txt2d, txt3d, txtmau, txtvideo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thai_ki);
        Anhxa();
        setToolbar();
        setDataDatetk();

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_cont, new FragThaiki()).commit();


    }




    private void setDataDatetk() {
        recyclerViewDatetk = findViewById(R.id.recycler_datethaiki);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.HORIZONTAL, false);
        recyclerViewDatetk.setLayoutManager(layoutManager);

        dataDatetk = new ArrayList<>();
        dataDatetk.add(new DataDatetk("1","06/12"));
        dataDatetk.add(new DataDatetk("2","13/12"));
        dataDatetk.add(new DataDatetk("3","20/12"));
        dataDatetk.add(new DataDatetk("4","27/12"));
        dataDatetk.add(new DataDatetk("5","01/01"));
        dataDatetk.add(new DataDatetk("6","10/01"));
        dataDatetk.add(new DataDatetk("7","17/01"));
        dataDatetk.add(new DataDatetk("8","24/01"));
        dataDatetk.add(new DataDatetk("9","31/01"));
        dataDatetk.add(new DataDatetk("10","07/02"));
        dataDatetk.add(new DataDatetk("12","14/02"));
        dataDatetk.add(new DataDatetk("13","21/02"));
        dataDatetk.add(new DataDatetk("14","28/02"));
        dataDatetk.add(new DataDatetk("15","06/03"));
        dataDatetk.add(new DataDatetk("16","13/03"));
        dataDatetk.add(new DataDatetk("17","20/03"));
        dataDatetk.add(new DataDatetk("18","27/03"));
        dataDatetk.add(new DataDatetk("19","03/04"));
        dataDatetk.add(new DataDatetk("20","10/04"));
        dataDatetk.add(new DataDatetk("21","17/04"));
        dataDatetk.add(new DataDatetk("22","24/04"));
        dataDatetk.add(new DataDatetk("23","06/12"));
        dataDatetk.add(new DataDatetk("24","06/12"));
        dataDatetk.add(new DataDatetk("25","06/12"));
        dataDatetk.add(new DataDatetk("26","06/12"));
        dataDatetk.add(new DataDatetk("27","06/12"));
        dataDatetk.add(new DataDatetk("28","06/12"));
        dataDatetk.add(new DataDatetk("29","06/12"));
        dataDatetk.add(new DataDatetk("30","06/12"));
        dataDatetk.add(new DataDatetk("31","06/12"));
        dataDatetk.add(new DataDatetk("32","06/12"));
        dataDatetk.add(new DataDatetk("33","06/12"));
        dataDatetk.add(new DataDatetk("34","06/12"));
        dataDatetk.add(new DataDatetk("35","06/12"));
        dataDatetk.add(new DataDatetk("36","06/12"));
        dataDatetk.add(new DataDatetk("37","06/12"));
        dataDatetk.add(new DataDatetk("38","06/12"));
        dataDatetk.add(new DataDatetk("39","06/12"));
        dataDatetk.add(new DataDatetk("40","06/12"));



        dateThaikiAdapter = new DateThaikiAdapter(dataDatetk, this);
        recyclerViewDatetk.setAdapter(dateThaikiAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menutool, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menureload:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setToolbar() {
        setSupportActionBar(toolbarThaiki);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        toolbarThaiki.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbarThaiki.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void Anhxa() {
        toolbarThaiki = findViewById(R.id.toolbar_thaiki);
        frame_cont = findViewById(R.id.frame_cont);
        txt2d = findViewById(R.id.txt2d);
        txt3d = findViewById(R.id.txt3d);
        txtmau = findViewById(R.id.txtmau);
        txtvideo = findViewById(R.id.txtvideo);




//        viewPager_tk = findViewById(R.id.viewpager_tk);
//        mvpdemo.setAdapter(new ThaikiAdapter(getSupportFragmentManager()));
//        TabLayout tabLayout = findViewById(R.id.tablayout_tk);
//        tabLayout.setupWithViewPager(mvpdemo);

//        thaikiAdapter = new ThaikiAdapter(getSupportFragmentManager());
//        thaikiAdapter.addFragment(new FragThaiki(), "Tab 1");
//        thaikiAdapter.addFragment(new FragThaiki(), "Tab 2");
//        thaikiAdapter.addFragment(new FragThaiki(), "Tab 3");
//        viewPager_tk.setAdapter(thaikiAdapter);
//        tabLayout.setupWithViewPager(viewPager_tk);
//        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
//        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
//        tabLayout.getTabAt(2).setIcon(tabIcons[2]);


    }

    @Override
    public void onClickItem(int position) { // buoc 5 interface
        Toast.makeText(this, "recycler" + position, Toast.LENGTH_SHORT).show();

    }


}
