package com.example.babauactivity.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.babauactivity.R;
import com.example.babauactivity.model.DataPicturebaby;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

public class PicturebabyAdapter extends RecyclerView.Adapter<PicturebabyAdapter.ViewHolder>{
    Context context;
    ArrayList<DataPicturebaby> dataPicturebabies;

    private ItemClick click; // buoc 2 interface

    public void setClick(ItemClick click) { // buoc 3 interfacce
        this.click = click;
    }

    public PicturebabyAdapter(Context context, ArrayList<DataPicturebaby> dataPicturebabies) {
        this.context = context;
        this.dataPicturebabies = dataPicturebabies;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.picturebaby_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imgBeyeu.setImageResource(dataPicturebabies.get(position).getHinh());
        holder.itemView.setOnClickListener(new View.OnClickListener() { // buoc 4 interface
            @Override
            public void onClick(View view) {
                click.ClickPicture(position);

            }
        });
    }



    @Override
    public int getItemCount() {
        return dataPicturebabies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgBeyeu;
        LinearLayout linear_picturebaby;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgBeyeu = itemView.findViewById(R.id.imgBeyeu);
            linear_picturebaby = itemView.findViewById(R.id.linear_picturebaby);
        }
    }

    // buoc 1 interface
    public interface ItemClick{
        void ClickPicture(int position);
    }



}
