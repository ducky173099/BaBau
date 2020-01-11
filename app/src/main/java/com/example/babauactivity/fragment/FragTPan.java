package com.example.babauactivity.fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.babauactivity.R;
import com.example.babauactivity.adapter.ThucphamAdapter;
import com.example.babauactivity.model.DataHoatdong;
import com.example.babauactivity.model.DataThucpham;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragTPan extends Fragment implements View.OnClickListener {
    RecyclerView recycler_listtpan;
    ArrayList<DataThucpham> dataThucphams;
    ArrayList<DataThucpham> dataSearch;
    ThucphamAdapter thucphamAdapter;

    EditText edtsearch_tpan;
    ImageView delTPan;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_tpan, container, false);

        delTPan = view.findViewById(R.id.delTPan);
        edtsearch_tpan = view.findViewById(R.id.edtsearch_tpan);
        dataSearch = new ArrayList<>();

        recycler_listtpan = view.findViewById(R.id.recycler_listtpan);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recycler_listtpan.setLayoutManager(layoutManager);

        dataThucphams = new ArrayList<>();
        for (int i = 0; i <= 20 ; i++) {
            dataThucphams.add(new DataThucpham(R.drawable.mushroom,"Bánh mì","Bánh mì cso nhiều giá trị dinh dưỡng đối với sức khỏe cảu Bà bầu. Trong..."));
        }


        thucphamAdapter = new ThucphamAdapter(getContext(), dataThucphams);
        recycler_listtpan.setAdapter(thucphamAdapter);

        edtsearch_tpan.addTextChangedListener(new TextWatcher() { // Search Lits
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

        delTPan.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        edtsearch_tpan.getText().clear();
    }
}
