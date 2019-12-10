package com.example.babauactivity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.babauactivity.R;
import com.example.babauactivity.model.DataSizebaby;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SizeBabyAdapter extends RecyclerView.Adapter<SizeBabyAdapter.ViewHolder> {
    Context context;
    ArrayList<DataSizebaby> dataSizebaby;

    public SizeBabyAdapter(Context context, ArrayList<DataSizebaby> dataSizebaby) {
        this.context = context;
        this.dataSizebaby = dataSizebaby;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.kichthuoc_row, parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imgSeedbaby.setImageResource(dataSizebaby.get(position).getHinhseed());
        holder.txtWeeks.setText(dataSizebaby.get(position).getWeeks());
        holder.txtSeed.setText(dataSizebaby.get(position).getSeeds());
        holder.txtSizebaby.setText(dataSizebaby.get(position).getSizebaby());

    }

    @Override
    public int getItemCount() {
        return dataSizebaby.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgSeedbaby;
        TextView txtWeeks, txtSeed, txtSizebaby;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgSeedbaby = itemView.findViewById(R.id.imgSeedbaby);
            txtWeeks = itemView.findViewById(R.id.txtWeekbaby);
            txtSeed = itemView.findViewById(R.id.txtseedbaby);
            txtSizebaby = itemView.findViewById(R.id.txtsizebaby);
        }
    }
}
