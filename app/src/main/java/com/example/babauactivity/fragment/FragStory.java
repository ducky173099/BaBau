package com.example.babauactivity.fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.babauactivity.R;
import com.example.babauactivity.adapter.StoryAdapter;
import com.example.babauactivity.database.DatabaseHelper;
import com.example.babauactivity.model.DataChuanbi;
import com.example.babauactivity.model.DataStory;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragStory extends Fragment implements StoryAdapter.ItemClick {
    RecyclerView recycler_liststory;
    ArrayList<DataStory> dataStories;
    ArrayList<DataStory> dataSearch;
    StoryAdapter storyAdapter;

    EditText edtsearch_story;
    DatabaseHelper databaseHelper;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_truyen, container, false);

        edtsearch_story = view.findViewById(R.id.edtsearch_story);
        recycler_liststory = view.findViewById(R.id.recycler_liststory);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recycler_liststory.setLayoutManager(layoutManager);

        dataSearch = new ArrayList<>();
        dataStories = new ArrayList<>();

        storyAdapter = new StoryAdapter(getContext());
        databaseHelper = new DatabaseHelper(getContext());
        dataStories = databaseHelper.getStory();
        storyAdapter.setDataStories(dataStories);
        recycler_liststory.setAdapter(storyAdapter);

        storyAdapter.setClickStory(this);

        edtsearch_story.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                fillterSearch(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }

            private void fillterSearch(String text){
                dataSearch.clear();
                Log.e("TAG","CHECK DATA SIZE:"+dataStories.size());
                for (DataStory data: dataStories){
                    if (data.getDescStory().toUpperCase().contains(text.toUpperCase())){
                        Log.e("TAG","CHECK DATA add:");
                        dataSearch.add(data);
                    }
                }
                Log.e("TAG","CHECK:"+dataSearch.size());
                storyAdapter.setDataStories(dataSearch);
            }
        });

        return view;
    }

    @Override
    public void ClickStory(int posotion) {

    }
}
