package com.example.babauactivity.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.babauactivity.R;
import com.example.babauactivity.database.DatabaseHelper;
import com.example.babauactivity.model.DataCannang;
import com.example.babauactivity.model.DataDiary;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.recyclerview.widget.RecyclerView;

public class DiaryAdapter extends RecyclerView.Adapter<DiaryAdapter.ViewHolder>{
    Context context;
    ArrayList<DataDiary> dataDiaries;
    DatabaseHelper databaseHelper;

    private Resources mResources;


    public void setDataDiaries(ArrayList<DataDiary> dataDiaries) {
        this.dataDiaries = dataDiaries;
        notifyDataSetChanged();
    }

    public DiaryAdapter(Context context, ArrayList<DataDiary> dataDiaries, DatabaseHelper databaseHelper) {
        this.context = context;
        this.dataDiaries = dataDiaries;
        this.databaseHelper = databaseHelper;
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
        DataDiary dataDiary = dataDiaries.get(position);


        holder.txtTimeDiary.setText(dataDiaries.get(position).getTime());
        holder.txtDiary.setText(dataDiaries.get(position).getContent());

        if (dataDiaries.get(position).getImgDiary() != null){
//            byte[] hinhanh = new byte[10000];

            Uri hinhanh = Uri.parse(dataDiaries.get(position).getImgDiary());
            InputStream inputStream = null;
            try {
                inputStream = context.getContentResolver().openInputStream(hinhanh);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            holder.imgDiary.setImageBitmap(bitmap);


            // custom border radius image
            float cornerRadius = 50.0f;
            mResources = Resources.getSystem();
            RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(
                    mResources,
                    bitmap
            );
            roundedBitmapDrawable.setCornerRadius(cornerRadius);
            roundedBitmapDrawable.setAntiAlias(true);
            holder.imgDiary.setImageDrawable(roundedBitmapDrawable);


            Log.e("logimg", "onBindViewHolder: " + hinhanh );
//            Picasso.get().load(hinhanh).into(holder.imgDiary);
//            Bitmap bitmap = BitmapFactory.decodeByteArray(hinhanh,0, hinhanh.length);
//            holder.imgDiary.setImageBitmap(Bitmap.createScaledBitmap(bitmap, 120, 120, false));
        } else {
            holder.imgDiary.setVisibility(View.GONE);
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
