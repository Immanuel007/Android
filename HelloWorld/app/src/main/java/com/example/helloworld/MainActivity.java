package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onButtonClick(View view){
        TextView textView = findViewById(R.id.text);

        textView.setText("Hello, Immanuel");

        EditText nameEditText = findViewById(R.id.nameEditText);

        textView.setText("Hello, " + nameEditText.getText().toString());
    }
}
