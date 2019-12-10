package com.example.babauactivity.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.babauactivity.model.DataPopcorm;
import com.example.babauactivity.R;
import com.example.babauactivity.adapter.PopcormAdapter;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentPopcorm extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pop_corm, container, false);

        RecyclerView recyclerViewPopcorm = view.findViewById(R.id.recycler_popcorm);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerViewPopcorm.setLayoutManager(gridLayoutManager);

        ArrayList<DataPopcorm> dataPopcorm = new ArrayList<>();
        dataPopcorm.add(new DataPopcorm(R.drawable.ic_babyweight, "Kể truyện cho bé"));
        dataPopcorm.add(new DataPopcorm(R.drawable.ic_babyweight, "Danh ngôn mẹ"));
        dataPopcorm.add(new DataPopcorm(R.drawable.ic_babyweight, "Fanpage bà bâu"));
        dataPopcorm.add(new DataPopcorm(R.drawable.ic_babyweight, "Cộng đồng bà bâu"));
        dataPopcorm.add(new DataPopcorm(R.drawable.ic_babyweight, "Đánh giá ứng dụng"));
        dataPopcorm.add(new DataPopcorm(R.drawable.ic_babyweight, "Chia sẻ ứng dụng"));
        dataPopcorm.add(new DataPopcorm(R.drawable.ic_babyweight, "Ứng dụng khác"));

        PopcormAdapter popcormAdapter = new PopcormAdapter(dataPopcorm, getContext());
        recyclerViewPopcorm.setAdapter(popcormAdapter);


        return view;
    }
}
