package com.example.babauactivity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.babauactivity.R;
import com.example.babauactivity.model.DataFeet;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FeetAdapter extends RecyclerView.Adapter<FeetAdapter.ViewHolder> {
    Context context;
    ArrayList<DataFeet> dataFeets;

    private ItemClick clickDel;

    public void setClickDel(ItemClick clickDel) {
        this.clickDel = clickDel;
        notifyDataSetChanged();
    }

    public FeetAdapter(Context context, ArrayList<DataFeet> dataFeets) {
        this.context = context;
        this.dataFeets = dataFeets;
    }

    public void AddFeet(DataFeet dataFeet) {
        dataFeets.add(dataFeet);
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

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "del " + position, Toast.LENGTH_SHORT).show();
                dataFeets.remove(position);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataFeets.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgTwo, imgdelfeet;
        TextView txtTimeFeet, txtRealtime, txtCountFeet;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgTwo = itemView.findViewById(R.id.imgtwo);
            txtTimeFeet = itemView.findViewById(R.id.txtTimefeet);
            txtRealtime = itemView.findViewById(R.id.txtRealtime);
            txtCountFeet = itemView.findViewById(R.id.txtCountfeet);

            imgdelfeet = itemView.findViewById(R.id.imgdelfeet);
        }
    }

    public interface ItemClick{
        void ClickDel(int position);
    }
}
