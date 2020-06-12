package com.SE1310T5Pro.bookreaderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;

import com.jaeger.library.StatusBarUtil;

public class MainActivity extends AppCompatActivity {
    private int timespeed = 3000;
    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        StatusBarUtil.setTranslucent(this, 55);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
                Intent intent_home = new Intent(MainActivity.this, HomepageActivity.class);
                startActivity(intent_home);

            }
        }, timespeed);
    }
}
