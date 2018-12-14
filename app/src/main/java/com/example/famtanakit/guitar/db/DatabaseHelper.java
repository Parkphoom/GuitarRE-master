package com.example.famtanakit.guitar.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "chord.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "chord";
    public static final String COL_ID = "_id";
    public static final String COL_TITLE = "chord_name";
    public static final String COL_NUMBER = "key_chord";
    public static final String COL_IMAGE = "image";

    private static final String SQL_CREATE_TABLE_PHONE
            = "CREATE TABLE " + TABLE_NAME + "("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COL_TITLE + " TEXT,"
            + COL_NUMBER + " TEXT,"
            + COL_IMAGE + " TEXT"
            + ")";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_PHONE);

        ContentValues cv = new ContentValues();
        cv.put(COL_TITLE, "Chord");
        cv.put(COL_NUMBER, "C");
        cv.put(COL_IMAGE, "c.png");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_TITLE, "Chord");
        cv.put(COL_NUMBER, "C#");
        cv.put(COL_IMAGE, "c#.png");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_TITLE, "Chord");
        cv.put(COL_NUMBER, "D");
        cv.put(COL_IMAGE, "d.png");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_TITLE, "Chord");
        cv.put(COL_NUMBER, "Eb");
        cv.put(COL_IMAGE, "eb.png");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_TITLE, "Chord");
        cv.put(COL_NUMBER, "E");
        cv.put(COL_IMAGE, "e.png");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_TITLE, "Chord");
        cv.put(COL_NUMBER, "F");
        cv.put(COL_IMAGE, "f.png");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_TITLE, "Chord");
        cv.put(COL_NUMBER, "F#");
        cv.put(COL_IMAGE, "f#.png");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_TITLE, "Chord");
        cv.put(COL_NUMBER, "G");
        cv.put(COL_IMAGE, "g.png");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_TITLE, "Chord");
        cv.put(COL_NUMBER, "Ab");
        cv.put(COL_IMAGE, "ab.png");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_TITLE, "Chord");
        cv.put(COL_NUMBER, "A");
        cv.put(COL_IMAGE, "a.png");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_TITLE, "Chord");
        cv.put(COL_NUMBER, "Bb");
        cv.put(COL_IMAGE, "bb.png");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_TITLE, "Chord");
        cv.put(COL_NUMBER, "B");
        cv.put(COL_IMAGE, "b.png");
        db.insert(TABLE_NAME, null, cv);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
