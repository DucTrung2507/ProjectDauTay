package com.example.datsan;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datsan.ativity.detailActivity;

public class Q1Adapter extends RecyclerView.Adapter<Q1Adapter.MyViewHolder> {
    String data1[],data2[];
    int images[];
    Context context;
    public  Q1Adapter(Context ct, String s1[],String s2[],int img[]){
        data1=s1;
        data2=s2;
        images=img;
        context=ct;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.fragment_my_list,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
    holder.myText1.setText(data1[position]);
    holder.myText2.setText(data2[position]);
    holder.myImage.setImageResource(images[position]);
    holder.iteamLayout.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent=new Intent(context, detailActivity.class);
            intent.putExtra("data1",data1[position]);
            intent.putExtra("data2",data2[position]);
            intent.putExtra("myImage",images[position]);
            context.startActivity(intent);
        }
    });
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView myText1,myText2;
        ImageView myImage;
        ConstraintLayout iteamLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myText1=itemView.findViewById(R.id.pitchesname);
            myText2=itemView.findViewById(R.id.pitcheslocate);
            myImage=itemView.findViewById(R.id.imagepitches);
            iteamLayout=itemView.findViewById(R.id.iteamLayout);
        }
    }
}
