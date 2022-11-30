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
                "password TEXT, phone_number TEXT, " +
                "premium_id TEXT, " +
                "confirmed_email BOOLEAN," +
                "foreign key(premium_id) references premium(id))");

        sqLiteDatabase.execSQL("create table premium (" +
                "id TEXT primary key, user_id TEXT, premium_on BOOLEAN, " +
                "adds_off BOOLEAN, effective_start DATE, effective_end DATE)");

        sqLiteDatabase.execSQL("create table card (" +
                "id TEXT primary key, sum_of_points INTEGER, include_premium BOOLEAN)");

        sqLiteDatabase.execSQL("create table event (" +
                "id TEXT, name TEXT, email_notification BOOLEAN, phone_notification BOOLEAN, " +
                "sms_notification BOOLEAN, executed BOOLEAN, user_id TEXT, card_id TEXT)");

        sqLiteDatabase.execSQL("create table plan (" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
