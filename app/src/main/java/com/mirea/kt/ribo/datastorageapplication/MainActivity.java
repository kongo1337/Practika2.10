package com.mirea.kt.ribo.datastorageapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

/* Создано Быстровым К.В. РИБО-03-22*/

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextFirstName, editTextLastName, editTextSpecialization;
    private SwitchCompat switchCertification;
    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.dbManager = new DBManager(new MyAppSQLiteHelper(this, "my_database.db", null,1));
        setContentView(R.layout.activity_main);
        editTextFirstName = findViewById(R.id.etFirstName);
        editTextLastName = findViewById(R.id.etLastName);
        editTextSpecialization = findViewById(R.id.etSpecialization);
        switchCertification = findViewById(R.id.etCertification);
        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnNext = findViewById(R.id.btnNext);
        btnAdd.setOnClickListener(this);
        btnNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnAdd){
            if(this.dbManager != null) {
                String fName = editTextFirstName.getText().toString();
                String lName = editTextLastName.getText().toString();
                String spec = editTextSpecialization.getText().toString();
                boolean cert = switchCertification.isChecked();
                if(!fName.isEmpty() && !lName.isEmpty() && !spec.isEmpty()){
                    boolean result = dbManager.savePersonToDatabase(new Doctor(fName,lName, spec, cert));
                    if(result){
                        Toast.makeText(this,R.string.insert_success, Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(this,R.string.insert_error,Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(this,R.string.incorrect_value, Toast.LENGTH_LONG).show();
                }
            }
        }else if(v.getId() == R.id.btnNext){
            startActivity(new Intent(this, DoctorActivity.class));
        }

    }
}