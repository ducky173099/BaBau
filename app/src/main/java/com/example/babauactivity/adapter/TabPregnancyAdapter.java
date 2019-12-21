package com.example.babauactivity.adapter;

import com.example.babauactivity.fragment.FragMonan;
import com.example.babauactivity.fragment.FragMonanLike;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class TabPregnancyAdapter extends FragmentStatePagerAdapter {
    private String listpregnancy[] = {"Món ăn","Yêu thích"};

    private FragMonan fragMonan;
    private FragMonanLike fragMonanLike;

    public TabPregnancyAdapter(@NonNull FragmentManager fm) {
        super(fm);

        fragMonan = new FragMonan();
        fragMonanLike = new FragMonanLike();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            return fragMonan;
        } else if (position == 1){
            return fragMonanLike;
        }

        return null;
    }

    @Override
    public int getCount() {
        return listpregnancy.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listpregnancy[position];
    }
}
