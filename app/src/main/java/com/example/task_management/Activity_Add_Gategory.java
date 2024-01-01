package com.example.task_management;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Activity_Add_Gategory extends AppCompatActivity  {
    EditText  et_gategory_name;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_gategory);

        et_gategory_name = findViewById(R.id.et_gategory_name);
        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(Activity_Add_Gategory.this);
                myDB.addGategory(et_gategory_name.getText().toString().trim()
                );
                clearText();
            }
//clear text for add gategory just
            private void clearText() {
                et_gategory_name.setText("");
            }
        });
    }
}