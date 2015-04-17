package com.kevinveldkamp.ceasarcalc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kevinveldkamp on 4/17/15.
 */
public class DatabaseHandler extends SQLiteOpenHelper{


    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "numeralValues",
            TABLE_NUMERALS = "numerals",
            KEY_ID = "id",
            KEY_NUMERAL = "numeral";

    public DatabaseHandler(Context context){

        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE " + TABLE_NUMERALS + "( "+ KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NUMERAL + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NUMERALS);

        onCreate(db);
    }

    public void createNumeral(String numeral){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_NUMERAL,numeral);

        db.insert(TABLE_NUMERALS,null,values);
        db.close();

    }

    public String getNumeral(int id){
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(TABLE_NUMERALS, new String[] {KEY_ID,KEY_NUMERAL},KEY_ID+"?",new String[] {String.valueOf(id) },null,null,null,null);

        if(cursor != null){
            cursor.moveToFirst();
        }
        String numeral = cursor.getString(1);
        return numeral;

    }






}
