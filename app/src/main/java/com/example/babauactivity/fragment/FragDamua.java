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
import com.example.babauactivity.adapter.ShopAdapter;
import com.example.babauactivity.database.DatabaseHelper;
import com.example.babauactivity.model.DataShop;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragDamua extends Fragment {
    RecyclerView recycler_listdamua;
    ArrayList<DataShop> dataShops;
    ArrayList<DataShop> datasearch;

    ShopAdapter shopAdapter;

    DatabaseHelper databaseHelper;
    EditText edtsearch_shopsuckhoe;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_damua, container, false);

        recycler_listdamua = view.findViewById(R.id.recycler_listdamua);
        edtsearch_shopsuckhoe = view.findViewById(R.id.edtsearch_shopsuckhoe);

        recycler_listdamua.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL, false));

        dataShops = new ArrayList<>();
        datasearch = new ArrayList<>();

        shopAdapter = new ShopAdapter(getContext());

        databaseHelper = new DatabaseHelper(getContext());

        dataShops = databaseHelper.getShopBuy();

        shopAdapter.setDataShops(dataShops);
        recycler_listdamua.setAdapter(shopAdapter);

        edtsearch_shopsuckhoe.addTextChangedListener(new TextWatcher() { // Search Lits
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
                Log.e("TAG","CHECK DATA SIZE:"+dataShops.size());
                for (DataShop data: dataShops){
                    if (data.getDesc().toUpperCase().contains(text.toUpperCase())){
                        Log.e("TAG","CHECK DATA add:");
                        datasearch.add(data);
                    }
                }
                Log.e("TAG","CHECK:"+datasearch.size());
                shopAdapter.setDataShops(datasearch);
            }
        });


        return view;
    }
}
