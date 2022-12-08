package com.thesis.adhdplannerandroidapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.thesis.adhdplannerandroidapp.model.User;

public class DbManager extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DATABASE_NAME = "adhd_app.db";

    public DbManager(Context context) {
        super(context, DATABASE_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table card (" +
                "id TEXT primary key autoincrement, sum_of_points INTEGER, include_premium BOOLEAN)");

        sqLiteDatabase.execSQL("create table user (" +
                "id TEXT primary key autoincrement, name TEXT, email TEXT, " +
                "password TEXT, phone_number TEXT, " +
                "confirmed_email BOOLEAN)");

        sqLiteDatabase.execSQL("create table premium (" +
                "id TEXT primary key autoincrement, user_id TEXT, premium_on BOOLEAN, " +
                "adds_off BOOLEAN, effective_start DATE, effective_end DATE)");

        sqLiteDatabase.execSQL("create table event (" +
                "id TEXT primary key autoincrement, " +
                "name TEXT, email_notification BOOLEAN, phone_notification BOOLEAN, " +
                "sms_notification BOOLEAN, executed BOOLEAN, user_id TEXT, card_id TEXT," +
                "foreign key(user_id) references user(id)," +
                "foreign key(card_id) references card(id))");

        sqLiteDatabase.execSQL("create table daily_plan (" +
                "id TEXT primary key autoincrement, " +
                "name TEXT, type TEXT, description TEXT, " +
                "event_id TEXT, event_id TEXT, effective_start DATE, effective_end DATE," +
                "foreign key(event_id) references event(id))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public Boolean addNewUser(String name, String email, String password, String phoneNumber){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put("name", name);
        cv.put("email", email);
        cv.put("password", password);
        cv.put("phone_number", phoneNumber);
        cv.put("confirmed_email", false);

        long res = db.insert("user", null, cv);

        return res != -1;
    }

    public Boolean checkUsername(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user where name=?", new String[] {name});
        return cursor.getCount() > 0;
    }


    public Boolean checkEmail(String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user where email=? " +
                "and password=?", new String[] {email});
        return cursor.getCount() > 0;
    }

    public Boolean checkUsernameAndPassword(String name, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user where name=? " +
                        "and password=?", new String[] {name, password});
        return cursor.getCount() > 0;
    }
}
