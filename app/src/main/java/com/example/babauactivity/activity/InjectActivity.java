package com.example.babauactivity.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.babauactivity.R;
import com.example.babauactivity.adapter.InjectBabyAdapter;
import com.example.babauactivity.model.DataInject;

import java.util.ArrayList;
import java.util.Objects;

public class InjectActivity extends AppCompatActivity {
    Toolbar toolbarInject;
    RecyclerView recyclerViewInject;
    ArrayList<DataInject> dataInjects;
    InjectBabyAdapter injectBabyAdapter;

    TextView tittletoolbar_camnang;
    ImageView back_tb_camnang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inject);
        setToolbar();
        setRecycler();


    }

    private void setRecycler() {
        recyclerViewInject = findViewById(R.id.recycler_inject);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
        recyclerViewInject.setLayoutManager(layoutManager);

        dataInjects = new ArrayList<>();
        dataInjects.add(new DataInject(R.drawable.ic_newborn,"Sơ sinh","-Vắc xin lao mũi 1 \n-Vắc xin viêm gan B mũi 1"));
        dataInjects.add(new DataInject(R.drawable.ic_newborn,"1 tháng tuổi","-Vắc xin viêm gan B mũi 2"));
        dataInjects.add(new DataInject(R.drawable.ic_newborn,"6 tuần tuổi","-Vắc xin phòng bệnh viêm phổi do phế cầu khuẩn mũi 1. Với lịch 3 mũi, tiêm sớm nhất vào lúc 6 tuần tuổi và nhắc lại mũi 2 sau ít nhất 1 tháng, nhắc lại mũi 3 tiêm ít nhất 6 tháng sau. Với lịch 4 mũi, tiêm sớm nhất vào lúc 6 tuần tuổi \n-Vắc xinvieem dạ dày ruột do Rotavirus liều 1 ."));
        dataInjects.add(new DataInject(R.drawable.ic_newborn,"Từ 2 tháng tuổi","-Vắc xin viêm gan B mũi 3(Tiêm nhắc lại mũi 4 sau 1 năm, mũi thứ 5 sau 8 năm). \n-Vắc xin Bạch cầu - Ho gà - Uốn ván - Bại liệt mũi 1 . \n-Vắc xin viêm màng não mủ, Viêm họng, Viêm phế quản, Viêm phổi do Haemophilus influenzea mũi 1."));
        dataInjects.add(new DataInject(R.drawable.ic_newborn,"Từ 3 tháng tuổi","-Vắc xin Bạch cầu - Ho gà - Uốn ván - Bại liệt mũi 2 \n-Vắc xin viêm màng não mủ, Viêm họng, Viêm phế quản, Viêm phổi do Haemophilus influenzea mũi 2. \n-Vắc xin viêm dạ dày ruột do Rotavirus liều 2."));
        dataInjects.add(new DataInject(R.drawable.ic_newborn,"Từ 4 tháng tuổi","-Vắc xin Bạch cầu - Ho gà - Uốn ván - Bại liệt mũi 3 \n-Vắc xin viêm màng não mủ, Viêm họng, Viêm phế quản, Viêm phổi do Haemophilus influenzea mũi 3. \n-Vắc xin viêm dạ dày ruột do Rotavirus liều 3."));
        dataInjects.add(new DataInject(R.drawable.ic_newborn,"Từ 6 tháng tuổi","-Vắc xin viêm cúm mũi 1. Mũi 2 tiêm sau mũi 1 một tháng, sau đó tiêm vào đầu vụ cúm hàng nưm là cuối tháng 9 và đầu tháng 10."));
        dataInjects.add(new DataInject(R.drawable.ic_newborn,"Từ 9 tháng tuổi","-Vắc xin viêm cúm mũi 1. Mũi 2 tiêm sau mũi 1 một tháng, sau đó tiêm vào đầu vụ cúm hàng nưm là cuối tháng 9 và đầu tháng 10."));
        dataInjects.add(new DataInject(R.drawable.ic_newborn,"Từ 12 tháng tuổi","-Vắc xin viêm cúm mũi 1. Mũi 2 tiêm sau mũi 1 một tháng, sau đó tiêm vào đầu vụ cúm hàng nưm là cuối tháng 9 và đầu tháng 10. \nTừ 12 tháng tuổi\",\"-Vắc xin viêm cúm mũi 1. Mũi 2 tiêm sau mũi 1 một tháng, sau đó tiêm vào đầu vụ cúm hàng nưm là cuối tháng 9 và đầu tháng 10."));
        dataInjects.add(new DataInject(R.drawable.ic_newborn,"Từ 24 tháng tuổi","-Vắc xin viêm cúm mũi 1. Mũi 2 tiêm sau mũi 1 một tháng, sau đó tiêm vào đầu vụ cúm hàng nưm là cuối tháng 9 và đầu tháng 10."));
        dataInjects.add(new DataInject(R.drawable.ic_newborn,"Từ 36 tháng và người lớn","-Vắc xin viêm cúm mũi 1. Mũi 2 tiêm sau mũi 1 một tháng, sau đó tiêm vào đầu vụ cúm hàng nưm là cuối tháng 9 và đầu tháng 10."));


        injectBabyAdapter = new InjectBabyAdapter(this, dataInjects);
        recyclerViewInject.setAdapter(injectBabyAdapter);
    }

    private void setToolbar() {
//        toolbarInject = findViewById(R.id.toolbar_inject);
//
//        setSupportActionBar(toolbarInject);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//        toolbarInject.setNavigationOnClickListener(new View.OnClickListener() {
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
        tittletoolbar_camnang.setText("Tiêm chủng");
        back_tb_camnang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }
}
