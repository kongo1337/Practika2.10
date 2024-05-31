package com.mirea.kt.ribo.datastorageapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DoctorActivity extends AppCompatActivity {

    private DBManager dbManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);
    }
    @Override
    protected  void onResume(){
        super.onResume();
        this.dbManager = new DBManager(new MyAppSQLiteHelper(this,"my_database.db", null,1));
        ArrayList<Doctor> doctors = dbManager.loadAllPersonsFromDatabase();
        RecyclerView rcView = findViewById(R.id.recyclerView);
        DoctorAdapter adapter = new DoctorAdapter(doctors);
        rcView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false ));
        rcView.setAdapter(adapter);
    }


}