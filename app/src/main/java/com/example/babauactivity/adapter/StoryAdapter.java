package com.example.babauactivity.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.babauactivity.R;
import com.example.babauactivity.activity.InitStoryActivity;
import com.example.babauactivity.database.DatabaseHelper;
import com.example.babauactivity.model.DataStory;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.ViewHolder>{
    Context context;
    ArrayList<DataStory> dataStories;
    private DatabaseHelper databaseHelper;

    private ItemClick clickStory;

    public void setClickStory(ItemClick clickStory) {
        this.clickStory = clickStory;
    }

    public void setDataStories(ArrayList<DataStory> dataStories) {
        this.dataStories = dataStories;
        notifyDataSetChanged();
    }

    public StoryAdapter(Context context) {
        this.context = context;
        this.databaseHelper = new DatabaseHelper(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.story_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtStory.setText(dataStories.get(position).getDescStory());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dataStories.get(position).getStatus() == 1){
                    dataStories.get(position).setStatus(0);
                    databaseHelper.UpdateName(dataStories.get(position).getId(),0);

                } else {
                    dataStories.get(position).setStatus(1);
                    databaseHelper.UpdateName(dataStories.get(position).getId(),1);
                }

                notifyDataSetChanged();

                String ns = holder.txtStory.getText().toString();
                Intent intent = new Intent(context, InitStoryActivity.class);
                intent.putExtra("story", ns);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return dataStories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img_sttStory;
        TextView txtStory;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img_sttStory = itemView.findViewById(R.id.img_sttStory);
            txtStory = itemView.findViewById(R.id.txtStory);
        }
    }

    public interface ItemClick{
        void ClickStory(int posotion);
    }
}
