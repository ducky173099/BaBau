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
import com.example.babauactivity.activity.MainActivity;
import com.example.babauactivity.adapter.NameSonAdapter;
import com.example.babauactivity.database.DatabaseHelper;
import com.example.babauactivity.model.DataNameSon;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentNameDaughter extends BaseFragment<MainActivity> {
    RecyclerView recyclerViewNameDauter;

    ArrayList<DataNameSon> dataNameSon;
    ArrayList<DataNameSon> dataNameSonList;

    EditText edtSearchnamedauter;
    NameSonAdapter adapter;

    DatabaseHelper databaseHelper;

    @Override
    protected int getLayoutId() {
        return R.layout.frag_namedaughter;
    }

    @Override
    public String getTitle() {
        return "Con gái";
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();

    }

    private void initView() {
        dataNameSon = new ArrayList<>();
        databaseHelper = new DatabaseHelper(getContext());
        dataNameSonList = new ArrayList<>();// search list


        recyclerViewNameDauter = findViewById(R.id.recycler_listDauter);
        edtSearchnamedauter = findViewById(R.id.edtSearchnamedauter);


        dataNameSon = databaseHelper.getDauter();
        adapter = new NameSonAdapter(getContext());
        Log.d("log", "Dauter   " + dataNameSon.size());

        adapter.setDataNameSon(dataNameSon);
        recyclerViewNameDauter.setAdapter(adapter);
        recyclerViewNameDauter.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));

        edtSearchnamedauter.addTextChangedListener(new TextWatcher() { // Search Lits
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
                adapter.setDataNameSon(dataNameSonList);
            }
        });

    }
}
