package com.thesis.adhdplannerandroidapp.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbManager extends SQLiteOpenHelper {

    public DbManager(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table user (" +
                "id TEXT primary key, name TEXT, email TEXT, " +
                "password TEXT, phone_number TEXT, premium PREMIUM foreign key, confimed_email BOOLEAN)");
        sqLiteDatabase.execSQL("create table premium(" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
