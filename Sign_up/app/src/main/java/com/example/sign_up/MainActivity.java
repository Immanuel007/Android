package com.example.sign_up;

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

    public void onRegisterBtnClick(View view){
        EditText firstname = findViewById(R.id.editTextFirstName);
        EditText lastname = findViewById(R.id.editTextLastName);
        EditText email = findViewById(R.id.editTextEmail);

        TextView txtFirstName = findViewById(R.id.textViewFirstName);
        TextView txtLastName = findViewById(R.id.textViewLastName);
        TextView txtEmail = findViewById(R.id.textViewEmail);

        txtFirstName.setText("First Name is: " + firstname.getText().toString());
        txtLastName.setText("Last Name is: " + lastname.getText().toString());
        txtEmail.setText("Email is: " + email.getText().toString());
    }
}
