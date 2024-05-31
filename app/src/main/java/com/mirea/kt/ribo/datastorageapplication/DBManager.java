package com.mirea.kt.ribo.datastorageapplication;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBManager {

    private SQLiteOpenHelper sqLiteHelper;
    private static final String TABLE_NAME = "TABLE_DOCTORS";

    public DBManager(SQLiteOpenHelper sqLiteHelper) {
        this.sqLiteHelper = sqLiteHelper;
    }

    public boolean savePersonToDatabase(Doctor doctor){
        SQLiteDatabase db = this.sqLiteHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("first_name", doctor.getFirstName());
        cv.put("last_name", doctor.getLastName());
        cv.put("specialization", doctor.getSpecialization());
        cv.put("certification", doctor.isCertified() ? 1 : 0);

        long rowId = db.insert("TABLE_DOCTORS", null, cv);
        cv.clear();
        db.close();
        return rowId != -1;
    }
    public ArrayList<Doctor> loadAllPersonsFromDatabase() {
        ArrayList<Doctor> doctors = new ArrayList<>();
        SQLiteDatabase db = this.sqLiteHelper.getWritableDatabase();
        Cursor dbCursor = db.query("TABLE_DOCTORS",
                null,null,null,null,null,null);
        if(dbCursor.moveToFirst()){
            do{
                String fName = dbCursor.getString(dbCursor.getColumnIndexOrThrow("first_name"));
                String lName = dbCursor.getString(dbCursor.getColumnIndexOrThrow("last_name"));
                String spec = dbCursor.getString(dbCursor.getColumnIndexOrThrow("specialization"));
                int certInt = dbCursor.getInt(dbCursor.getColumnIndexOrThrow("certification"));
                boolean cert = certInt == 1;
                doctors.add(new Doctor(fName,lName,spec,cert));
            }while (dbCursor.moveToNext());
        }
        dbCursor.close();
        db.close();
        return doctors;
    }
}
