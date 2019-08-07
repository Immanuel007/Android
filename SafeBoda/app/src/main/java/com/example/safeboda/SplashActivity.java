package com.example.safeboda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread moveit = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(3000);
                    Intent endaMain = new Intent(SplashActivity.this,MainActivity.class);
                    startActivity(endaMain);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        moveit.start();
    }
}
