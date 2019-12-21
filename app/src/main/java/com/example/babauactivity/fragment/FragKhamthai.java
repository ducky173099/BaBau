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

public class FragKhamthai extends Fragment implements ChuanbiAdapter.ItemClick {
    RecyclerView recycler_listkhamthai;
    ArrayList<DataChuanbi> dataChuanbis;
    ArrayList<DataChuanbi> dataSearchKT;

    EditText edtSearch;

    ChuanbiAdapter chuanbiAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_khamthai, container, false);

        recycler_listkhamthai = view.findViewById(R.id.recycler_listkhamthai);
        edtSearch = view.findViewById(R.id.edtsearch_khamthai);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recycler_listkhamthai.setLayoutManager(layoutManager);

        dataChuanbis = new ArrayList<>();
        dataChuanbis.add(new DataChuanbi(R.drawable.one,"Lịch kham thai cho mẹ bầu"));
        dataChuanbis.add(new DataChuanbi(R.drawable.ic_two,"Khi nào nên đi khám thai lần đầu"));
        dataChuanbis.add(new DataChuanbi(R.drawable.three,"Siêu âm đo độ mờ da gáy"));
        dataChuanbis.add(new DataChuanbi(R.drawable.four,"Xét nghiệm sàng lọc Triple tét"));
        dataChuanbis.add(new DataChuanbi(R.drawable.five,"Siêu âm 4D"));
        dataChuanbis.add(new DataChuanbi(R.drawable.six,"Non-stress test"));
        dataChuanbis.add(new DataChuanbi(R.drawable.seven,"8 lần khám thai quan trọng mẹ bầu bắt buộc phải đi"));
        dataChuanbis.add(new DataChuanbi(R.drawable.eight,"Tác hại của siêu âm đối với thai nhi"));

        chuanbiAdapter = new ChuanbiAdapter(getContext(),dataChuanbis);
        recycler_listkhamthai.setAdapter(chuanbiAdapter);

        dataSearchKT = new ArrayList<>();

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
                dataSearchKT.clear();
                Log.e("TAG","CHECK DATA SIZE:"+dataChuanbis.size());
                for (DataChuanbi data: dataChuanbis){
                    if (data.getContent().toUpperCase().contains(text.toUpperCase())){
                        Log.e("TAG","CHECK DATA add:");
                        dataSearchKT.add(data);
                    }
                }
                Log.e("TAG","CHECK:"+dataSearchKT.size());
                chuanbiAdapter.setDataChuanbis(dataSearchKT);
            }
        });

        chuanbiAdapter.setClickChuanbi(this);

        return view;
    }

    @Override
    public void ClickChuanbi(int position) {
        Toast.makeText(getContext(), "khám thai " + position, Toast.LENGTH_SHORT).show();
    }
}
