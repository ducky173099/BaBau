package com.example.babauactivity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.babauactivity.R;
import com.example.babauactivity.database.DatabaseHelper;
import com.example.babauactivity.model.DataQuation;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class QuatationAdapter extends RecyclerView.Adapter<QuatationAdapter.ViewHolder>{
    Context context;
    ArrayList<DataQuation> dataQuations;
    DatabaseHelper databaseHelper;

    public QuatationAdapter(Context context) {
        this.context = context;
        this.databaseHelper = new DatabaseHelper(context);

    }

    public void setDataQuations(ArrayList<DataQuation> dataQuations) {
        this.dataQuations = dataQuations;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.quatation_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtContentQuata.setText(dataQuations.get(position).getContent());
        holder.txtNameQuata.setText(dataQuations.get(position).getName());

        if (dataQuations.get(position) != null){
            if (dataQuations.get(position).getStatus() == 1){
                holder.img_starQuata.setImageResource(R.drawable.ic_starred);
                holder.img_SttQuata.setImageResource(R.drawable.ic_ared);
            } else {
                holder.img_starQuata.setImageResource(R.drawable.ic_star);
                holder.img_SttQuata.setImageResource(R.drawable.ic_acircle);
            }
        }

        holder.img_starQuata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dataQuations.get(position).getStatus() == 1){
                    dataQuations.get(position).setStatus(0);
                    databaseHelper.UpdateName(dataQuations.get(position).getId(), 0);
                } else {
                    dataQuations.get(position).setStatus(1);
                    databaseHelper.UpdateName(dataQuations.get(position).getId(), 1);
                }
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataQuations.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img_SttQuata,img_starQuata;
        TextView txtContentQuata, txtNameQuata;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_SttQuata = itemView.findViewById(R.id.img_SttQuata);
            img_starQuata = itemView.findViewById(R.id.img_starQuata);
            txtContentQuata = itemView.findViewById(R.id.txtContentQuata);
            txtNameQuata = itemView.findViewById(R.id.txtNameQuata);

        }
    }
}
