package com.example.babauactivity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.babauactivity.R;
import com.example.babauactivity.model.DataThucpham;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ThucphamAdapter extends RecyclerView.Adapter<ThucphamAdapter.ViewHolder>{
    Context context;
    ArrayList<DataThucpham> dataThucphams;


    public void setDataThucphams(ArrayList<DataThucpham> dataThucphams) {
        this.dataThucphams = dataThucphams;
        notifyDataSetChanged();
    }

    public ThucphamAdapter(Context context, ArrayList<DataThucpham> dataThucphams) {
        this.context = context;
        this.dataThucphams = dataThucphams;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.thucpham_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imgthucpham.setImageResource(dataThucphams.get(position).getHinh());
        holder.txtDescTP.setText(dataThucphams.get(position).getDesc());
        holder.txtContentTP.setText(dataThucphams.get(position).getContent());

    }

    @Override
    public int getItemCount() {
        return dataThucphams.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgthucpham;
        TextView txtDescTP, txtContentTP;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgthucpham = itemView.findViewById(R.id.imgthucpham);
            txtDescTP = itemView.findViewById(R.id.txtDescTP);
            txtContentTP = itemView.findViewById(R.id.txtContentTP);

        }
    }
}
