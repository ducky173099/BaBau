package com.example.babauactivity.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.babauactivity.R;
import com.example.babauactivity.activity.NgayDSActivity;
import com.example.babauactivity.model.DataKykinh;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class KykinhAdapter extends RecyclerView.Adapter<KykinhAdapter.ViewHolder>{
    Context context;
    ArrayList<DataKykinh> dataKykinhs;

    private ItemClick clickKykinh;

    public void setClickKykinh(ItemClick clickKykinh) {
        this.clickKykinh = clickKykinh;
    }

    public KykinhAdapter(Context context, ArrayList<DataKykinh> dataKykinhs) {
        this.context = context;
        this.dataKykinhs = dataKykinhs;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.kykinh_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtKyKinh.setText(dataKykinhs.get(position).getKinh()+" Ngày");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ngayKinh = dataKykinhs.get(position).getKinh();
                Intent intent = new Intent(context, NgayDSActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("ngaykinh", ngayKinh);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataKykinhs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtKyKinh;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

    txtKyKinh = itemView.findViewById(R.id.txtKyKinh);
}
    }
    public interface ItemClick{
        void ClickKykinh(int posotion);
    }
}
