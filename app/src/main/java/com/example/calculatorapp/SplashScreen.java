package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class SplashScreen extends AppCompatActivity {
TextView appname;
LottieAnimationView lottie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        appname=findViewById(R.id.appname);
        lottie=findViewById(R.id.lottie);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

//        appname.animate().translationY(-1400).setDuration(2700).setStartDelay(0);
//        lottie.animate().translationX(2000).setDuration(2000).setStartDelay(2900);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        },5000);
    }
}