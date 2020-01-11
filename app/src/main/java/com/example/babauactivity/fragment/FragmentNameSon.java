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

public class FragmentNameSon extends BaseFragment<MainActivity> implements NameSonAdapter.ItemClick, View.OnClickListener {
    RecyclerView recyclerViewNameson;

    ArrayList<DataNameSon> dataNameSon;
    ArrayList<DataNameSon> dataNameSonList;

    EditText edtSearchList;

    NameSonAdapter adapter;
    DatabaseHelper databaseHelper;

    ImageView delnameson;

    @Override
    protected int getLayoutId() {
        return R.layout.frag_nameson;
    }

    @Override
    public String getTitle() {
        return "Con trai";
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        dataNameSon = new ArrayList<>();
        dataNameSonList = new ArrayList<>();// search list

        delnameson = findViewById(R.id.delnameson);
        recyclerViewNameson =findViewById(R.id.recycler_listson);
        edtSearchList = findViewById(R.id.edtSearchList);

        databaseHelper = new DatabaseHelper(getContext());
        dataNameSon = databaseHelper.getAll();
        for (int i = 0; i <dataNameSon.size() ; i++) {
            Log.d("Son", "initView son: " + dataNameSon.get(i).getSex());

        }
        adapter = new NameSonAdapter(getContext());
        recyclerViewNameson.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));

        recyclerViewNameson.setAdapter(adapter);

        adapter.setDataNameSon(dataNameSon);

        adapter.setClickYnghia(this);

        edtSearchList.addTextChangedListener(new TextWatcher() { // Search Lits
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
                Log.e("search", "After TextChanged: " );

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
                adapter.notifyDataSetChanged();
            }
        });

        delnameson.setOnClickListener(this);

    }

    @Override
    public void ClickYnghia(int position) {

    }

    @Override
    public void onClick(View view) {
        edtSearchList.getText().clear();
    }
}
