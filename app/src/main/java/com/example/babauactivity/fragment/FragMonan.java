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
import com.example.babauactivity.adapter.CookingAdapter;
import com.example.babauactivity.adapter.NicknameAdapter;
import com.example.babauactivity.adapter.ShopAdapter;
import com.example.babauactivity.database.DatabaseHelper;
import com.example.babauactivity.model.DataCooking;
import com.example.babauactivity.model.DataNickName;
import com.example.babauactivity.model.DataShop;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragMonan extends Fragment implements View.OnClickListener {
    RecyclerView recycler_listmonan;
    ArrayList<DataCooking> dataCookings;
    ArrayList<DataCooking> dataSearch;
    CookingAdapter cookingAdapter;

    DatabaseHelper databaseHelper;

    EditText edtsearch_monan;
    ImageView delmonan;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_monan, container, false);

        delmonan = view.findViewById(R.id.delmonan);
        edtsearch_monan = view.findViewById(R.id.edtsearch_monan);
        dataSearch = new ArrayList<>();
        dataCookings = new ArrayList<>();

        cookingAdapter = new CookingAdapter(getContext());

        recycler_listmonan = view.findViewById(R.id.recycler_listmonan);
        databaseHelper = new DatabaseHelper(getContext());

        dataCookings = databaseHelper.getCooking();
        cookingAdapter.setDataCookings(dataCookings);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recycler_listmonan.setLayoutManager(layoutManager);

        recycler_listmonan.setAdapter(cookingAdapter);

        edtsearch_monan.addTextChangedListener(new TextWatcher() { // Search Lits
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
                Log.e("TAG","CHECK DATA SIZE:"+dataCookings.size());
                for (DataCooking data: dataCookings){
                    if (data.getDescCook().toUpperCase().contains(text.toUpperCase())){
                        Log.e("TAG","CHECK DATA add:");
                        dataSearch.add(data);
                    }
                }
                Log.e("TAG","CHECK:"+dataSearch.size());
                cookingAdapter.setDataCookings(dataSearch);
            }
        });

        delmonan.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        edtsearch_monan.getText().clear();
    }
}
