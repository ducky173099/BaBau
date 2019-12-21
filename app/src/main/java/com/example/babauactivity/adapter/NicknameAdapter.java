package com.example.babauactivity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.babauactivity.R;
import com.example.babauactivity.database.DatabaseHelper;
import com.example.babauactivity.model.DataNickName;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NicknameAdapter extends RecyclerView.Adapter<NicknameAdapter.ViewHolder> {
    Context context;
    ArrayList<DataNickName> dataNickNames;
    private DatabaseHelper databaseHelper;


    public void setDataNickNames(ArrayList<DataNickName> dataNickNames) {
        this.dataNickNames = dataNickNames;
        notifyDataSetChanged();
    }

    public NicknameAdapter(Context context) {
        this.context = context;
        this.databaseHelper = new DatabaseHelper(context);
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.nickname_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtnick.setText(dataNickNames.get(position).getNickname());

        if (dataNickNames.get(position).getIsstar() == 1){
            holder.img_icNickstar.setImageResource(R.drawable.ic_starred);
            holder.img_icalphanick.setImageResource(R.drawable.ic_ared);
        } else {
            holder.img_icNickstar.setImageResource(R.drawable.ic_star);
            holder.img_icalphanick.setImageResource(R.drawable.ic_acircle);
        }

        holder.img_icNickstar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dataNickNames.get(position).getIsstar() == 1){
                    dataNickNames.get(position).setIsstar(0);
                    databaseHelper.UpdateName(dataNickNames.get(position).getId(),0);
                } else {
                    dataNickNames.get(position).setIsstar(1);
                    databaseHelper.UpdateName(dataNickNames.get(position).getId(),1);
                }

                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataNickNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img_icalphanick, img_icNickstar;
        TextView txtnick;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img_icalphanick = itemView.findViewById(R.id.img_icalphanick);
            img_icNickstar = itemView.findViewById(R.id.img_icNickstar);
            txtnick = itemView.findViewById(R.id.txtnick);
        }
    }
}
