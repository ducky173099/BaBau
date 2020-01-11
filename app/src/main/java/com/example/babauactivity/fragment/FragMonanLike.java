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
import com.example.babauactivity.database.DatabaseHelper;
import com.example.babauactivity.model.DataCooking;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragMonanLike extends Fragment implements View.OnClickListener {
    ArrayList<DataCooking> dataCookings;
    ArrayList<DataCooking> dataSearch;
    DatabaseHelper databaseHelper;

    CookingAdapter cookingAdapter;
    RecyclerView recycler_listmonanlike;

    EditText edtsearch_cookinglike;

    ImageView delmonanlike;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_monanlike, container, false);

        delmonanlike = view.findViewById(R.id.delmonanlike);
        recycler_listmonanlike = view.findViewById(R.id.recycler_listmonanlike);
        edtsearch_cookinglike = view.findViewById(R.id.edtsearch_cookinglike);

        dataCookings = new ArrayList<>();
        dataSearch = new ArrayList<>();

        cookingAdapter = new CookingAdapter(getContext());
        databaseHelper = new DatabaseHelper(getContext());

        dataCookings = databaseHelper.getCookLike();
        cookingAdapter.setDataCookings(dataCookings);

        recycler_listmonanlike.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        recycler_listmonanlike.setAdapter(cookingAdapter);

        edtsearch_cookinglike.addTextChangedListener(new TextWatcher() { // Search Lits
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

        delmonanlike.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        edtsearch_cookinglike.getText().clear();
    }
}
