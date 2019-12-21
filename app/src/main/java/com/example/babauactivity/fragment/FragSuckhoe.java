package com.example.babauactivity.fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.babauactivity.R;
import com.example.babauactivity.adapter.ChuanbiAdapter;
import com.example.babauactivity.model.DataChuanbi;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragSuckhoe extends Fragment implements ChuanbiAdapter.ItemClick {
    RecyclerView recycler_listsuckhoe;
    ArrayList<DataChuanbi> dataChuanbis;
    ArrayList<DataChuanbi> dataSearchSK;

    EditText edtSearch;

    ChuanbiAdapter chuanbiAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_suckhoe, container, false);

        recycler_listsuckhoe = view.findViewById(R.id.recycler_listsuckhoe);
        edtSearch = view.findViewById(R.id.edtsearch_suckhoe);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recycler_listsuckhoe.setLayoutManager(layoutManager);

        dataChuanbis = new ArrayList<>();
        dataChuanbis.add(new DataChuanbi(R.drawable.one,"Tiêm phòng"));
        dataChuanbis.add(new DataChuanbi(R.drawable.ic_two,"6 dưỡng chất quan trọng phải bổ sung trước khi mang thai"));
        dataChuanbis.add(new DataChuanbi(R.drawable.three,"Bổ sung đa vi chất bao lâu trước khi mang thai?"));
        dataChuanbis.add(new DataChuanbi(R.drawable.four,"Bổ sung vitamin khi mang thai bao nhiêu là đủ"));
        dataChuanbis.add(new DataChuanbi(R.drawable.five,"Cần bổ sung thuốc bổ gì trước khi mang thai?"));
        dataChuanbis.add(new DataChuanbi(R.drawable.six,"Những điều chuẩn bị trước khi bầu bí"));
        dataChuanbis.add(new DataChuanbi(R.drawable.seven,"19 diều cần biết trước khi mang thai"));
        dataChuanbis.add(new DataChuanbi(R.drawable.eight,"Ăn gì để cso nhiều tinh trùng?"));
        dataChuanbis.add(new DataChuanbi(R.drawable.one,"Viêm lộ tuyến cổ tử cung có nguy hiểm không?"));

        chuanbiAdapter = new ChuanbiAdapter(getContext(),dataChuanbis);
        recycler_listsuckhoe.setAdapter(chuanbiAdapter);

        dataSearchSK = new ArrayList<>();

        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                fillterSearch(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }

            private void fillterSearch(String text){
                dataSearchSK.clear();
                Log.e("TAG","CHECK DATA SIZE:"+dataChuanbis.size());
                for (DataChuanbi data: dataChuanbis){
                    if (data.getContent().toUpperCase().contains(text.toUpperCase())){
                        Log.e("TAG","CHECK DATA add:");
                        dataSearchSK.add(data);
                    }
                }
                Log.e("TAG","CHECK:"+dataSearchSK.size());
                chuanbiAdapter.setDataChuanbis(dataSearchSK);
            }
        });

        chuanbiAdapter.setClickChuanbi(this);

        return view;
    }

    @Override
    public void ClickChuanbi(int position) {
        Toast.makeText(getContext(), "sức khỏe " + position, Toast.LENGTH_SHORT).show();
    }
}
