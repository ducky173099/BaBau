package com.example.babauactivity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.babauactivity.R;
import com.example.babauactivity.model.DataCannang;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CannangAdapter extends RecyclerView.Adapter<CannangAdapter.ViewHolder> {
    Context context;
    ArrayList<DataCannang> dataCannangs;

    private ItemClick clickCannang;

    public void setClickCannang(ItemClick clickCannang) {
        this.clickCannang = clickCannang;
        notifyDataSetChanged();
    }

    public CannangAdapter(Context context, ArrayList<DataCannang> dataCannangs) {
        this.context = context;
        this.dataCannangs = dataCannangs;
    }

    public void AddCannang(DataCannang dataCannang){
        dataCannangs.add(dataCannang);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.cannang_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtTimeweight.setText(dataCannangs.get(position).getTime());
        holder.txtCountweight.setText(dataCannangs.get(position).getCannang());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataCannangs.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataCannangs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgthree,delweight;
        TextView txtTimeweight,txtCountweight;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgthree = itemView.findViewById(R.id.imgthree);
            delweight = itemView.findViewById(R.id.delweight);
            txtTimeweight = itemView.findViewById(R.id.txtTimeweight);
            txtCountweight = itemView.findViewById(R.id.txtCountweight);


        }
    }

    public interface ItemClick{
        void ClickDelCan(int position);
    }
}
