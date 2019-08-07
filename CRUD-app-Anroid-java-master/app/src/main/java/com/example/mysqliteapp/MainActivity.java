package com.example.mysqliteapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText mName, mEmail, mID;
    Button mBtnSave, mBtnView, mBtnDelete;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mName = findViewById(R.id.edtName);
        mEmail = findViewById(R.id.edtMail);
        mID = findViewById(R.id.edtID);
        mBtnSave = findViewById(R.id.btnSave);
        mBtnView = findViewById(R.id.btnView);
        mBtnDelete = findViewById(R.id.btnDel);

        //Create the database
        db = openOrCreateDatabase("Users",MODE_PRIVATE,null);
        //Create a table in your db
        db.execSQL("CREATE TABLE IF NOT EXISTS majina(name VARCHAR, email VARCHAR, id_number VARCHAR)");

        //Proceed to save data after the user has clicked on the button save
        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Receive data input from the user
                String jina = mName.getText().toString();
                String arafa = mEmail.getText().toString();
                String kitambukisho = mID.getText().toString().trim();

                //Check if the user is submitting empty fields
                if (jina.isEmpty() || arafa.isEmpty() || kitambukisho.isEmpty() ){
//                    Toast.makeText(MainActivity.this, "Fill in all inputs", Toast.LENGTH_SHORT).show();
                    messages("EMPTY REFIELDS","Please fill all the inputs");
                }else {
                    //Proceed to save the data
                    db.execSQL("INSERT INTO majina VALUES('"+jina+"','"+arafa+"','"+kitambukisho+"')");
//                    Toast.makeText(MainActivity.this, "User Saved Successfully", Toast.LENGTH_SHORT).show();
                    messages("SUCCESS","User Save Successfully");
                    //Clear the input fields for the next entry
                    mName.setText("");
                    mEmail.setText("");
                    mID.setText("");
                }
            }
        });
        //Viewing
        mBtnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor = db.rawQuery("SELECT * FROM majina",null);

                //check if there is any records
                if (cursor.getCount()==0){
                    messages("NO RECORDS ","Sorry, No records found");
                }
                //use Buffer to append the records
                StringBuffer buffer = new StringBuffer();

                while (cursor.moveToNext()){
                    buffer.append("Name is:"+cursor.getString(0));
                    buffer.append("\n");
                    buffer.append("Email is:"+cursor.getString(1));
                    buffer.append("\n");
                    buffer.append("ID is:"+cursor.getString(2));
                    buffer.append("\n");
                }
                messages("DATABASE RECORDS ", buffer.toString());
            }
        });

        //Deleting
        mBtnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mID.getText().toString().trim().isEmpty()){
                    messages("Empty ID","Kindly type in an ID..");
                }
                Cursor cursor = db.rawQuery("SELECT * FROM majina WHERE id_number = '"+mID.getText().toString().trim()+"'", null);
                if (cursor.moveToFirst()){
                    db.execSQL("DELETE FROM majina WHERE id_number = '"+mID.getText().toString()+"'");

                    messages("DELETED","Record Deleted Succesfully");
                    mID.setText("");

                }            }
        });
    }


    public void messages(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.create().show();
    }
}
