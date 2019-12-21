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
import com.example.babauactivity.model.DataNameSon;
import com.example.babauactivity.model.DataShop;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragSK extends Fragment {
    RecyclerView recycler_listsk;
    ArrayList<DataShop> dataShops;
    ArrayList<DataShop> datasearch;
    ShopAdapter shopAdapter;

    EditText edtsearch_sk;
    DatabaseHelper databaseHelper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_sk, container, false);

        edtsearch_sk = view.findViewById(R.id.edtsearch_sk);
        datasearch = new ArrayList<>();
        recycler_listsk = view.findViewById(R.id.recycler_listsk);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recycler_listsk.setLayoutManager(layoutManager);

        shopAdapter = new ShopAdapter(getContext());

        dataShops = new ArrayList<>();
        databaseHelper = new DatabaseHelper(getContext());
        dataShops = databaseHelper.getShopsk();

        shopAdapter.setDataShops(dataShops);

        recycler_listsk.setAdapter(shopAdapter);

        edtsearch_sk.addTextChangedListener(new TextWatcher() { // Search Lits
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
