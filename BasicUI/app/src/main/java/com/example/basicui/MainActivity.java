package com.example.basicui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.txtHello);
        textView.setText("Hello Android Users");
    }


    public void onBtnClick(View view){
        TextView textView = (TextView) findViewById(R.id.txtHello);
        textView.setVisibility(View.VISIBLE);
    }
}
