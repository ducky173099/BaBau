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
import com.example.babauactivity.activity.ItemPictureActivity;
import com.example.babauactivity.adapter.ChuanbiAdapter;
import com.example.babauactivity.model.DataChuanbi;
import com.example.babauactivity.model.DataNameSon;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragChuanbi extends Fragment implements ChuanbiAdapter.ItemClick { // buco 6 interface alt + emter
    RecyclerView recycler_listchuanbi;
    ArrayList<DataChuanbi> dataChuanbis;
    ArrayList<DataChuanbi> dataSearch;

    EditText edtSearchCB;

    ChuanbiAdapter chuanbiAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_chuanbi, container, false);

        recycler_listchuanbi = view.findViewById(R.id.recycler_listchuanbi);
        edtSearchCB = view.findViewById(R.id.edtsearch_chuanbi);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recycler_listchuanbi.setLayoutManager(layoutManager);

        dataChuanbis = new ArrayList<>();
        dataChuanbis.add(new DataChuanbi(R.drawable.one,"Kế hoạch Sinh?"));
        dataChuanbis.add(new DataChuanbi(R.drawable.ic_two,"Mang thai lần đầu tiên - những chuẩn bị cần thiết"));
        dataChuanbis.add(new DataChuanbi(R.drawable.three,"Kế hoạch mang thai khi đang sử dụng các biện pháp tránh..."));
        dataChuanbis.add(new DataChuanbi(R.drawable.four,"Gần gũi để tăng khả năng thụ thai: thực hư ra sao?"));
        dataChuanbis.add(new DataChuanbi(R.drawable.five,"Những nguyên nhân gây khó thụ thai"));
        dataChuanbis.add(new DataChuanbi(R.drawable.six,"10 cách giúp chàng tăng khả năng thụ thai"));
        dataChuanbis.add(new DataChuanbi(R.drawable.seven,"Yêu đúng lúc để tăng khả năng thụ thai"));
        dataChuanbis.add(new DataChuanbi(R.drawable.eight,"Quá trình thụ thai: 1 chọi 250 triệu"));
        dataChuanbis.add(new DataChuanbi(R.drawable.one,"Muốn có thai, đổi ngay những thói quen sau!"));

        chuanbiAdapter = new ChuanbiAdapter(getContext(),dataChuanbis);
        recycler_listchuanbi.setAdapter(chuanbiAdapter);

        dataSearch = new ArrayList<>();

        edtSearchCB.addTextChangedListener(new TextWatcher() {
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
                dataSearch.clear();
                Log.e("TAG","CHECK DATA SIZE:"+dataChuanbis.size());
                for (DataChuanbi data: dataChuanbis){
                    if (data.getContent().toUpperCase().contains(text.toUpperCase())){
                        Log.e("TAG","CHECK DATA add:");
                        dataSearch.add(data);
                    }
                }
                Log.e("TAG","CHECK:"+dataSearch.size());
                chuanbiAdapter.setDataChuanbis(dataSearch);
            }
        });


        chuanbiAdapter.setClickChuanbi(this);

        return view;
    }

    @Override
    public void ClickChuanbi(int position) { // buco 7 interface
        Toast.makeText(getContext(), "số tt cẩm nang " + position, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getContext(), InitCamnangActivity.class);
        startActivity(intent);
    }
}
