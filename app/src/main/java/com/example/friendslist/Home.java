package com.example.friendslist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Selection;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;


public class Home extends AppCompatActivity {

    TextView fullNameTV, eMailTV;
    Button delete_btn, edit_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        init();
        methodListener();

    }
    private void init() {
        name = (TextView) findViewById(R.id.fullNameTV);
        email = (TextView) findViewById(R.id.eMailTV);

        MySQLiteOpenHelper mySQL = new MySQLiteOpenHelper(this);
        SQLiteDatabase db = mySQL.getReadableDatabase();

        Cursor cursor = table.select(db, Selection);

        if(cursor != null) {
            if (cursor.getCount() == 1) {
                String names = null, email, pass, mob = null;

                while (cursor.moveToNext()) {

                    names = cursor.getString(1);
                    email = cursor.getString(2);

                    Log.d("abc", "Login:" + id + names + email + pass + mob);
                }
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(this, Home.class);

                i.putExtra("name", names);
                i.putExtra("mobile", mob);

                startActivity(i);
            }
        }
    }

    private void methodListener() {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login();        )
    }



}