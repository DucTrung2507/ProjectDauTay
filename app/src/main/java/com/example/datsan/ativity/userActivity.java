package com.example.datsan.ativity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
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

import com.example.datsan.DBHelper;
import com.example.datsan.R;
import com.google.android.material.textfield.TextInputLayout;

public class userActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ImageView userBack =findViewById(R.id.userbackbutton);
        userBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        //username
        String username=getIntent().getStringExtra("usernameforuser");
        TextView usname=findViewById(R.id.usNameUser);
        usname.setText(username);
        // name of user
        DBHelper DB;
        TextView nameOUser=findViewById(R.id.nameOfUser);
        TextView passOUser=findViewById(R.id.passwordUser);
        TextView phoneOUser=findViewById(R.id.phoneUser);
        DB=new DBHelper(this);
        Cursor cs=DB.getData(username);
        while (cs.moveToNext())
        {
            nameOUser.setText(cs.getString(0));
            passOUser.setText(cs.getString(1));
            phoneOUser.setText(cs.getString(2));
        }
        TextView changePass=findViewById(R.id.changePass);
        changePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {openChangePassword(Gravity.CENTER);
            }
        });
    }
    private  void openChangePassword(int gravity)
    {
        final Dialog dialog=new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.chang_pass_layout);
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


        TextInputLayout pass,newPass,conNewPass;
        pass=dialog.findViewById(R.id.password);
        newPass=dialog.findViewById(R.id.newPassword);
        conNewPass=dialog.findViewById(R.id.conNewPassword);
        Button confirmButton=dialog.findViewById(R.id.confirmButton);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}