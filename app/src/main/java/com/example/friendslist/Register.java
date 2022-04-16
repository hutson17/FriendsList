package com.example.friendslist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import android.widget.Toast;

public class Register extends AppCompatActivity {
    EditText fName, lName, eMail;
    Button add;
    TextView loginLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        init();
        methodListener();
    }

    private void init() {
        fName = (EditText) findViewById(R.id.fName);
        eMail = (EditText) findViewById(R.id.eMail);
        lName = (EditText) findViewById(R.id.lName);

        add = (Button) findViewById(R.id.add_btn);
    }

    private void methodListener() {
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFriend();
            }
        });
        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

    private void login() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }

    private void addFriend() {
        String FirstName = fName.getText().toString();
        String LastName = lName.getText().toString();
        String Email = eMail.getText().toString();

        //MySQLiteOpenHelper mySQl = new MySQLiteOpenHelper(this);
        //SQLiteDatabase db = mySQl.getWritableDatabase();

        ContentValues cv = new ContentValues();
        //cv.put(table.FNAME, fName);
        //cv.put(table.EMAIL, eMail);
        //cv.put(table.LNAME, lName);

        long l = 0;
        l = table.insert(db, cv);

        if(l > 0)
        {
            Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, Home.class);
                startActivity(i);
                finish();
        }
        else
        {
            Toast.makeText(this, "This Email has already been added", Toast.LENGTH_SHORT).show();

            db.close();

        }

    }

}

