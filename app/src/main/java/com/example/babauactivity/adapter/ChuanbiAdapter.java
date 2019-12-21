package com.example.babauactivity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.babauactivity.R;
import com.example.babauactivity.model.DataChuanbi;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ChuanbiAdapter extends RecyclerView.Adapter<ChuanbiAdapter.ViewHolder>{
    Context context;
    ArrayList<DataChuanbi> dataChuanbis;

    private ItemClick clickChuanbi; // buoc 2 interface

    public void setClickChuanbi(ItemClick clickChuanbi) {  // buoc 3 interfacce
        this.clickChuanbi = clickChuanbi;
    }

    public ChuanbiAdapter(Context context, ArrayList<DataChuanbi> dataChuanbis) {
        this.context = context;
        this.dataChuanbis = dataChuanbis;
    }

    public void setDataChuanbis(ArrayList<DataChuanbi> dataChuanbis) {
        this.dataChuanbis = dataChuanbis;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.camnang_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (dataChuanbis.get(position) != null){
            holder.imgstt.setImageResource(dataChuanbis.get(position).getHinh());
            holder.txtCamnang.setText(dataChuanbis.get(position).getContent());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickChuanbi.ClickChuanbi(position);
                }
            });
        }


    }

    @Override
    public int getItemCount() {
        return dataChuanbis.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgstt;
        TextView txtCamnang;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgstt = itemView.findViewById(R.id.img_stt);
            txtCamnang = itemView.findViewById(R.id.txtcamnang);
        }
    }

    // buoc 1 interface
    public interface ItemClick{
        void ClickChuanbi(int position);
    }
}
