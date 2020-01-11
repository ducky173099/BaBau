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
import android.widget.ImageView;
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

public class FragDauhieu extends Fragment implements ChuanbiAdapter.ItemClick, View.OnClickListener {
    RecyclerView recycler_listdauhieu;
    ArrayList<DataChuanbi> dataChuanbis;
    ArrayList<DataChuanbi> dataSearchDH;

    EditText edtSearch;

    ChuanbiAdapter chuanbiAdapter;

    ImageView deldauhieu;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_dauhieu, container, false);

        deldauhieu = view.findViewById(R.id.deldauhieu);
        recycler_listdauhieu = view.findViewById(R.id.recycler_listdauhieu);
        edtSearch = view.findViewById(R.id.edtsearch_dauhieu);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recycler_listdauhieu.setLayoutManager(layoutManager);

        dataChuanbis = new ArrayList<>();
        dataChuanbis.add(new DataChuanbi(R.drawable.one,"Que thử thai hiện 2 vạch"));
        dataChuanbis.add(new DataChuanbi(R.drawable.ic_two,"Ra máu và thay đổi dịch âm đạo"));
        dataChuanbis.add(new DataChuanbi(R.drawable.three,"Chuột rút"));
        dataChuanbis.add(new DataChuanbi(R.drawable.four,"Nhiệt độ cơ thể tăng"));
        dataChuanbis.add(new DataChuanbi(R.drawable.five,"Ngực mềm, đau và lớn hơn"));
        dataChuanbis.add(new DataChuanbi(R.drawable.six,"Xuất hiện rôm, sảy"));
        dataChuanbis.add(new DataChuanbi(R.drawable.seven,"Mệt mỏi"));
        dataChuanbis.add(new DataChuanbi(R.drawable.eight,"Đau đầu"));
        dataChuanbis.add(new DataChuanbi(R.drawable.one,"Đau lưng"));

        chuanbiAdapter = new ChuanbiAdapter(getContext(),dataChuanbis);
        recycler_listdauhieu.setAdapter(chuanbiAdapter);

        dataSearchDH = new ArrayList<>();

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
                dataSearchDH.clear();
                Log.e("TAG","CHECK DATA SIZE:"+dataChuanbis.size());
                for (DataChuanbi data: dataChuanbis){
                    if (data.getContent().toUpperCase().contains(text.toUpperCase())){
                        Log.e("TAG","CHECK DATA add:");
                        dataSearchDH.add(data);
                    }
                }
                Log.e("TAG","CHECK:"+dataSearchDH.size());
                chuanbiAdapter.setDataChuanbis(dataSearchDH);
            }
        });

        chuanbiAdapter.setClickChuanbi(this);

        deldauhieu.setOnClickListener(this);
        return view;
    }

    @Override
    public void ClickChuanbi(int position) {
        Intent intent = new Intent(getContext(), InitCamnangActivity.class);
        intent.putExtra("key_camnang",dataChuanbis.get(position).getContent());
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        edtSearch.getText().clear();
    }
}
