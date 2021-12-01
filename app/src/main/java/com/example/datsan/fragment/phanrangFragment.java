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

public class phanrangFragment extends Fragment {
    private String name[],locate[];
    RecyclerView listPR;
    private int images[]={R.drawable.santandinh,R.drawable.sanphuongnam,R.drawable.sanmuongcat,R.drawable.sanhoasen,R.drawable.sanhoanmy,R.drawable.sanhuuthanh};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_phanrang, container, false);
        listPR=view.findViewById(R.id.prlist);
        name=getResources().getStringArray(R.array.prname);
        locate=getResources().getStringArray(R.array.prlocate);
        Q1Adapter listPRAdapter=new Q1Adapter(getContext(),name,locate,images);
        listPR.setAdapter(listPRAdapter);
        listPR.setLayoutManager(new LinearLayoutManager(view.getContext()));
        return view ;
    }
}