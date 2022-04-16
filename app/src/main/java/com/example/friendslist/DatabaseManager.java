package com.example.friendslist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseManager extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "friendsDB";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_FRIENDS = "friends";
    private static final String ID = "id";
    private static final String FNAME = "fname";
    private static final String LNAME = "lname";
    private static final String EMAIL = "email";

    private ContentValues cValues;

    private SQLiteDatabase dataBase = null;

    private Cursor cursor;

    public DatabaseManager(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCreate = "create table " + TABLE_FRIENDS + "( " + ID;
        sqlCreate += "integer primary key autoincrement, " + FNAME;
        sqlCreate += "integer primary key autoincrement, " + LNAME;
        sqlCreate += "integer primary key autoincrement, " + EMAIL;

        db.execSQL(sqlCreate);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists " + TABLE_FRIENDS);

        onCreate(db);
    }

}
