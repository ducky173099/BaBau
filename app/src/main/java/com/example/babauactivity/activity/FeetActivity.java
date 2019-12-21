package com.example.babauactivity.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.babauactivity.R;
import com.example.babauactivity.adapter.DateThaikiAdapter;
import com.example.babauactivity.adapter.FeetAdapter;
import com.example.babauactivity.model.DataFeet;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;

public class FeetActivity extends AppCompatActivity implements FeetAdapter.ItemClick{
    Toolbar toolbar_feet;
    TextView  txtTimer, txtFeet;
    Button btnStart;

    ImageView imgdelfeet;

    RecyclerView recyclerView_feet;
    ArrayList<DataFeet> dataFeets;
    FeetAdapter feetAdapter;

    TextView txtRealtime;

    LinearLayout increase_feet;
    private static int count = 0;
    private String value;

    public String timer;
    public String timenow;
    public String Val;

    private DataFeet dataFeet;

    long startTime = 0;
    Handler timerHandler = new Handler();

    Runnable timerRunnable = new Runnable() {
        @Override
        public void run() {
            long millis = System.currentTimeMillis() - startTime;
            int seconds = (int) (millis / 1000);
            int minutes = seconds / 60;
            int hours = minutes/60;
            seconds = seconds % 60;

            timer = String.format("%d:%02d:%02d",hours, minutes, seconds);
            txtTimer.setText(String.format("%d:%02d:%02d",hours, minutes, seconds));

            timerHandler.postDelayed(this, 1000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feet);
        setToolbar();
        initView();
        runTime();
        realTime();



    }


    private void realTime() {
        Date today = new Date(System.currentTimeMillis());
        SimpleDateFormat timeFormat= new SimpleDateFormat("hh:mm dd/MM/yyyy");
        timenow = timeFormat.format(today.getTime());
//        txtRealtime.setText(timenow);


    }

    private void runFeet() {
        increase_feet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                value = Integer.toString(count);

                txtFeet.setText(value);
            }
        });
    }

    private void runTime() {
        btnStart.setText("Bắt Đầu");
        btnStart.setSelected(true);
        dataFeets = new ArrayList<>();
        feetAdapter = new FeetAdapter(getApplicationContext(), dataFeets);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                Log.e("TAG","CHECK BTN: "+btnStart.isSelected());
//                TextView txtStart = (TextView) view;
                if (!btnStart.isSelected()) {
                    btnStart.setSelected(true);
                    timerHandler.removeCallbacks(timerRunnable);
                    btnStart.setText("Bắt Đầu");
//                    btnStart.setBackground(getResources().getDrawable(R.drawable.radiusgreen));
                    increase_feet.setClickable(false);

                    recyclerView_feet = findViewById(R.id.recycler_feet);
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
                    recyclerView_feet.setLayoutManager(layoutManager);
                    feetAdapter.AddFeet(new DataFeet(R.drawable.ic_two,timer,timenow,String.valueOf(count)));
                    recyclerView_feet.setAdapter(feetAdapter);


                    txtFeet.setText(String.valueOf(0));
                    count = 0;
                    txtTimer.setText("00:00:00");


                } else {
                    btnStart.setSelected(false);
                    startTime = System.currentTimeMillis();
                    timerHandler.postDelayed(timerRunnable, 0);
                    btnStart.setText("Kết Thúc");
//                    btnStart.setBackground(getResources().getDrawable(R.drawable.radius_purple));
                    increase_feet.setClickable(true);
                    runFeet();

                }
            }
        });
    }

    private void initView() {
        btnStart = findViewById(R.id.btnStart);
        txtTimer = findViewById(R.id.txtTimer);
        increase_feet = findViewById(R.id.increase_feet);
        txtFeet = findViewById(R.id.txtfeet);

        txtRealtime = findViewById(R.id.txtRealtime);
    }



    private void setToolbar() {
        toolbar_feet = findViewById(R.id.toolbar_feet);

        setSupportActionBar(toolbar_feet);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar_feet.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


    @Override
    public void ClickDel(int position) {

    }
}
