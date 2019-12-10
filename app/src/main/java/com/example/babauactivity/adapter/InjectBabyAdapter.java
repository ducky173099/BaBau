package com.example.babauactivity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.babauactivity.R;
import com.example.babauactivity.model.DataInject;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class InjectBabyAdapter extends RecyclerView.Adapter<InjectBabyAdapter.ViewHolder>{
    Context context;
    ArrayList<DataInject> dataInjects;

    public InjectBabyAdapter(Context context, ArrayList<DataInject> dataInjects) {
        this.context = context;
        this.dataInjects = dataInjects;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.inject_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imgInjectbaby.setImageResource(dataInjects.get(position).getHinhinject());
        holder.txtOld.setText(dataInjects.get(position).getOld());
        holder.txtContetn.setText(dataInjects.get(position).getContetn());
    }

    @Override
    public int getItemCount() {
        return dataInjects.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgInjectbaby;
        TextView txtOld, txtContetn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgInjectbaby = itemView.findViewById(R.id.imgInjectbaby);
            txtOld = itemView.findViewById(R.id.txtOldbaby);
            txtContetn = itemView.findViewById(R.id.txtContentinject);
        }
    }
}
