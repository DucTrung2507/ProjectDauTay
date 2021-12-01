package com.example.datsan.ativity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.datsan.R;
import com.google.android.material.textfield.TextInputLayout;

public class detailActivity extends AppCompatActivity {
    String name,descrip;
    TextView pitchesName,pitchesDescription;
    ImageView mainImage;
    int myImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_detail);
        mainImage=findViewById(R.id.imageView2);
        pitchesName=findViewById(R.id.textView3);
        pitchesDescription=findViewById(R.id.textView5);
        getData();
        setData();
        //
        Button time1=findViewById(R.id.time1mor);
        time1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBookSure(Gravity.CENTER);
            }
        });
    }
    private void getData(){
        if(getIntent().hasExtra("myImage") && getIntent().hasExtra("data1")&& getIntent().hasExtra("data2")){
            name=getIntent().getStringExtra("data1");
            descrip=getIntent().getStringExtra("data2");
            myImage=getIntent().getIntExtra("myImage",1);
        }
        else
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
    }
    private void setData(){
        pitchesName.setText(name);
        pitchesDescription.setText(descrip);
        mainImage.setImageResource(myImage);
    }
    //book
    private  void openBookSure(int gravity)
    {
        final Dialog dialog=new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.booking_sure_layout);
        Window window=dialog.getWindow();
        if (window==null)
        {
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams windowAttributes= window.getAttributes();
        windowAttributes.gravity=gravity;
        window.setAttributes(windowAttributes);
        if(Gravity.CENTER==gravity)
        {
            dialog.setCancelable(true);
        }


        Button yesButton=dialog.findViewById(R.id.confirmBooking_yes);
        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Successful", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        Button noButton=dialog.findViewById(R.id.confirmBooking_no);
        noButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}