package com.example.babauactivity.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.babauactivity.R;
import com.example.babauactivity.adapter.NameSonAdapter;
import com.example.babauactivity.database.DatabaseHelper;
import com.example.babauactivity.model.DataNameSon;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentNameLike extends Fragment {
    ArrayList<DataNameSon> dataNameSon;

    NameSonAdapter nameSonAdapter;
    RecyclerView recyclerViewListlike;
    DatabaseHelper databaseHelper;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_namelike, container, false);

        databaseHelper = new DatabaseHelper(getContext());
        recyclerViewListlike = view.findViewById(R.id.recycler_listlike);

        dataNameSon = new ArrayList<>();
        dataNameSon = databaseHelper.getLike();

        nameSonAdapter = new NameSonAdapter(getContext());
        nameSonAdapter.setDataNameSon(dataNameSon);
        recyclerViewListlike.setAdapter(nameSonAdapter);

        return view;
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.e("AAA", "llllllllllllllllllllllllll: " + dataNameSon.size());

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e("AAA", "onResume: " + dataNameSon.size());

    }

    @Override
    public void onStart() {
        Log.e("AAA", "onResume: " + dataNameSon.size());

        super.onStart();

    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e("AAA", "onPause: " );
    }

}
