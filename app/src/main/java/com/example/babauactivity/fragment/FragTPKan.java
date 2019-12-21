package com.example.babauactivity.fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.babauactivity.R;
import com.example.babauactivity.adapter.ThucphamAdapter;
import com.example.babauactivity.model.DataThucpham;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragTPKan extends Fragment {
    RecyclerView recycler_listtpkan;
    ArrayList<DataThucpham> dataThucphams;
    ArrayList<DataThucpham> dataSearch;
    ThucphamAdapter thucphamAdapter;

    EditText edtsearch_tpkan;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_tpkan, container, false);

        edtsearch_tpkan = view.findViewById(R.id.edtsearch_tpkan);
        dataSearch = new ArrayList<>();

        recycler_listtpkan = view.findViewById(R.id.recycler_listtpkan);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recycler_listtpkan.setLayoutManager(layoutManager);

        dataThucphams = new ArrayList<>();
        for (int i = 0; i <= 20 ; i++) {
            dataThucphams.add(new DataThucpham(R.drawable.mushroom,"Bánh mì","Bánh mì cso nhiều giá trị dinh dưỡng đối với sức khỏe cảu Bà bầu. Trong..."));
        }
//        dataThucphams.add(new DataThucpham(R.drawable.bmi,"Bánh mì","Bánh mì cso nhiều giá trị dinh dưỡng đối với sức khỏe cảu Bà bầu. Trong..."));
//        dataThucphams.add(new DataThucpham(R.drawable.bqui,"Bánh qui giòn","Ăn bánh qui giòn hoặc những thực phẩm khô: Cahs mày có thể cứu vãn..."));
//        dataThucphams.add(new DataThucpham(R.drawable.bsua,"Bánh sữa","nên ăn nó vì nó giúp giảm chứng ợ nóng của mẹ"));
//        dataThucphams.add(new DataThucpham(R.drawable.bo,"Bơ","Bơ là loại trái cây cực giàu chất dinh dưỡng"));dataThucphams.add(new DataThucpham(R.drawable.bmi,"Bánh mì","Bánh mì cso nhiều giá trị dinh dưỡng đối với sức khỏe cảu Bà bầu. Trong..."));
//        dataThucphams.add(new DataThucpham(R.drawable.bqui,"Bánh qui giòn","Ăn bánh qui giòn hoặc những thực phẩm khô: Cahs mày có thể cứu vãn..."));
//        dataThucphams.add(new DataThucpham(R.drawable.bsua,"Bánh sữa","nên ăn nó vì nó giúp giảm chứng ợ nóng của mẹ"));
//        dataThucphams.add(new DataThucpham(R.drawable.bo,"Bơ","Bơ là loại trái cây cực giàu chất dinh dưỡng"));dataThucphams.add(new DataThucpham(R.drawable.bmi,"Bánh mì","Bánh mì cso nhiều giá trị dinh dưỡng đối với sức khỏe cảu Bà bầu. Trong..."));
//        dataThucphams.add(new DataThucpham(R.drawable.bqui,"Bánh qui giòn","Ăn bánh qui giòn hoặc những thực phẩm khô: Cahs mày có thể cứu vãn..."));
//        dataThucphams.add(new DataThucpham(R.drawable.bsua,"Bánh sữa","nên ăn nó vì nó giúp giảm chứng ợ nóng của mẹ"));
//        dataThucphams.add(new DataThucpham(R.drawable.bo,"Bơ","Bơ là loại trái cây cực giàu chất dinh dưỡng"));
//        dataThucphams.add(new DataThucpham(R.drawable.suplo,"Bông cải xanh","Bông cải xanh (súp lơ) là thực phẩm có lợi cho Bà bầu..."));

        thucphamAdapter = new ThucphamAdapter(getContext(), dataThucphams);
        recycler_listtpkan.setAdapter(thucphamAdapter);

        edtsearch_tpkan.addTextChangedListener(new TextWatcher() { // Search Lits
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.e("search", "onTextChanged: " );
                fillterSearch(charSequence.toString());

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
            private void fillterSearch(String text){
                dataSearch.clear();
                Log.e("TAG","CHECK DATA SIZE:"+dataThucphams.size());
                for (DataThucpham data: dataThucphams){
                    if (data.getDesc().toUpperCase().contains(text.toUpperCase())){
                        Log.e("TAG","CHECK DATA add:");
                        dataSearch.add(data);
                    }
                }
                Log.e("TAG","CHECK:"+dataSearch.size());
                thucphamAdapter.setDataThucphams(dataSearch);
            }
        });

        return view;
    }
}
