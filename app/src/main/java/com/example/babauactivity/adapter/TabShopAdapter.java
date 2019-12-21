package com.example.babauactivity.adapter;

import com.example.babauactivity.fragment.FragChobe;
import com.example.babauactivity.fragment.FragChome;
import com.example.babauactivity.fragment.FragDamua;
import com.example.babauactivity.fragment.FragSK;
import com.example.babauactivity.fragment.FragSuckhoe;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class TabShopAdapter extends FragmentStatePagerAdapter {
    private String listShop[] = {"Cho bé","Cho mẹ","Sức khỏe","Đã mua"};

    private FragChobe fragChobe;
    private FragChome fragChome;
    private FragSK fragSK;
    private FragDamua fragDamua;

    public TabShopAdapter(@NonNull FragmentManager fm) {
        super(fm);

        fragChobe = new FragChobe();
        fragChome = new FragChome();
        fragSK = new FragSK();
        fragDamua = new FragDamua();

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            return fragChobe;
        } else if (position == 1){
            return fragChome;
        } else if (position == 2){
            return fragSK;
        } else if (position == 3){
            return fragDamua;
        }
        return null;
    }

    @Override
    public int getCount() {
        return listShop.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listShop[position];
    }
}
