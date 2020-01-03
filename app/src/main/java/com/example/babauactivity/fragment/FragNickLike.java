package com.example.babauactivity.fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

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

public class FragNickLike extends Fragment implements View.OnClickListener {
    RecyclerView recycler_listnicklike;
    ArrayList<DataNickName> dataNickNames;
    ArrayList<DataNickName> datasearch;

    DatabaseHelper databaseHelper;
    NicknameAdapter nicknameAdapter;

    EditText edtsearchnicklike;
    ImageView delnicklike;
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_nicklike, container, false);

        delnicklike = view.findViewById(R.id.delnicklike);
        edtsearchnicklike = view.findViewById(R.id.edtsearchnicklike);
        dataNickNames = new ArrayList<>();
        datasearch = new ArrayList<>();
        nicknameAdapter = new NicknameAdapter(getContext());

        recycler_listnicklike = view.findViewById(R.id.recycler_listnicklike);
        databaseHelper = new DatabaseHelper(getContext());
        dataNickNames = databaseHelper.getNickLike();

        nicknameAdapter.setDataNickNames(dataNickNames);
        recycler_listnicklike.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL, false));
        recycler_listnicklike.setAdapter(nicknameAdapter);

        edtsearchnicklike.addTextChangedListener(new TextWatcher() { // Search Lits
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.e("search", "onTextChanged: " );
                fillterSearch(charSequence.toString());

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }

            private void fillterSearch(String text){
                datasearch.clear();

                for (DataNickName data: dataNickNames){
                    if (data.getNickname().toUpperCase().contains(text.toUpperCase())){
                        Log.e("TAG","CHECK DATA add:");
                        datasearch.add(data);
                    }
                }

                nicknameAdapter.setDataNickNames(datasearch);
            }
        });


        delnicklike.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View view) {
        edtsearchnicklike.getText().clear();
    }
}
