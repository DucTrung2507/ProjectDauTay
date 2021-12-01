package com.example.datsan.ativity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.datsan.DBHelper;
import com.example.datsan.R;

public class homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //button newspaper
        Button goNewspaper=findViewById(R.id.buttonnewspaper);
        goNewspaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(homepage.this, newspaperActivity.class);
                startActivity(intent);
            }
        });
        //button booking
        Button goBooking=findViewById(R.id.buttonbooking);
        goBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(homepage.this, bookingActivity.class);
                startActivity(intent);
            }
        });
        Button goHistory=findViewById(R.id.buttonhistory);
        goHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(homepage.this,historyActivity.class);
                startActivity(intent);
            }
        });
        Button goUser=findViewById(R.id.buttonuser);
        goUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(homepage.this,userActivity.class);
                String userNameForUser=getIntent().getStringExtra("username");
                intent.putExtra("usernameforuser",userNameForUser);
                startActivity(intent);

            }
        });
        Button lognOut=findViewById(R.id.buttonlognout);
        lognOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //
        String username=getIntent().getStringExtra("namelg");
        DBHelper DB;
        TextView usernamelg=findViewById(R.id.namelg);
        DB=new DBHelper(this);
        Cursor cs=DB.getData(username);
        while (cs.moveToNext())
        {
            usernamelg.setText(cs.getString(0));
        }
        // get name from sign up
    }
}