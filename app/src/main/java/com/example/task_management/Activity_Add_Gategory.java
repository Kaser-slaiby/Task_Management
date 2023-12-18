package com.example.task_management;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity_Add_Gategory extends AppCompatActivity implements View.OnClickListener {

    EditText et_gategory_name;

    Button  btnSave;


    private DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_gategory);
//      below line is to add new Gategory
        btnSave.setOnClickListener(this);

        dbHandler = new DBHandler(Activity_Add_Gategory.this);

        et_gategory_name = findViewById(R.id.et_gategory_name);
        btnSave = findViewById(R.id.btnSave);

    }

    @Override
    public void onClick(View v) {
        if (v == btnSave) {

            String GategoryName = et_gategory_name.getText().toString().trim();

            if (GategoryName.isEmpty()) {
                showMessage("Error", "يرجى مل.................");
                return;
            }

        }

    }

    private void showMessage(String error, String message) {
    }
}