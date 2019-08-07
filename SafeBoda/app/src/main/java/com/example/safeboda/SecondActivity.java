package com.example.safeboda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView myFname, myLname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        myFname = findViewById(R.id.fnameid);
        myLname = findViewById(R.id.lnameid);

        Intent intent = getIntent();

        String nameone = intent.getStringExtra("fname");
        String nametwo = intent.getStringExtra("lname");

        myFname.setText(nameone);
        myLname.setText(nametwo);
    }
}
