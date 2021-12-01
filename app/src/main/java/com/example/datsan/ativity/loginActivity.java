package com.example.datsan.ativity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.datsan.DBHelper;
import com.example.datsan.R;
import com.google.android.material.textfield.TextInputLayout;

public class loginActivity extends AppCompatActivity {
    Button callSignup, callHome;
    Animation anilogin, anislo1, anislo2;
    LinearLayout formlogin;
    TextView slog1, slog2;
    TextInputLayout usname,passw;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        //button go Signup
        callSignup = findViewById(R.id.buttonsignup);
        callSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(loginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });
        //button go Home activity
        //ani1
        slog1 = findViewById(R.id.slo1);
        anislo1 = AnimationUtils.loadAnimation(this, R.anim.fadein);
        anislo1.setDuration(1300);
        slog1.startAnimation(anislo1);
        //ani2
        slog2 = findViewById(R.id.slo2);
        anislo2 = AnimationUtils.loadAnimation(this, R.anim.fadein);
        anislo2.setStartOffset(1300);
        slog2.startAnimation(anislo2);
        //ani3
        formlogin = findViewById(R.id.formlogin);
        anilogin = AnimationUtils.loadAnimation(this, R.anim.fadein);
        anilogin.setStartOffset(2600);
        formlogin.startAnimation(anilogin);
        //database
        DB=new DBHelper(this);
        usname= findViewById(R.id.usernamelg);
        passw= findViewById(R.id.passwordlg);
        callHome = findViewById(R.id.gohome);
        callHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user= usname.getEditText().getText().toString();
                String pass= passw.getEditText().getText().toString();
                if (user.equals("")||pass.equals("")) {
                    usname.setError("Username required");
                    passw.setError("Password required");
                }
                else
                    {
                        Boolean checkuserpass=DB.checkusernamepassword(user,pass);
                        if(checkuserpass==true)
                        {
                                Toast.makeText(loginActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(loginActivity.this, homepage.class);
                            intent.putExtra("namelg",user);
                            intent.putExtra("username",user);
                            startActivity(intent);
                        }
                        else
                            Toast.makeText(loginActivity.this, "Username or password are not correct, please try again ", Toast.LENGTH_SHORT).show();
                    }
            }
        });
        //button go test
    }
}
