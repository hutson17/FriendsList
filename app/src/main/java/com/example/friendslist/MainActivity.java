package com.example.friendslist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    public Adapter mAdapter;
    public static final int FriendLoad = 0;

    EditText fName, eMail, lName;
    Button add;
    TextView loginLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        //ContentValues cv = new ContentValues();
        //cv.put(table.FNAME, enteredName);
       // cv.put(table.EMAIL, entFnameeredEmail);
       // v.put(table.LNAME, Lname);


    }


}