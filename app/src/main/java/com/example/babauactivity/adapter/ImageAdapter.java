package com.example.babauactivity.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.babauactivity.R;
import com.example.babauactivity.model.DataPicturebaby;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class ImageAdapter extends PagerAdapter {
    private ArrayList<DataPicturebaby> data = new ArrayList<>();
    private LayoutInflater inflater;
    private Context context;

    public ImageAdapter(ArrayList<DataPicturebaby> data, Context context) {
        if (data == null) {
            Log.e("TAG ","DATA NULL ");
        }
        this.data = data;
        this.context = context;
    }

    public void setDataList(ArrayList<DataPicturebaby> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.pagerbaby_row, container, false);
        ImageView view;
        view = v.findViewById(R.id.itempager);
        Glide.with(view).load(data.get(position).getHinh()).into(view);
        (container).addView(v, 0);
        return v;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
