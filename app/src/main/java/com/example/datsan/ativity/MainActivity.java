package com.example.datsan.ativity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.datsan.R;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_SCREEN = 10000;
    Animation topAnim,botAnim,in,out;
    ImageView lgo,load;
    TextView slo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        topAnim= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        botAnim= AnimationUtils.loadAnimation(this,R.anim.bot_animation);
        //ani1
        slo=findViewById(R.id.slogan);
        in=AnimationUtils.loadAnimation(this,R.anim.fadeout);
        slo.startAnimation(in);
        //ani2
        lgo=findViewById(R.id.logo);
        lgo.setAnimation(topAnim);
        load=findViewById(R.id.loading);
        load.setAnimation(botAnim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent= new  Intent(MainActivity.this, loginActivity.class);
//                Pair[] pairs= new Pair[2];
//                pairs[0]=new Pair<View,String>(lgo,"logo_image");
//                pairs[1]=new Pair<View,String>(slo,"slogan_text");
//                ActivityOptions options= ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);
//                startActivity(intent,options.toBundle());
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);
    }
}