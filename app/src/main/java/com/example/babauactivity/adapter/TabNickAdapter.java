package com.example.babauactivity.adapter;

import com.example.babauactivity.fragment.FragNickDauter;
import com.example.babauactivity.fragment.FragNickLike;
import com.example.babauactivity.fragment.FragNickSon;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class TabNickAdapter extends FragmentStatePagerAdapter {
    private String listNick[] = {"Con trai", "Con gái","Yêu thích"}; // mang string luu title cua tab

    private FragNickSon fragNickSon;
    private FragNickDauter fragNickDauter;
    private FragNickLike fragNickLike;

    public TabNickAdapter(@NonNull FragmentManager fm) {
        super(fm);

        fragNickSon = new FragNickSon();
        fragNickDauter = new FragNickDauter();
        fragNickLike = new FragNickLike();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            return fragNickSon;
        } else if (position == 1){
            return fragNickDauter;
        } else if (position == 2){
            return fragNickLike;
        }

        return null;
    }

    @Override
    public int getCount() {
        return listNick.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listNick[position];
    }
}
