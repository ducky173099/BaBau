package com.example.babauactivity.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.babauactivity.R;
import com.example.babauactivity.adapter.ThaikiAdapter;
import com.example.babauactivity.model.DataChiTietThaiKi;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragThaikiSecond extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_thaiki, container, false);
        RecyclerView recyclerViewThaiki = view.findViewById(R.id.recycler_thaiki_verti);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerViewThaiki.setLayoutManager(layoutManager);

        ArrayList<DataChiTietThaiKi> dataChiTietThaiKi = new ArrayList<>();
        dataChiTietThaiKi.add(new DataChiTietThaiKi(R.drawable.sieuam1,"2D","3D","Màu","Video",
                R.drawable.ic_toddler,"Em bé","Em bé vẫn chỉ là 1 tia sáng le lói tỏng mắt. hahahahaaaaaaaaaaaaaa hihihihihihihihihihihih hheehheheheheheheheheeh roman egyp hittie catha",
                R.drawable.ic_woman,"Người mẹ","ĐÓi quá , khát quá, muốn ăn ốc quá Mirinda orion-custan Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
                R.drawable.ic_bell,"Lời khuyên","Khổ trước sướng sau thế mới giàu, tình nghĩa ae có chắc bền lâu , thời thế cho ta, nhận biết ra rằng ...It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy."));


        ThaikiAdapter thaikiAdapter = new ThaikiAdapter(getContext(), dataChiTietThaiKi);
        recyclerViewThaiki.setAdapter(thaikiAdapter);

        return view;
    }
}
