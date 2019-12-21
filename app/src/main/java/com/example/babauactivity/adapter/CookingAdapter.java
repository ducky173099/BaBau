package com.example.babauactivity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.babauactivity.R;
import com.example.babauactivity.database.DatabaseHelper;
import com.example.babauactivity.model.DataCooking;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CookingAdapter extends RecyclerView.Adapter<CookingAdapter.ViewHolder>{
    Context context;
    ArrayList<DataCooking> dataCookings;
    private DatabaseHelper databaseHelper;

    public void setDataCookings(ArrayList<DataCooking> dataCookings) {
        this.dataCookings = dataCookings;
        notifyDataSetChanged();
    }

    public CookingAdapter(Context context) {
        this.context = context;
        this.databaseHelper = new DatabaseHelper(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.pregnancy_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        holder.img_Cook.setImageResource(dataCookings.get(position).getHinh());
        holder.txtDescCook.setText(dataCookings.get(position).getDescCook());
        holder.txtContentCook.setText(dataCookings.get(position).getContentCook());

        if (dataCookings.get(position) != null){
            if (dataCookings.get(position).getIsstar() == 1){
                holder.img_starCook.setImageResource(R.drawable.ic_starred);
            } else{
                holder.img_starCook.setImageResource(R.drawable.ic_star);
            }
        }


        holder.img_starCook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (dataCookings.get(position).getIsstar() == 1){
                    dataCookings.get(position).setIsstar(0);
                    databaseHelper.UpdateName(dataCookings.get(position).getId(),0);
                } else{
                    dataCookings.get(position).setIsstar(1);
                    databaseHelper.UpdateName(dataCookings.get(position).getId(), 1);
                }

                notifyDataSetChanged();

            }
        });

    }

    @Override
    public int getItemCount() {
        return dataCookings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img_Cook, img_starCook;
        TextView txtDescCook, txtContentCook;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img_Cook = itemView.findViewById(R.id.img_Cook);
            img_starCook = itemView.findViewById(R.id.img_starCook);
            txtDescCook = itemView.findViewById(R.id.txtDescCook);
            txtContentCook = itemView.findViewById(R.id.txtContentCook);
        }
    }
}
