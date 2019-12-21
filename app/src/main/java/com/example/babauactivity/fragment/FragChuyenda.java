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

public class FragChuyenda extends Fragment implements ChuanbiAdapter.ItemClick {

    RecyclerView recycler_listchuyenda;
    ArrayList<DataChuanbi> dataChuanbis;
    ArrayList<DataChuanbi> dataSearchCD;

    EditText edtSearch;

    ChuanbiAdapter chuanbiAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_chuyenda, container, false);

        recycler_listchuyenda = view.findViewById(R.id.recycler_listchuyenda);
        edtSearch = view.findViewById(R.id.edtsearch_chuyenda);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recycler_listchuyenda.setLayoutManager(layoutManager);

        dataChuanbis = new ArrayList<>();
        dataChuanbis.add(new DataChuanbi(R.drawable.one,"Những dấu hiệu chuyển dạ khi sắp sinh con so của bà bầu"));
        dataChuanbis.add(new DataChuanbi(R.drawable.ic_two,"10 dấu hiệu sắp sinh - dấu hiệu chuyển dạ"));
        dataChuanbis.add(new DataChuanbi(R.drawable.three,"Dấu hiệu sắp sinh trước 1 tuần"));
        dataChuanbis.add(new DataChuanbi(R.drawable.four,"'Quá trình chuyển dạ"));
        dataChuanbis.add(new DataChuanbi(R.drawable.five,"Bà bầu nên làm gì khi chuyển dạ?"));
        dataChuanbis.add(new DataChuanbi(R.drawable.six,"Bí quyết giảm đau khi sinh thường"));
        dataChuanbis.add(new DataChuanbi(R.drawable.seven,"Tập hít thở để giảm đau khi Sinh"));
        dataChuanbis.add(new DataChuanbi(R.drawable.eight,"Hướng dẫn về cách thở cũng như răn đẻ"));

        chuanbiAdapter = new ChuanbiAdapter(getContext(),dataChuanbis);
        recycler_listchuyenda.setAdapter(chuanbiAdapter);

        dataSearchCD = new ArrayList<>();

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
                dataSearchCD.clear();
                Log.e("TAG","CHECK DATA SIZE:"+dataChuanbis.size());
                for (DataChuanbi data: dataChuanbis){
                    if (data.getContent().toUpperCase().contains(text.toUpperCase())){
                        Log.e("TAG","CHECK DATA add:");
                        dataSearchCD.add(data);
                    }
                }
                Log.e("TAG","CHECK:"+dataSearchCD.size());
                chuanbiAdapter.setDataChuanbis(dataSearchCD);
            }
        });

        chuanbiAdapter.setClickChuanbi(this);

        return view;
    }

    @Override
    public void ClickChuanbi(int position) {
        Toast.makeText(getContext(), "Chuyển dạ " + position, Toast.LENGTH_SHORT).show();
    }
}
