package com.example.babauactivity.fragment;

import android.content.Intent;
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
import com.example.babauactivity.activity.InitCamnangActivity;
import com.example.babauactivity.adapter.ChuanbiAdapter;
import com.example.babauactivity.model.DataChuanbi;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragMangthai extends Fragment implements ChuanbiAdapter.ItemClick {
    RecyclerView recycler_listmangthai;
    ArrayList<DataChuanbi> dataChuanbis;
    ArrayList<DataChuanbi> dataSearchMT;

    EditText edtSearch;

    ChuanbiAdapter chuanbiAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_mangthai, container, false);

        recycler_listmangthai = view.findViewById(R.id.recycler_listmangthai);
        edtSearch = view.findViewById(R.id.edtsearch_mangthai);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recycler_listmangthai.setLayoutManager(layoutManager);

        dataChuanbis = new ArrayList<>();
        dataChuanbis.add(new DataChuanbi(R.drawable.one,"Có nên quan hệ tình dục khi mang thai"));
        dataChuanbis.add(new DataChuanbi(R.drawable.ic_two,"Nên và cấm kị yêu khi mang thai"));
        dataChuanbis.add(new DataChuanbi(R.drawable.three,"Mang thai 3 tháng đầu có được quan hệ tình dục không?"));
        dataChuanbis.add(new DataChuanbi(R.drawable.four,"'Chuyện ấy' khi mang thai đem lại nhiều lợi ích"));
        dataChuanbis.add(new DataChuanbi(R.drawable.five,"Bà bầu nên mặc như thế nào trong thai kỳ?"));
        dataChuanbis.add(new DataChuanbi(R.drawable.six,"Bà bầu nên mặc gì trong các giai đoạn thai kỳ khác nhau?"));
        dataChuanbis.add(new DataChuanbi(R.drawable.seven,"Khi mang thai nên chọn trang phục như thế nào?"));
        dataChuanbis.add(new DataChuanbi(R.drawable.eight,"Thai nhẹ cân vì mẹ bầu mặc quần áo chật"));

        chuanbiAdapter = new ChuanbiAdapter(getContext(),dataChuanbis);
        recycler_listmangthai.setAdapter(chuanbiAdapter);

        dataSearchMT = new ArrayList<>();

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
                dataSearchMT.clear();
                Log.e("TAG","CHECK DATA SIZE:"+dataChuanbis.size());
                for (DataChuanbi data: dataChuanbis){
                    if (data.getContent().toUpperCase().contains(text.toUpperCase())){
                        Log.e("TAG","CHECK DATA add:");
                        dataSearchMT.add(data);
                    }
                }
                Log.e("TAG","CHECK:"+dataSearchMT.size());
                chuanbiAdapter.setDataChuanbis(dataSearchMT);
            }
        });

        chuanbiAdapter.setClickChuanbi(this);

        return view;
    }

    @Override
    public void ClickChuanbi(int position) {
        Toast.makeText(getContext(), "mang thai " + position, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getContext(), InitCamnangActivity.class);
        startActivity(intent);
    }
}
