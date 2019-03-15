package com.github.Andryyr.task4.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import lombok.val;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Liked_Photos";
    public static final String TABLE_NAME = "Photos_table";
    public static final String Column1 = "ID";
    public static final String Column2 = "Description";
    public static final String Column3 = "Link";
    public static final String LOG_TAG = DatabaseHelper.class.getSimpleName();
    private static DatabaseHelper DBInstance;

    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public static synchronized DatabaseHelper getInstance(Context context) {
        if (DBInstance == null) {
            DBInstance = new DatabaseHelper(context);
        }
        return DBInstance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, Description TEXT, Link TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public int contains(String argument) {
        SQLiteDatabase data = this.getWritableDatabase();
        val answer = data.rawQuery("SELECT " + Column2 + " FROM " + TABLE_NAME + "", null);

        int pos = 0;
        while (answer.moveToNext()) {
            if (answer.getString(0).equals(argument)) {
                return pos;
            }
            ++pos;
        }
        return -1;
    }

    public Cursor getAllData() {
        SQLiteDatabase data = this.getWritableDatabase();
        return data.rawQuery("SELECT * FROM " + TABLE_NAME + "", null);
    }

    public boolean addToTable(String description, String link) {
        SQLiteDatabase data = this.getWritableDatabase();

        if (contains(description) == -1) {
            ContentValues cv = new ContentValues();
            cv.put(Column2, description);
            cv.put(Column3, link);
            val result = data.insert(TABLE_NAME, null, cv);
            if (result == -1) {
                Log.d(LOG_TAG, "It didn't added");
                return false;
            } else {
                return true;
            }
        }
        return false;
    }


    public boolean deleteFromTable(String argument) {
        int position = contains(argument);
        if (position != -1) {
            SQLiteDatabase data = this.getWritableDatabase();
            Log.d(LOG_TAG, "delete from " + TABLE_NAME + " where " + Column2 + "=\'" + argument + "\'");
            data.execSQL("delete from " + TABLE_NAME + " where " + Column2 + "=\'" + argument + "\'");
            return (contains(argument) == -1);
        }
        return false;
    }
}
