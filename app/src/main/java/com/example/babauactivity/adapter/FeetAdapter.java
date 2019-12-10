package com.example.babauactivity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.babauactivity.R;
import com.example.babauactivity.model.DataFeet;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FeetAdapter extends RecyclerView.Adapter<FeetAdapter.ViewHolder> {
    Context context;
    ArrayList<DataFeet> dataFeets;
    DataFeet dataFeet;

    public FeetAdapter(Context context, ArrayList<DataFeet> dataFeets) {
        this.context = context;
        this.dataFeets = dataFeets;
    }

    public void addFeettime(ArrayList<DataFeet> dataFeets) {


        notifyDataSetChanged();
    }

    public  void setDataFeets(ArrayList<DataFeet> dataFeets) {
        this.dataFeets = dataFeets;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.feet_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imgTwo.setImageResource(dataFeets.get(position).getHinhtt());
        holder.txtTimeFeet.setText(dataFeets.get(position).getTimer());
        holder.txtRealtime.setText(dataFeets.get(position).getRealtime());
        holder.txtCountFeet.setText(dataFeets.get(position).getFeet());

//        holder.imgDel.setImageResource(R.drawable.ic_substract);
    }

    @Override
    public int getItemCount() {
        return dataFeets.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgTwo, imgDel;
        TextView txtTimeFeet, txtRealtime, txtCountFeet;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgTwo = itemView.findViewById(R.id.imgtwo);
            txtTimeFeet = itemView.findViewById(R.id.txtTimefeet);
            txtRealtime = itemView.findViewById(R.id.txtRealtime);
            txtCountFeet = itemView.findViewById(R.id.txtCountfeet);
        }
    }
}
