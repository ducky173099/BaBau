package com.example.babauactivity.adapter;

import com.example.babauactivity.fragment.FragChobe;
import com.example.babauactivity.fragment.FragChome;
import com.example.babauactivity.fragment.FragDamua;
import com.example.babauactivity.fragment.FragHistory;
import com.example.babauactivity.fragment.FragSK;
import com.example.babauactivity.fragment.FragStory;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class TabStoryAdapter extends FragmentStatePagerAdapter {
    private String listStory[] = {"Truyện","Lịch sử đọc"};

    private FragStory fragStory;
    private FragHistory fragHistory;

    public TabStoryAdapter(@NonNull FragmentManager fm) {
        super(fm);

        fragStory = new FragStory();
        fragHistory = new FragHistory();


    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            return fragStory;
        } else if (position == 1){
            return fragHistory;
        }
        return null;
    }

    @Override
    public int getCount() {
        return listStory.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listStory[position];
    }
}
