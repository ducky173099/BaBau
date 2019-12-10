package com.example.babauactivity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.babauactivity.model.DataMom;
import com.example.babauactivity.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MomAdapter extends RecyclerView.Adapter<MomAdapter.ViewHolder> { // buoc 2:extend
    // buoc 3
    Context context;
    ArrayList<DataMom> dataMom;

    public MomAdapter(Context context, ArrayList<DataMom> dataMom) {
        this.context = context;
        this.dataMom = dataMom;
    }

    @NonNull
    @Override
    // buoc 4
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemview = layoutInflater.inflate(R.layout.mom_row, parent, false);

        return new ViewHolder(itemview);
    }

    @Override
    // buoc 5
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtnamemom.setText(dataMom.get(position).getTenmom());
        holder.imgmom.setImageResource(dataMom.get(position).getHinhmom());
    }

    @Override
    public int getItemCount() {
        return dataMom.size();
    }

    // buoc 1
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtnamemom;
        ImageView imgmom;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtnamemom = itemView.findViewById(R.id.txt_mom);
            imgmom = itemView.findViewById(R.id.img_mom);
        }
    }
}
