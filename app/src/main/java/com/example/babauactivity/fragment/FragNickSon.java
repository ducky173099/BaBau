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
import com.example.babauactivity.model.DataNameSon;
import com.example.babauactivity.model.DataNickName;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragNickSon extends Fragment implements View.OnClickListener {
    RecyclerView recyclerViewNickSon;
    ArrayList<DataNickName> dataNickNames;
    ArrayList<DataNickName> datasearch;
    DatabaseHelper databaseHelper;
    NicknameAdapter nicknameAdapter;

    EditText edtsearchnickson;
    ImageView delnickson;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_nickson, container, false);

        delnickson = view.findViewById(R.id.delnickson);
        edtsearchnickson = view.findViewById(R.id.edtsearchnickson);
        dataNickNames = new ArrayList<>();
        datasearch = new ArrayList<>();
        nicknameAdapter = new NicknameAdapter(getContext());

        recyclerViewNickSon = view.findViewById(R.id.recycler_listnickson);
        databaseHelper = new DatabaseHelper(getContext());
        dataNickNames = databaseHelper.getNickSon();

        nicknameAdapter.setDataNickNames(dataNickNames);
        recyclerViewNickSon.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL, false));
        recyclerViewNickSon.setAdapter(nicknameAdapter);

        edtsearchnickson.addTextChangedListener(new TextWatcher() { // Search Lits
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

        delnickson.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        edtsearchnickson.getText().clear();
    }
}
