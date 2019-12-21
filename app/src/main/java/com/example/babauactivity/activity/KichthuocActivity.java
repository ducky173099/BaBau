package com.example.babauactivity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.babauactivity.R;
import com.example.babauactivity.adapter.SizeBabyAdapter;
import com.example.babauactivity.model.DataSizebaby;

import java.util.ArrayList;

public class KichthuocActivity extends AppCompatActivity {
    Toolbar toolbarKichthuoc;
    RecyclerView recyclerViewSizeBaby;
    ArrayList<DataSizebaby> dataSizebaby;
    SizeBabyAdapter sizeBabyAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kichthuoc);
        setToolbar();
        setRecycler();

    }

    private void setRecycler() {
        recyclerViewSizeBaby = findViewById(R.id.recycler_kichthuoc);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
        recyclerViewSizeBaby.setLayoutManager(layoutManager);

        dataSizebaby = new ArrayList<>();
        for (int i = 0; i <= 20; i ++){
            dataSizebaby.add(new DataSizebaby(R.drawable.ic_sesame,"Tuần 5","Hạt mè","2 mm - 0.1 g (Đo từ đầu đến mông)"));
        }
//        dataSizebaby.add(new DataSizebaby(R.drawable.ic_sesame,"Tuần 5","Hạt mè","2 mm - 0.1 g (Đo từ đầu đến mông)"));
//        dataSizebaby.add(new DataSizebaby(R.drawable.ic_rice,"Tuần 6","Hạt gạo","6 mm - 0.2 g (Đo từ đầu đến mông)"));
//        dataSizebaby.add(new DataSizebaby(R.drawable.ic_blueberries,"Tuần 7","Quả việt quất","1.3 cm - 0.5 g (Đo từ đầu đến mông)"));
//        dataSizebaby.add(new DataSizebaby(R.drawable.ic_raspberry,"Tuần 8","Quả dâu rừng","1.6 cm - 1 g (Đo từ đầu đến mông)"));
//        dataSizebaby.add(new DataSizebaby(R.drawable.ic_grapes,"Tuần 9","Quả nho","2.3 mm - 2 g (Đo từ đầu đến mông)"));
//        dataSizebaby.add(new DataSizebaby(R.drawable.ic_beach,"Tuần 10","Quả chà là","3.1 cm - 4 g (Đo từ đầu đến mông)"));
//        dataSizebaby.add(new DataSizebaby(R.drawable.ic_sesame,"Tuần 5","Hạt mè","2 mm - 0.1 g (Đo từ đầu đến mông)"));
//        dataSizebaby.add(new DataSizebaby(R.drawable.ic_rice,"Tuần 6","Hạt gạo","6 mm - 0.2 g (Đo từ đầu đến mông)"));
//        dataSizebaby.add(new DataSizebaby(R.drawable.ic_blueberries,"Tuần 7","Quả việt quất","1.3 cm - 0.5 g (Đo từ đầu đến mông)"));
//        dataSizebaby.add(new DataSizebaby(R.drawable.ic_raspberry,"Tuần 8","Quả dâu rừng","1.6 cm - 1 g (Đo từ đầu đến mông)"));
//        dataSizebaby.add(new DataSizebaby(R.drawable.ic_grapes,"Tuần 9","Quả nho","2.3 mm - 2 g (Đo từ đầu đến mông)"));
//        dataSizebaby.add(new DataSizebaby(R.drawable.ic_beach,"Tuần 10","Quả chà là","3.1 cm - 4 g (Đo từ đầu đến mông)"));
//        dataSizebaby.add(new DataSizebaby(R.drawable.ic_sesame,"Tuần 5","Hạt mè","2 mm - 0.1 g (Đo từ đầu đến mông)"));
//        dataSizebaby.add(new DataSizebaby(R.drawable.ic_rice,"Tuần 6","Hạt gạo","6 mm - 0.2 g (Đo từ đầu đến mông)"));
//        dataSizebaby.add(new DataSizebaby(R.drawable.ic_blueberries,"Tuần 7","Quả việt quất","1.3 cm - 0.5 g (Đo từ đầu đến mông)"));
//        dataSizebaby.add(new DataSizebaby(R.drawable.ic_raspberry,"Tuần 8","Quả dâu rừng","1.6 cm - 1 g (Đo từ đầu đến mông)"));
//        dataSizebaby.add(new DataSizebaby(R.drawable.ic_grapes,"Tuần 9","Quả nho","2.3 mm - 2 g (Đo từ đầu đến mông)"));
//        dataSizebaby.add(new DataSizebaby(R.drawable.ic_beach,"Tuần 10","Quả chà là","3.1 cm - 4 g (Đo từ đầu đến mông)"));
//        dataSizebaby.add(new DataSizebaby(R.drawable.ic_sesame,"Tuần 5","Hạt mè","2 mm - 0.1 g (Đo từ đầu đến mông)"));
//        dataSizebaby.add(new DataSizebaby(R.drawable.ic_rice,"Tuần 6","Hạt gạo","6 mm - 0.2 g (Đo từ đầu đến mông)"));
//        dataSizebaby.add(new DataSizebaby(R.drawable.ic_blueberries,"Tuần 7","Quả việt quất","1.3 cm - 0.5 g (Đo từ đầu đến mông)"));
//        dataSizebaby.add(new DataSizebaby(R.drawable.ic_raspberry,"Tuần 8","Quả dâu rừng","1.6 cm - 1 g (Đo từ đầu đến mông)"));
//        dataSizebaby.add(new DataSizebaby(R.drawable.ic_grapes,"Tuần 9","Quả nho","2.3 mm - 2 g (Đo từ đầu đến mông)"));
//        dataSizebaby.add(new DataSizebaby(R.drawable.ic_beach,"Tuần 10","Quả chà là","3.1 cm - 4 g (Đo từ đầu đến mông)"));
//        dataSizebaby.add(new DataSizebaby(R.drawable.ic_sesame,"Tuần 5","Hạt mè","2 mm - 0.1 g (Đo từ đầu đến mông)"));


        sizeBabyAdapter = new SizeBabyAdapter(this, dataSizebaby);
        recyclerViewSizeBaby.setAdapter(sizeBabyAdapter);


    }

    private void setToolbar() {
        toolbarKichthuoc = findViewById(R.id.toolbar_kichthuoc);
        setSupportActionBar(toolbarKichthuoc);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarKichthuoc.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }


}
