package com.example.sportfieldsproj2;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query1="create table users(name text, email text, password text)";
        sqLiteDatabase.execSQL(query1);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    public void register(String name, String email, String password){
    ContentValues cv=new ContentValues();
    cv.put("name", name);
    cv.put("email", email);
    cv.put("password", password);
    SQLiteDatabase db =getWritableDatabase();
    db.insert("users", null, cv);
    db.close();

    }
    public int login(String name, String password) {
        int result = 0;
        String str[] = new String[2];
        str[0] = name;
        str[1] = password;
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("select * from users where name=? and password=?", str);
        if (c.moveToFirst()) {
            result = 1;
        }
        return result;
    }
    }

