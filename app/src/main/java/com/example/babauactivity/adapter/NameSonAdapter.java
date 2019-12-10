package com.example.babauactivity.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.babauactivity.R;

import com.example.babauactivity.database.DatabaseHelper;
import com.example.babauactivity.model.DataNameSon;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NameSonAdapter extends RecyclerView.Adapter<NameSonAdapter.ViewHolder> {
    Context context;
    ArrayList<DataNameSon> dataNameSon;
    DatabaseHelper databaseHelper;

    public void setDataNameSon(ArrayList<DataNameSon> dataNameSon) {
        this.dataNameSon = dataNameSon;
        notifyDataSetChanged();
    }

    public NameSonAdapter(Context context) {
        this.context = context;
        this.databaseHelper = new DatabaseHelper(context);

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.nameson_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        holder.imgalphabet.setImageResource(dataNameSon.get(position).getHinhalphabet());
//        holder.imgstar.setImageResource(dataNameSon.get(position).getStar());
        holder.txtnameson.setText(dataNameSon.get(position).getNameson());
        holder.txtynghia.setText(dataNameSon.get(position).getYnghia());

        if (dataNameSon.get(position).getIsstar() == 1){
            holder.imgstar.setImageResource(R.drawable.ic_starred);
            holder.imgalphabet.setImageResource(R.drawable.ic_ared);

        } else{
            holder.imgstar.setImageResource(R.drawable.ic_star);
            holder.imgalphabet.setImageResource(R.drawable.ic_acircle);
        }

        holder.imgstar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (dataNameSon.get(position).getIsstar() == 1){
                    dataNameSon.get(position).setIsstar(0);
                    databaseHelper.UpdateName(dataNameSon.get(position).getId(),0);
                } else{
                    dataNameSon.get(position).setIsstar(1);
                    databaseHelper.UpdateName(dataNameSon.get(position).getId(), 1);
                }

                notifyDataSetChanged();

            }
        });
    }

    @Override
    public int getItemCount() {
        return dataNameSon.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgalphabet, imgstar;
        TextView txtnameson, txtynghia;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgalphabet = itemView.findViewById(R.id.img_icalphabet);
            imgstar = itemView.findViewById(R.id.img_íctar);
            txtnameson = itemView.findViewById(R.id.txtnameson);
            txtynghia = itemView.findViewById(R.id.txtynghiason);
        }
    }
}
