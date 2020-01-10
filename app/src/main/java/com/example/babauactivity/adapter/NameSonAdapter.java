package com.example.babauactivity.adapter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.babauactivity.R;

import com.example.babauactivity.database.DatabaseHelper;
import com.example.babauactivity.model.DataNameSon;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NameSonAdapter extends RecyclerView.Adapter<NameSonAdapter.ViewHolder> {
    private  Context context;
    private ArrayList<DataNameSon> dataNameSon;
    private DatabaseHelper databaseHelper;

    private ItemClick clickYnghia;

    public void setClickYnghia(ItemClick clickYnghia) {
        this.clickYnghia = clickYnghia;
    }

    public void setDataNameSon(ArrayList<DataNameSon> dataNameSon) {
        this.dataNameSon = dataNameSon;
        notifyDataSetChanged();
    }

    public NameSonAdapter(Context context) {
        this.context = context;
        this.databaseHelper = new DatabaseHelper(context);

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.nameson_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtnameson.setText(dataNameSon.get(position).getNameson());
        holder.txtynghia.setText(dataNameSon.get(position).getYnghia());

        if (dataNameSon.get(position) != null){
            if (dataNameSon.get(position).getIsstar() == 1){
                holder.imgstar.setImageResource(R.drawable.ic_starred);
                holder.imgalphabet.setImageResource(R.drawable.ic_ared);
            } else{
                holder.imgstar.setImageResource(R.drawable.ic_star);
                holder.imgalphabet.setImageResource(R.drawable.ic_acircle);
            }
        }

        holder.txtynghia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(context);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_name);
                Button btnback = dialog.findViewById(R.id.btnback);
                TextView txtnamedialog = dialog.findViewById(R.id.txtnamedialog);

                txtnamedialog.setText(dataNameSon.get(position).getNameson());

                btnback.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                dialog.show();

            }
        });




        holder.imgstar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (dataNameSon.get(position).getIsstar() == 1){
                    dataNameSon.get(position).setIsstar(0);
                    databaseHelper.UpdateName(dataNameSon.get(position).getId(),0);
                } else{
                    dataNameSon.get(position).setIsstar(1);
                    databaseHelper.UpdateName(dataNameSon.get(position).getId(), 1);
                }

                notifyDataSetChanged();

            }
        });
    }

    @Override
    public int getItemCount() {
        return dataNameSon.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgalphabet, imgstar;
        TextView txtnameson, txtynghia;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgalphabet = itemView.findViewById(R.id.img_icalphabet);
            imgstar = itemView.findViewById(R.id.img_íctar);
            txtnameson = itemView.findViewById(R.id.txtnameson);
            txtynghia = itemView.findViewById(R.id.txtynghiason);
        }
    }


    public interface ItemClick{
        void ClickYnghia(int position);
    }
}
