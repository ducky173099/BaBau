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
import com.example.babauactivity.adapter.ShopAdapter;
import com.example.babauactivity.database.DatabaseHelper;
import com.example.babauactivity.model.DataShop;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragChobe extends Fragment implements View.OnClickListener {
    RecyclerView recycler_listchobe;
    ArrayList<DataShop> dataShops;
    ArrayList<DataShop> dataSearch;
    ShopAdapter shopAdapter;

    EditText edtsearch_chobe;
    DatabaseHelper databaseHelper;

    ImageView delchobe;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_chobe, container, false);

        delchobe = view.findViewById(R.id.delchobe);
        edtsearch_chobe = view.findViewById(R.id.edtsearch_chobe);
        dataSearch = new ArrayList<>();
        dataShops = new ArrayList<>();

        shopAdapter = new ShopAdapter(getContext());

        recycler_listchobe = view.findViewById(R.id.recycler_listchobe);
        databaseHelper = new DatabaseHelper(getContext());

        dataShops = databaseHelper.getShopbaby();
        shopAdapter.setDataShops(dataShops);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recycler_listchobe.setLayoutManager(layoutManager);

        recycler_listchobe.setAdapter(shopAdapter);

        edtsearch_chobe.addTextChangedListener(new TextWatcher() { // Search Lits
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
                Log.e("TAG","CHECK DATA SIZE:"+dataShops.size());
                for (DataShop data: dataShops){
                    if (data.getDesc().toUpperCase().contains(text.toUpperCase())){
                        Log.e("TAG","CHECK DATA add:");
                        dataSearch.add(data);
                    }
                }
                Log.e("TAG","CHECK:"+dataSearch.size());
                shopAdapter.setDataShops(dataSearch);
            }
        });

        delchobe.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        edtsearch_chobe.getText().clear();
    }
}
