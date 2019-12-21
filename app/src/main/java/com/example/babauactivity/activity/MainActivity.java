package com.example.babauactivity.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.babauactivity.R;
import com.example.babauactivity.database.Database;
import com.example.babauactivity.fragment.FragmentBaby;
import com.example.babauactivity.fragment.FragmentHome;
import com.example.babauactivity.fragment.FragmentMom;
import com.example.babauactivity.fragment.FragmentPopcorm;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText edtdate;
    BottomNavigationView botnav;
    Fragment selectFragment = null;

    public  static Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_second);
        Anhxa();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new FragmentHome()).commit();






//        edtdate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                chonngay();
//            }
//        });
    }


    private void Anhxa() {
        edtdate = findViewById(R.id.edtdate);

        botnav = findViewById(R.id.bottomnav);
        botnav.setOnNavigationItemSelectedListener(navListener);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


            switch (menuItem.getItemId()){
                case R.id.home:
                    selectFragment = new FragmentHome();
                    break;
                case R.id.child:
                    selectFragment = new FragmentBaby();
                    break;
                case R.id.mom:
                    selectFragment = new FragmentMom();
                    break;
                case R.id.popcorm:
                    selectFragment = new FragmentPopcorm();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    selectFragment).commit();


            return true;
        }
    };


    private void chonngay(){
        final Calendar calendar = Calendar.getInstance();
        int ngay = calendar.get(Calendar.DATE);
        int thang = calendar.get(Calendar.MONTH);
        int nam = calendar.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                calendar.set(i,i1,i2);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                edtdate.setText(simpleDateFormat.format(calendar.getTime()));
            }
        }, nam, thang, ngay);
        datePickerDialog.show();
    }
}
