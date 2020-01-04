package com.example.babauactivity.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.babauactivity.R;
import com.example.babauactivity.model.DataChiTietThaiKi;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ThaikiAdapter extends RecyclerView.Adapter<ThaikiAdapter.ViewHolder> {
    Context context;
    ArrayList<DataChiTietThaiKi> dataChiTietThaiKi;
    int pos = 0;

    public ThaikiAdapter(Context context, ArrayList<DataChiTietThaiKi> dataChiTietThaiKi) {
        this.context = context;
        this.dataChiTietThaiKi = dataChiTietThaiKi;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.thaikifrag_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imgSieuam.setImageResource(dataChiTietThaiKi.get(position).getHinhsieuam());
        holder.img_icbaby.setImageResource(dataChiTietThaiKi.get(position).getIconbaby());
        holder.img_icmom.setImageResource(dataChiTietThaiKi.get(position).getIconmom());
        holder.img_iclk.setImageResource(dataChiTietThaiKi.get(position).getIconlk());
        holder.txt2d.setText(dataChiTietThaiKi.get(position).getHaichieu());
        holder.txt3d.setText(dataChiTietThaiKi.get(position).getBachieu());
        holder.txtmau.setText(dataChiTietThaiKi.get(position).getMau());
        holder.txtvideo.setText(dataChiTietThaiKi.get(position).getVideo());
        holder.txtDescbaby.setText(dataChiTietThaiKi.get(position).getDescbaby());
        holder.txtDescmom.setText(dataChiTietThaiKi.get(position).getDescmom());
        holder.txtDesclk.setText(dataChiTietThaiKi.get(position).getDesclk());
        holder.txtContentbaby.setText(dataChiTietThaiKi.get(position).getContentbaby());
        holder.txtContentmom.setText(dataChiTietThaiKi.get(position).getContentmom());
        holder.txtContentlk.setText(dataChiTietThaiKi.get(position).getContentlk());


        if (pos == position){
            holder.txt2d.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    holder.imgSieuam.setImageResource(R.drawable.sieuam1);
                    holder.txt2d.setTextColor(Color.WHITE);
                    holder.txt2d.setBackgroundResource(R.drawable.borderliftred);
                    holder.txt3d.setTextColor(Color.parseColor("#26990A"));
                    holder.txt3d.setBackgroundResource(R.drawable.borderred);
                    holder.txtmau.setTextColor(Color.parseColor("#26990A"));
                    holder.txtmau.setBackgroundResource(R.drawable.borderred);
                    holder.txtvideo.setTextColor(Color.parseColor("#26990A"));
                    holder.txtvideo.setBackgroundResource(R.drawable.borderright);
                }
            });
            holder.txt3d.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    holder.imgSieuam.setImageResource(R.drawable.ic_book);
                    holder.txt3d.setTextColor(Color.WHITE);
                    holder.txt3d.setBackgroundColor(Color.RED);
                    holder.txt2d.setTextColor(Color.parseColor("#26990A"));
                    holder.txt2d.setBackgroundResource(R.drawable.borderleft);
                    holder.txtmau.setTextColor(Color.parseColor("#26990A"));
                    holder.txtmau.setBackgroundResource(R.drawable.borderred);
                    holder.txtvideo.setTextColor(Color.parseColor("#26990A"));
                    holder.txtvideo.setBackgroundResource(R.drawable.borderright);

                }
            });
            holder.txtmau.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    holder.imgSieuam.setImageResource(R.drawable.ic_stork);
                    holder.txtmau.setTextColor(Color.WHITE);
                    holder.txtmau.setBackgroundColor(Color.RED);
                    holder.txt2d.setTextColor(Color.parseColor("#26990A"));
                    holder.txt2d.setBackgroundResource(R.drawable.borderleft);
                    holder.txt3d.setTextColor(Color.parseColor("#26990A"));
                    holder.txt3d.setBackgroundResource(R.drawable.borderred);
                    holder.txtvideo.setTextColor(Color.parseColor("#26990A"));
                    holder.txtvideo.setBackgroundResource(R.drawable.borderright);

                }
            });
            holder.txtvideo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    holder.imgSieuam.setImageResource(R.drawable.ic_continuous);
                    holder.txt2d.setTextColor(Color.parseColor("#26990A"));
                    holder.txt2d.setBackgroundResource(R.drawable.borderleft);
                    holder.txt3d.setTextColor(Color.parseColor("#26990A"));
                    holder.txt3d.setBackgroundResource(R.drawable.borderred);
                    holder.txtmau.setTextColor(Color.parseColor("#26990A"));
                    holder.txtmau.setBackgroundResource(R.drawable.borderred);
                    holder.txtvideo.setTextColor(Color.WHITE);
                    holder.txtvideo.setBackgroundResource(R.drawable.borderrightred);

                }
            });
        } else {
//            holder.txt2d.setTextColor(R.);
        }


    }

    @Override
    public int getItemCount() {
        return dataChiTietThaiKi.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgSieuam, img_icbaby, img_icmom, img_iclk;
        TextView txt2d,txt3d,txtmau,txtvideo,txtDescbaby,txtContentbaby,txtDescmom,txtContentmom,txtDesclk,txtContentlk;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgSieuam = itemView.findViewById(R.id.imgsieuam);
            img_icbaby = itemView.findViewById(R.id.img_icbaby);
            img_icmom = itemView.findViewById(R.id.img_icmom);
            img_iclk = itemView.findViewById(R.id.img_iclk);
            txt2d = itemView.findViewById(R.id.txt2d);
            txt3d = itemView.findViewById(R.id.txt3d);
            txtmau = itemView.findViewById(R.id.txtmau);
            txtvideo = itemView.findViewById(R.id.txtvideo);
            txtDescbaby = itemView.findViewById(R.id.txtDescbaby);
            txtDescmom = itemView.findViewById(R.id.txtDescmom);
            txtDesclk = itemView.findViewById(R.id.txtDesclk);
            txtContentbaby = itemView.findViewById(R.id.txtcontentbaby);
            txtContentmom = itemView.findViewById(R.id.txtcontentmom);
            txtContentlk = itemView.findViewById(R.id.txtcontentlk);
        }
    }


}
