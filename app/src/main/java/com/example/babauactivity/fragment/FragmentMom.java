package com.example.babauactivity.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.babauactivity.model.DataMom;
import com.example.babauactivity.R;
import com.example.babauactivity.adapter.MomAdapter;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentMom extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mom, container, false);

        RecyclerView recyclerViewMom = view.findViewById(R.id.recycler_mom);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);

        recyclerViewMom.setLayoutManager(gridLayoutManager);

        ArrayList<DataMom> dataMom = new ArrayList<>();
        dataMom.add(new DataMom(R.drawable.ic_book, "Cẩm nang"));
        dataMom.add(new DataMom(R.drawable.ic_book, "Mua sắm"));
        dataMom.add(new DataMom(R.drawable.ic_book, "Hoạt động"));
        dataMom.add(new DataMom(R.drawable.ic_book, "Cân nặng"));
        dataMom.add(new DataMom(R.drawable.ic_book, "Thực phẩm"));
        dataMom.add(new DataMom(R.drawable.ic_book, "Nấu ăn"));

        MomAdapter momAdapter = new MomAdapter(getContext(), dataMom);
        recyclerViewMom.setAdapter(momAdapter);

        return view;
    }
}
