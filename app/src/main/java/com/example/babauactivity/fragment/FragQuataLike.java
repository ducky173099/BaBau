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
import com.example.babauactivity.model.DataQuation;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragQuataLike extends Fragment implements View.OnClickListener {
    RecyclerView recycler_quatationLike;
    ArrayList<DataQuation> dataQuations;
    ArrayList<DataQuation> dataSearch;
    QuatationAdapter quatationAdapter;
    DatabaseHelper databaseHelper;

    EditText edtsearch_quatationLike;
    ImageView delQuatalike;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_quatalike, container, false);

        delQuatalike = view.findViewById(R.id.delQuatalike);
        recycler_quatationLike = view.findViewById(R.id.recycler_quatationLike);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false);
        recycler_quatationLike.setLayoutManager(linearLayoutManager);

        edtsearch_quatationLike = view.findViewById(R.id.edtsearch_quatationLike);

        dataQuations = new ArrayList<>();
        dataSearch = new ArrayList<>();
        quatationAdapter = new QuatationAdapter(getContext());
        databaseHelper = new DatabaseHelper(getContext());

        dataQuations = databaseHelper.getQuataLike();
        quatationAdapter.setDataQuations(dataQuations);

        recycler_quatationLike.setAdapter(quatationAdapter);

        edtsearch_quatationLike.addTextChangedListener(new TextWatcher() { // Search Lits
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


        delQuatalike.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        edtsearch_quatationLike.getText().clear();
    }
}
