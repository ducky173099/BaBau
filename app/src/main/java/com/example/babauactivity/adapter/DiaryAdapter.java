package com.example.babauactivity.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.babauactivity.R;
import com.example.babauactivity.database.DatabaseHelper;
import com.example.babauactivity.model.DataCannang;
import com.example.babauactivity.model.DataDiary;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DiaryAdapter extends RecyclerView.Adapter<DiaryAdapter.ViewHolder>{
    Context context;
    ArrayList<DataDiary> dataDiaries;

    public void setDataDiaries(ArrayList<DataDiary> dataDiaries) {
        this.dataDiaries = dataDiaries;
        notifyDataSetChanged();
    }

    public DiaryAdapter(Context context, ArrayList<DataDiary> dataDiaries) {
        this.context = context;
        this.dataDiaries = dataDiaries;

    }

    public void AddDairy(DataDiary dataDiary){
        dataDiaries.add(dataDiary);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.diary_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtTimeDiary.setText(dataDiaries.get(position).getTime());
        holder.txtDiary.setText(dataDiaries.get(position).getContent());

        if (dataDiaries.get(position).getImgDiary() != null){
            byte[] hinhanh = dataDiaries.get(position).getImgDiary();
            Bitmap bitmap = BitmapFactory.decodeByteArray(hinhanh,0, hinhanh.length);
            holder.imgDiary.setImageBitmap(bitmap);
        }

    }

    @Override
    public int getItemCount() {
        return dataDiaries.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img_sttDiary,imgDiary;
        TextView txtTimeDiary,txtDiary;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img_sttDiary = itemView.findViewById(R.id.img_sttDiary);
            imgDiary = itemView.findViewById(R.id.imgDiary);
            txtTimeDiary = itemView.findViewById(R.id.txtTimeDiary);
            txtDiary = itemView.findViewById(R.id.txtDiary);

        }
    }
}
