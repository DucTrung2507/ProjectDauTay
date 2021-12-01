package com.example.datsan.ativity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.datsan.DBHelper;
import com.example.datsan.R;
import com.google.android.material.textfield.TextInputLayout;

public class SignupActivity extends AppCompatActivity {
    Button gobacklogin,finish;
    Animation fadeinsignup;
    LinearLayout formsignup;
    TextInputLayout usname,pass,repass,phoneNumber,nameCs;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_signup);
        formsignup=findViewById(R.id.signupform);
        fadeinsignup= AnimationUtils.loadAnimation(this,R.anim.fadein);
        fadeinsignup.setDuration(3000);
        formsignup.startAnimation(fadeinsignup);
        gobacklogin=findViewById(R.id.buttongobacklogin);
        gobacklogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        //db
        DB=new DBHelper(this);
        usname=findViewById(R.id.usernamesu);
        pass=findViewById(R.id.passwordsu);
        repass=findViewById(R.id.repasswordsu);
        finish=findViewById(R.id.finishsignup);
        phoneNumber=findViewById(R.id.phone);
        nameCs=findViewById(R.id.name);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String user = usname.getEditText().getText().toString();
            String passw=pass.getEditText().getText().toString();
            String repassw=repass.getEditText().getText().toString();
            String phone=phoneNumber.getEditText().getText().toString();
            String name=nameCs.getEditText().getText().toString();
            if(user.equals("")||passw.equals("")||repassw.equals(""))
            {
                usname.setError("Username cannot be null ");
                pass.setError("Password required");
                repass.setError("Password required");
                phoneNumber.setError("Phone required");
                nameCs.setError("Your name required");
            }
            else if(user.length() > 15|| passw.length()<5)
            {
                usname.setError("No more 15");
                phoneNumber.setError("No more 10");
                pass.setError("Too short");
            }
            else
                {
                    if (passw.equals(repassw))
                    {
                        Boolean checkuser=DB.checkusername(user);
                        if (checkuser==false)
                        {
                            Boolean insert = DB.inserData(user,passw,phone,name);

                            if (insert==true)
                            {
                                Toast.makeText(SignupActivity.this, "Successful, let's login", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getApplicationContext(),loginActivity.class);
                                startActivity(intent);
                            }
                            else
                                Toast.makeText(SignupActivity.this, "Failled", Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(SignupActivity.this, "The account have exist", Toast.LENGTH_SHORT).show();
                    }
                    else
                       repass.setError("Not matching");

                }
            }
        });
        //check
    }
}