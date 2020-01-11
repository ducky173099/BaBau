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
import com.example.babauactivity.adapter.NameSonAdapter;
import com.example.babauactivity.database.DatabaseHelper;
import com.example.babauactivity.model.DataNameSon;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentNameLike extends Fragment implements View.OnClickListener {
    ArrayList<DataNameSon> dataNameSon;
    ArrayList<DataNameSon> dataNameSonList;

    NameSonAdapter nameSonAdapter;
    RecyclerView recyclerViewListlike;
    DatabaseHelper databaseHelper;

    EditText edtSearchnamelike;

    ImageView delnamelike;
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_namelike, container, false);

        delnamelike = view.findViewById(R.id.delnamelike);
        edtSearchnamelike = view.findViewById(R.id.edtSearchnamelike);
        dataNameSonList = new ArrayList<>();

        databaseHelper = new DatabaseHelper(getContext());
        recyclerViewListlike = view.findViewById(R.id.recycler_listlike);

        dataNameSon = new ArrayList<>();
        dataNameSon = databaseHelper.getLike();

        nameSonAdapter = new NameSonAdapter(getContext());
        nameSonAdapter.setDataNameSon(dataNameSon);
        recyclerViewListlike.setAdapter(nameSonAdapter);

        edtSearchnamelike.addTextChangedListener(new TextWatcher() { // Search Lits
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
                dataNameSonList.clear();
                Log.e("TAG","CHECK DATA SIZE:"+dataNameSon.size());
                for (DataNameSon data: dataNameSon){

//                    if (data.getNameson().equalsIgnoreCase(text)){
//                        dataNameSonList.add(data);
//                    }
                    if (data.getNameson().toUpperCase().contains(text.toUpperCase())){
                        Log.e("TAG","CHECK DATA add:");
                        dataNameSonList.add(data);
                    }
                }
                Log.e("TAG","CHECK:"+dataNameSonList.size());
                nameSonAdapter.setDataNameSon(dataNameSonList);
            }
        });

        delnamelike.setOnClickListener(this);
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

    @Override
    public void onClick(View view) {
        edtSearchnamelike.getText().clear();
    }
}
