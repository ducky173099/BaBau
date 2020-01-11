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
import com.example.babauactivity.adapter.QuatationAdapter;
import com.example.babauactivity.database.DatabaseHelper;
import com.example.babauactivity.model.DataNameSon;
import com.example.babauactivity.model.DataQuation;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragQuatation extends Fragment implements View.OnClickListener {
    RecyclerView recycler_quatation;
    ArrayList<DataQuation> dataQuations;
    ArrayList<DataQuation> dataSearch;
    QuatationAdapter quatationAdapter;
    DatabaseHelper databaseHelper;

    EditText edtsearch_quatation;

    ImageView delQuata;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_quatation, container, false);

        delQuata = view.findViewById(R.id.delQuata);
        recycler_quatation = view.findViewById(R.id.recycler_quatation);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false);
        recycler_quatation.setLayoutManager(linearLayoutManager);

        edtsearch_quatation = view.findViewById(R.id.edtsearch_quatation);

        dataQuations = new ArrayList<>();
        dataSearch = new ArrayList<>();

        quatationAdapter = new QuatationAdapter(getContext());
        databaseHelper = new DatabaseHelper(getContext());

        dataQuations = databaseHelper.getQuatation();
        quatationAdapter.setDataQuations(dataQuations);
        Log.e("quata", "data size: " + dataQuations.size() );
        recycler_quatation.setAdapter(quatationAdapter);

        edtsearch_quatation.addTextChangedListener(new TextWatcher() { // Search Lits
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
                dataSearch.clear();
                Log.e("TAG","CHECK DATA SIZE:"+dataQuations.size());
                for (DataQuation data: dataQuations){

//                    if (data.getNameson().equalsIgnoreCase(text)){
//                        dataNameSonList.add(data);
//                    }
                    if (data.getContent().toUpperCase().contains(text.toUpperCase())){
                        Log.e("TAG","CHECK DATA add:");
                        dataSearch.add(data);
                    }
                }
                Log.e("TAG","CHECK:"+dataSearch.size());
                quatationAdapter.setDataQuations(dataSearch);
            }
        });

        delQuata.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View view) {
        edtsearch_quatation.getText().clear();
    }
}
