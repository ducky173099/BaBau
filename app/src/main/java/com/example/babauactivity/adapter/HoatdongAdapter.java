package com.example.babauactivity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.babauactivity.R;
import com.example.babauactivity.model.DataHoatdong;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HoatdongAdapter extends RecyclerView.Adapter<HoatdongAdapter.ViewHolder>{
    Context context;
    ArrayList<DataHoatdong> dataHoatdongs;

    public HoatdongAdapter(Context context, ArrayList<DataHoatdong> dataHoatdongs) {
        this.context = context;
        this.dataHoatdongs = dataHoatdongs;
    }

    public void setDataHoatdongs(ArrayList<DataHoatdong> dataHoatdongs) {
        this.dataHoatdongs = dataHoatdongs;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.hoatdong_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (dataHoatdongs.get(position) !=null){
            holder.imghoatdong.setImageResource(dataHoatdongs.get(position).getHinh());
//            holder.imghoatdong.setImageResource(R.drawable.ic_book);
            holder.txtDesc.setText(dataHoatdongs.get(position).getDesc());
            holder.txtVal.setText(dataHoatdongs.get(position).getVal());
            holder.txtContent.setText(dataHoatdongs.get(position).getContent());
        }


    }

    @Override
    public int getItemCount() {
        return dataHoatdongs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imghoatdong;
        TextView txtDesc, txtVal, txtContent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imghoatdong = itemView.findViewById(R.id.imghoatdong);
            txtDesc = itemView.findViewById(R.id.txtDesc);
            txtVal = itemView.findViewById(R.id.txtVal);
            txtContent = itemView.findViewById(R.id.txtContent);
        }
    }
}
