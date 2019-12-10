package com.example.babauactivity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.babauactivity.activity.ChonTenActivity;
import com.example.babauactivity.activity.FeetActivity;
import com.example.babauactivity.activity.InjectActivity;
import com.example.babauactivity.activity.KichthuocActivity;
import com.example.babauactivity.activity.ThaiKiActivity;
import com.example.babauactivity.adapter.ItemClick;
import com.example.babauactivity.model.DataChild;
import com.example.babauactivity.R;
import com.example.babauactivity.adapter.ChildAdapter;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentBaby extends Fragment implements ItemClick { // buoc 1 implement interface
    ArrayList<DataChild> dataChildArrayList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.child, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_child);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),  2);

        recyclerView.setLayoutManager(gridLayoutManager);

        dataChildArrayList = new ArrayList<>();
        dataChildArrayList.add(new DataChild(R.drawable.ic_checklist, "Thai kỳ"));
        dataChildArrayList.add(new DataChild(R.drawable.ic_babyweight, "Kích thước"));
        dataChildArrayList.add(new DataChild(R.drawable.ic_anesthesia, "Lịch tiêm phòng"));
        dataChildArrayList.add(new DataChild(R.drawable.ic_feet, "Đếm số lần đạp"));
        dataChildArrayList.add(new DataChild(R.drawable.ic_book, "Chọn tên"));
        dataChildArrayList.add(new DataChild(R.drawable.ic_stork, "Ảnh bé yêu"));
        dataChildArrayList.add(new DataChild(R.drawable.ic_mother, "Nickname dễ thương"));


        ChildAdapter childAdapter = new ChildAdapter(dataChildArrayList, getContext());
        recyclerView.setAdapter(childAdapter);

        childAdapter.setItemClick(this); // buoc 2

        return view;
    }

    @Override
    public void onClickItem(int position) { // buoc 3 interface
        Toast.makeText(getContext(), "ok ngon" + position, Toast.LENGTH_SHORT).show();

        switch (position){
            case 0:
                Intent intent = new Intent(getContext(), ThaiKiActivity.class);
                startActivity(intent);
                break;
            case 1:
                Intent kichthuoc = new Intent(getContext(), KichthuocActivity.class);
                startActivity(kichthuoc);
                break;
            case 2:
                Intent inject = new Intent(getContext(), InjectActivity.class);
                startActivity(inject);
                break;
            case 3:
                Intent feet = new Intent(getContext(), FeetActivity.class);
                startActivity(feet);
                break;
            case 4:
                Intent intent1 = new Intent(getContext(), ChonTenActivity.class);
                startActivity(intent1);
                break;
        }

    }
}
