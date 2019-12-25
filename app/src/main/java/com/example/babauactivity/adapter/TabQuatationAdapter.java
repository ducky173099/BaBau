package com.example.babauactivity.adapter;

import com.example.babauactivity.fragment.FragQuataLike;
import com.example.babauactivity.fragment.FragQuatation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class TabQuatationAdapter extends FragmentStatePagerAdapter {
    private String listQuatation[] = {"Danh ngôn","Yêu thích"};

    private FragQuatation fragQuatation;
    private FragQuataLike fragQuataLike;


    public TabQuatationAdapter(@NonNull FragmentManager fm) {
        super(fm);
        fragQuatation = new FragQuatation();
        fragQuataLike = new FragQuataLike();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            return fragQuatation;
        } else if (position == 1){
            return fragQuataLike;
        }
        return null;
    }

    @Override
    public int getCount() {
        return listQuatation.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listQuatation[position];
    }
}
