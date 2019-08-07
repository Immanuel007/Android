package com.example.safeboda;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
EditText fname,lname;
Button saveBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fname=findViewById(R.id.FirstName);
        lname=findViewById(R.id.LastName);
        saveBtn=findViewById(R.id.btngoogle);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstname = fname.getText().toString();
                String lastname = lname.getText().toString();

                //check if user entered data

                if(firstname.isEmpty()){
                    Toast.makeText(MainActivity.this, "Firstname is required", Toast.LENGTH_SHORT).show();
                }else if(lastname.isEmpty()){
                    Toast.makeText(MainActivity.this, "Lastname is required" , Toast.LENGTH_SHORT).show();
                }else{
                    Intent nextpage =new Intent(MainActivity.this,SecondActivity.class);
                    nextpage.putExtra("fname",firstname);
                    nextpage.putExtra("lname",lastname);
                    startActivity(nextpage);

                }
            }
        });

        //grabbing the textview in the xml file
        // intent-object that allows one to move from one  activity to another

      /*  TextView endaAct2 = (TextView) findViewById(R.id.textviewhome);
        //create/set a listener for the click on view
        endaAct2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent twendeSecondActivity = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(twendeSecondActivity);
            }
        });*/

    }
}
