package com.example.babauactivity.adapter;

import com.example.babauactivity.fragment.FragChuanbi;
import com.example.babauactivity.fragment.FragChuyenda;
import com.example.babauactivity.fragment.FragDauhieu;
import com.example.babauactivity.fragment.FragKhamthai;
import com.example.babauactivity.fragment.FragMangthai;
import com.example.babauactivity.fragment.FragSuckhoe;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class TabCamnangAdapter extends FragmentStatePagerAdapter {
    private String listCamnang[] = {"Chuẩn bị","Sức khỏe","Dấu hiệu","Khám thai","Mang thai","Chuyển dạ"};

    private FragChuanbi fragChuanbi;
    private FragSuckhoe fragSuckhoe;
    private FragDauhieu fragDauhieu;
    private FragKhamthai fragKhamthai;
    private FragMangthai fragMangthai;
    private FragChuyenda fragChuyenda;

    public TabCamnangAdapter(@NonNull FragmentManager fm) {
        super(fm);

        fragChuanbi = new FragChuanbi();
        fragSuckhoe = new FragSuckhoe();
        fragDauhieu = new FragDauhieu();
        fragKhamthai = new FragKhamthai();
        fragMangthai = new FragMangthai();
        fragChuyenda = new FragChuyenda();

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            return fragChuanbi;
        } else if (position == 1){
            return fragSuckhoe;
        } else if (position == 2){
            return fragDauhieu;
        } else if (position == 3){
            return fragKhamthai;
        } else if (position == 4){
            return fragMangthai;
        } else if (position == 5){
            return fragChuyenda;
        }
        return null;
    }

    @Override
    public int getCount() {
        return listCamnang.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listCamnang[position];
    }
}
