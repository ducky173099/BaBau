package com.example.babauactivity.adapter;

import com.example.babauactivity.fragment.FragmentNameDaughter;
import com.example.babauactivity.fragment.FragmentNameLike;
import com.example.babauactivity.fragment.FragmentNameSon;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class TabNameAdapter extends FragmentStatePagerAdapter {
    private String listTab[] = {"Con trai", "Con gái","Yêu thích"}; // mang string luu title cua tab

    private FragmentNameSon fragmentNameSon;
    private FragmentNameDaughter fragmentNameDaughter;
    private FragmentNameLike fragmentNameLike;

    public TabNameAdapter(@NonNull FragmentManager fm) {
        super(fm);

        fragmentNameSon = new FragmentNameSon();
        fragmentNameDaughter = new FragmentNameDaughter();
        fragmentNameLike = new FragmentNameLike();

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            return fragmentNameSon;
        } else if (position == 1){
            return fragmentNameDaughter;
        } else if (position == 2){
            return fragmentNameLike;
        }
        return null;
    }

    @Override
    public int getCount() {
        return listTab.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listTab[position];
    }
}
