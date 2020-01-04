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
import com.example.babauactivity.activity.QuatationActivity;
import com.example.babauactivity.activity.ShopActivity;
import com.example.babauactivity.activity.StoryActivity;
import com.example.babauactivity.activity.ThucphamActivity;
import com.example.babauactivity.model.DataPopcorm;
import com.example.babauactivity.R;
import com.example.babauactivity.adapter.PopcormAdapter;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentPopcorm extends Fragment implements PopcormAdapter.ItemClick {
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

        popcormAdapter.setClickPopcorm(this);


        return view;
    }

    @Override
    public void ClickPopcorm(int position) {
//        Toast.makeText(getContext(), "popcorm " + position, Toast.LENGTH_SHORT).show();

        switch (position){
            case 0:
                Intent story = new Intent(getContext(), StoryActivity.class);
                startActivity(story);
                break;
            case 1:
                Intent quatation = new Intent(getContext(), QuatationActivity.class);
                startActivity(quatation);
                break;
        }
    }
}
