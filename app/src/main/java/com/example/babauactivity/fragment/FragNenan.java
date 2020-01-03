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
import com.example.babauactivity.adapter.HoatdongAdapter;
import com.example.babauactivity.model.DataHoatdong;
import com.example.babauactivity.model.DataShop;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragNenan extends Fragment {
    RecyclerView recycler_listhoatdong;
    ArrayList<DataHoatdong> dataHoatdongs;
    HoatdongAdapter hoatdongAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_nenan, container, false);

        recycler_listhoatdong = view.findViewById(R.id.recycler_listhoatdong);
        dataHoatdongs = new ArrayList<>();
        for (int i = 0; i <20 ; i++) {
            dataHoatdongs.add(new DataHoatdong(R.drawable.mushroom,"Ăn chay","Có thể" ,"Có thể nhưng mẹ bầu nên điều chỉnh thói quen ăn chay cho phù hợp"));
        }
//        Log.e("hoat dong", "onCreateView:hoat dong "+dataHoatdongs.size() );
//        dataHoatdongs.add(new DataHoatdong(R.drawable.mushroom,"Ăn chay","Có thể","Có thể nhưng mẹ bầu nên điều chỉnh thói quen ăn chay cho phù hợp"));
//        dataHoatdongs.add(new DataHoatdong(R.drawable.swimmer,"Bơi lội","Nên cân nhắc","Nên nhưng chú ý vận động nhẹ nhàng vừa phải"));
//        dataHoatdongs.add(new DataHoatdong(R.drawable.face_mask,"Đắp mặt nạ","Có thể",null));
//        dataHoatdongs.add(new DataHoatdong(R.drawable.sign,"Đến spa","Nên cân nhắc","Mẹ nên cân nhắc, có thể không tốt cho sức khỏe"));
//        dataHoatdongs.add(new DataHoatdong(R.drawable.walking_dog,"Đi bộ","Có thể","Nên nhưng chú ý vận động nhẹ nhàng từ từ"));
//        dataHoatdongs.add(new DataHoatdong(R.drawable.hiking,"Đi bộ","Có thể","Có thể nhưng hạn chế đi quá xa"));
//        dataHoatdongs.add(new DataHoatdong(R.drawable.pedestrian,"Đi bộ","Chú ý",null));
//        dataHoatdongs.add(new DataHoatdong(R.drawable.massage,"Đi Massage","Có thể","Nên nhưng tùy thời điểm thai kì"));
//        dataHoatdongs.add(new DataHoatdong(R.drawable.jet,"Đi máy bay","Chú ý","Thai phụ 3 tháng đầu, 3 tháng cuối không nên đi lại bằng máy bay"));
//        dataHoatdongs.add(new DataHoatdong(R.drawable.toy,"Đi Tàu xe","Chú ý","Mẹ nên cẩn thận để đảm bảo an toàn cho bé nhé"));

        hoatdongAdapter = new HoatdongAdapter(getContext(), dataHoatdongs);
        recycler_listhoatdong.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));

        recycler_listhoatdong.setAdapter(hoatdongAdapter);



        return view;
    }
}
