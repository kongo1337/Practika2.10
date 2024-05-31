package com.mirea.kt.ribo.datastorageapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyAppSQLiteHelper extends SQLiteOpenHelper {

    private static final String TABLE_NAME = "TABLE_DOCTORS";

    public MyAppSQLiteHelper(Context c, String name,
                             SQLiteDatabase.CursorFactory f, int version) {
        super(c, name, f, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + "TABLE_DOCTORS" + " ("
                + "_id integer primary key autoincrement,"
                + "first_name text,"
                + "last_name text,"
                + "specialization text,"
                + "certification integer" + ");");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        // если версия изменилаcь, то вносим нужные нам изменения
    }


}
