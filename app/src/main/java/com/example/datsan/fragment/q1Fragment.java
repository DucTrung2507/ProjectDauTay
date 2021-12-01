package com.example.datsan.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.datsan.Q1Adapter;
import com.example.datsan.R;

public class q1Fragment extends Fragment {
    private String name[],locate[];
    RecyclerView listq1;
    private int images[]={R.drawable.santaodan,R.drawable.sandaihocyduoc,R.drawable.sanbongnvh,R.drawable.sanhoangphu,R.drawable.sanhoalu,R.drawable.sannguyendu};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view  = inflater.inflate(R.layout.fragment_q1, container, false);
        listq1=view.findViewById(R.id.q1list);
        name=getResources().getStringArray(R.array.q1name);
        locate=getResources().getStringArray(R.array.q1locate);
        Q1Adapter listQ1Adapter=new Q1Adapter(getContext(),name,locate,images);
        listq1.setAdapter(listQ1Adapter);
        listq1.setLayoutManager(new LinearLayoutManager(view.getContext()));
        return view ;

    }
}