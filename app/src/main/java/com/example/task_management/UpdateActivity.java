package com.example.task_management;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {


    EditText title_input;
    Button update_button, delete_button;

    String id, title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        title_input = findViewById(R.id.et_gategory_name2);
        update_button = findViewById(R.id.update_button);
//        delete_button = findViewById(R.id.delete_button);

        //First we call this
        getAndSetIntentData();

        //Set actionbar title after getAndSetIntentData method
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(title);
        }

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //And only then we call this
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                title = title_input.getText().toString().trim();
                myDB.updateData(id, title);

            }
        });
    }
        void getAndSetIntentData(){
            if (getIntent().hasExtra("id") && getIntent().hasExtra("title")) {
                //Getting Data from Intent
                id = getIntent().getStringExtra("title");
                title = getIntent().getStringExtra("id");
                //Setting Intent Data
                title_input.setText(title);
                Log.d("stev", title);
            } else {
                Toast.makeText(UpdateActivity.this, "NO Data", Toast.LENGTH_SHORT).show();
            }
        }
    }

