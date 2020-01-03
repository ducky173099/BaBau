package com.example.babauactivity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.babauactivity.model.DataChild;
import com.example.babauactivity.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.ViewHolder> implements ItemClick { // buoc 2: extends
    ArrayList<DataChild> dataChild; // buoc 3
    Context context;
    ItemClick itemClick;

    public void setItemClick(ItemClick itemClick) {
        this.itemClick = itemClick;
    }

    public ChildAdapter(ArrayList<DataChild> dataChild, Context context) {
        this.dataChild = dataChild;
        this.context = context;
    }

    @NonNull
    @Override
    // buoc 4
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.child_row, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    // buoc 5
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtnamechild.setText(dataChild.get(position).getTenchild());
        holder.imgHinhchild.setImageResource(dataChild.get(position).getHinhchild());
//        Picasso.get()
//                .load(dataChild.get(position).getHinhchild())
//                .placeholder(R.drawable.loading)
//                .into(holder.imgHinhchild);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClick.onClickItem(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataChild.size();
    }

    @Override
    public void onClickItem(int position) {

    }


    // buoc 1
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtnamechild;
        ImageView imgHinhchild;
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            txtnamechild = itemView.findViewById(R.id.txt_child);
            imgHinhchild = itemView.findViewById(R.id.img_child);

        }
    }




}
