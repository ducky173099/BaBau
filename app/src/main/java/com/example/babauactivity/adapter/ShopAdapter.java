package com.example.babauactivity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.babauactivity.R;
import com.example.babauactivity.database.DatabaseHelper;
import com.example.babauactivity.model.DataNameSon;
import com.example.babauactivity.model.DataShop;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ViewHolder> {
    Context context;
    ArrayList<DataShop> dataShops;
    private DatabaseHelper databaseHelper;

    public void setDataShops(ArrayList<DataShop> dataShops) {
        this.dataShops = dataShops;
        notifyDataSetChanged();
    }


    public ShopAdapter(Context context) {
        this.context = context;
        this.databaseHelper = new DatabaseHelper(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.shop_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        holder.img_SttShop.setImageResource(dataShops.get(position).getHinh());
        holder.txtDescShop.setText(dataShops.get(position).getDesc());
        holder.txtContentShop.setText(dataShops.get(position).getContet());

        if (dataShops.get(position).getIsstar() == 1){
            holder.img_starShop.setImageResource(R.drawable.ic_starred);
        } else{
            holder.img_starShop.setImageResource(R.drawable.ic_star);
        }

        holder.img_starShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (dataShops.get(position).getIsstar() == 1){
                    dataShops.get(position).setIsstar(0);
                    databaseHelper.UpdateName(dataShops.get(position).getId(),0);
                } else{
                    dataShops.get(position).setIsstar(1);
                    databaseHelper.UpdateName(dataShops.get(position).getId(),1);
                }
                notifyDataSetChanged();

            }
        });
    }

    @Override
    public int getItemCount() {
        return dataShops.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img_SttShop,img_starShop;
        TextView txtDescShop, txtContentShop;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img_SttShop = itemView.findViewById(R.id.img_SttShop);
            img_starShop = itemView.findViewById(R.id.img_starShop);
            txtDescShop = itemView.findViewById(R.id.txtDescShop);
            txtContentShop = itemView.findViewById(R.id.txtContentShop);
        }
    }
}
