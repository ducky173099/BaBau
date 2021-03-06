package com.example.babauactivity.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.babauactivity.R;
import com.example.babauactivity.fragment.FragThaiki;
import com.example.babauactivity.model.DataDatetk;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

public class DateThaikiAdapter extends RecyclerView.Adapter<DateThaikiAdapter.ViewHolder> {
    ArrayList<DataDatetk> dataDatetk;
    Context context;
    int row_index =0;

    private ItemClick clickRecycler; // buoc 2 interface

    public void setClickRecycler(ItemClick clickRecycler) {
        this.clickRecycler = clickRecycler;
    }

    public DateThaikiAdapter(ArrayList<DataDatetk> dataDatetk, Context context) {
        this.dataDatetk = dataDatetk;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.datethaiki_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder,final int position) {
        holder.txtstt.setText(dataDatetk.get(position).getStt());
        holder.txtDatetk.setText(dataDatetk.get(position).getDatetk());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickRecycler.ClickDatetk(position);
                row_index = position;
                notifyDataSetChanged();
            }
        });


        if(row_index == position){
            holder.linear_thaiki.setBackgroundColor(Color.parseColor("#8F016D69"));
        }
        else {
            holder.linear_thaiki.setBackgroundColor(Color.parseColor("#00FFFFFF"));
        }

    }


    @Override
    public int getItemCount() {
        return dataDatetk.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtstt, txtDatetk;
        LinearLayout linear_thaiki;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtstt = itemView.findViewById(R.id.txtstt);
            txtDatetk = itemView.findViewById(R.id.txtdatetk);
            linear_thaiki = itemView.findViewById(R.id.linear_thaiki);
        }
    }

    public interface ItemClick{
        void ClickDatetk(int position);
    }
}
