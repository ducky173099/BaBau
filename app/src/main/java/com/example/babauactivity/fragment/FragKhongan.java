package com.example.babauactivity.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.babauactivity.R;
import com.example.babauactivity.adapter.HoatdongAdapter;
import com.example.babauactivity.model.DataHoatdong;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragKhongan extends Fragment {
    RecyclerView recycler_listkhongan;
    ArrayList<DataHoatdong> dataHoatdongs;
    HoatdongAdapter hoatdongAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_khongan, container, false);

        recycler_listkhongan = view.findViewById(R.id.recycler_listkhongan);
        dataHoatdongs = new ArrayList<>();

        dataHoatdongs.add(new DataHoatdong(R.drawable.gravestone,"Đi dự đám ma","Không nên","Bà bầu nên tránh"));
        dataHoatdongs.add(new DataHoatdong(R.drawable.high_heel,"Đi giày cao gót","Không nên","Mẹ không nên mang giày cao gót khi mang thai nhé"));
        dataHoatdongs.add(new DataHoatdong(R.drawable.no_smoking,"Hút thuốc lá","Không nên","Bà bầu hít thuốc lá dễ dẫn đến sinh non, thai chết lưu"));
        dataHoatdongs.add(new DataHoatdong(R.drawable.handrail,"Lên xuống cầu thang","Không nên","Bà bầu nên tránh"));
        dataHoatdongs.add(new DataHoatdong(R.drawable.diving,"Leo núi, lặn","Không nên","bà bầu nên tránh"));
        dataHoatdongs.add(new DataHoatdong(R.drawable.gravestone,"Đi dự đám ma","Không nên","Bà bầu nên tránh"));
        dataHoatdongs.add(new DataHoatdong(R.drawable.high_heel,"Đi giày cao gót","Không nên","Mẹ không nên mang giày cao gót khi mang thai nhé"));
        dataHoatdongs.add(new DataHoatdong(R.drawable.no_smoking,"Hút thuốc lá","Không nên","Bà bầu hít thuốc lá dễ dẫn đến sinh non, thai chết lưu"));
        dataHoatdongs.add(new DataHoatdong(R.drawable.handrail,"Lên xuống cầu thang","Không nên","Bà bầu nên tránh"));
        dataHoatdongs.add(new DataHoatdong(R.drawable.diving,"Leo núi, lặn","Không nên","bà bầu nên tránh"));

        hoatdongAdapter = new HoatdongAdapter(getContext(), dataHoatdongs);
        recycler_listkhongan.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));

        recycler_listkhongan.setAdapter(hoatdongAdapter);


        return view;
    }
}
