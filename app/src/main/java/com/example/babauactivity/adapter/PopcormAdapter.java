package com.example.babauactivity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.babauactivity.model.DataPopcorm;
import com.example.babauactivity.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PopcormAdapter extends RecyclerView.Adapter<PopcormAdapter.ViewHolder> {
    ArrayList<DataPopcorm> dataPopcorm;
    Context context;

    private ItemClick clickPopcorm;

    public void setClickPopcorm(ItemClick clickPopcorm) {
        this.clickPopcorm = clickPopcorm;
    }

    public PopcormAdapter(ArrayList<DataPopcorm> dataPopcorm, Context context) {
        this.dataPopcorm = dataPopcorm;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.popcorm_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtnamepopcorm.setText(dataPopcorm.get(position).getTenpopcorm());
        holder.imgpopcorm.setImageResource(dataPopcorm.get(position).getHinhpopcorm());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickPopcorm.ClickPopcorm(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataPopcorm.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtnamepopcorm;
        ImageView imgpopcorm;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtnamepopcorm = itemView.findViewById(R.id.txt_popcorm);
            imgpopcorm = itemView.findViewById(R.id.img_popcorm);

        }
    }

    public interface ItemClick{
        void ClickPopcorm(int position);
    }
}
