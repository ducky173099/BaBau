package com.example.babauactivity.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.babauactivity.R;
import com.example.babauactivity.adapter.NicknameAdapter;
import com.example.babauactivity.database.DatabaseHelper;
import com.example.babauactivity.model.DataNickName;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragNickDauter extends Fragment {
    RecyclerView recycler_listnickDauter;
    ArrayList<DataNickName> dataNickNames;
    DatabaseHelper databaseHelper;
    NicknameAdapter nicknameAdapter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_nickdauter, container, false);

        dataNickNames = new ArrayList<>();
        nicknameAdapter = new NicknameAdapter(getContext());

        recycler_listnickDauter = view.findViewById(R.id.recycler_listnickDauter);
        databaseHelper = new DatabaseHelper(getContext());
        dataNickNames = databaseHelper.getNickDauter();

        nicknameAdapter.setDataNickNames(dataNickNames);
        recycler_listnickDauter.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL, false));
        recycler_listnickDauter.setAdapter(nicknameAdapter);

        return view;
    }
}
