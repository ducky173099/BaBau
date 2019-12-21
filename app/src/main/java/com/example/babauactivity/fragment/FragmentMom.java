package com.example.babauactivity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.babauactivity.activity.CamnangActivity;
import com.example.babauactivity.activity.CannangActivity;
import com.example.babauactivity.activity.CookingActivity;
import com.example.babauactivity.activity.HoatDongActivity;
import com.example.babauactivity.activity.ShopActivity;
import com.example.babauactivity.activity.ThucphamActivity;
import com.example.babauactivity.adapter.ItemClick;
import com.example.babauactivity.model.DataMom;
import com.example.babauactivity.R;
import com.example.babauactivity.adapter.MomAdapter;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentMom extends Fragment implements ItemClick, MomAdapter.ItemClick {
    ArrayList<DataMom> dataMom;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mom, container, false);

        RecyclerView recyclerViewMom = view.findViewById(R.id.recycler_mom);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);

        recyclerViewMom.setLayoutManager(gridLayoutManager);

        dataMom = new ArrayList<>();
        dataMom.add(new DataMom(R.drawable.ic_book, "Cẩm nang"));
        dataMom.add(new DataMom(R.drawable.ic_book, "Mua sắm"));
        dataMom.add(new DataMom(R.drawable.ic_book, "Hoạt động"));
        dataMom.add(new DataMom(R.drawable.ic_book, "Cân nặng"));
        dataMom.add(new DataMom(R.drawable.ic_book, "Thực phẩm"));
        dataMom.add(new DataMom(R.drawable.ic_book, "Nấu ăn"));

        MomAdapter momAdapter = new MomAdapter(getContext(), dataMom);
        recyclerViewMom.setAdapter(momAdapter);

        momAdapter.setClickMom(this);

        return view;
    }

    @Override
    public void onClickItem(int position) {
        Toast.makeText(getContext(), "mom " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void ClickMom(int position) {
        Toast.makeText(getContext(), "mom " + position, Toast.LENGTH_SHORT).show();

        switch (position){
            case 0:
                Intent camnang = new Intent(getContext(), CamnangActivity.class);
                startActivity(camnang);
                break;
            case 1:
                Intent shop = new Intent(getContext(), ShopActivity.class);
                startActivity(shop);
                break;
            case 2:
                Intent hoatdong = new Intent(getContext(), HoatDongActivity.class);
                startActivity(hoatdong);
                break;
            case 3:
                Intent cannang = new Intent(getContext(), CannangActivity.class);
                startActivity(cannang);
                break;
            case 4:
                Intent thucpham = new Intent(getContext(), ThucphamActivity.class);
                startActivity(thucpham);
                break;
            case 5:
                Intent cooking = new Intent(getContext(), CookingActivity.class);
                startActivity(cooking);
                break;
        }
    }
}
