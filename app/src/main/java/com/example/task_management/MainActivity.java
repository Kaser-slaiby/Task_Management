package com.example.task_management;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView rv_Categories;
    //Definition of elementsS
    Button btnAdd, btnList, btnSearch;
    MyDatabaseHelper myDB;
    ArrayList<String> CategoryName, NumberOfTasks;
    CustomAdapter customAdapter;



    final int MENU_ABOUT_ID = 1;
    final int MENU_QUIT_ID = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_Categories = findViewById(R.id.rv_Categories);

//         initializing all our objects
        btnAdd = findViewById(R.id.btnAdd);

//        below line is to add onclick listener for our buttons
        btnAdd.setOnClickListener(this);

//      creating a new handler class

//        style for layout bar
        Objects.requireNonNull(getSupportActionBar()).setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_barlayout);

        myDB = new MyDatabaseHelper(MainActivity.this);
        CategoryName = new ArrayList<>();
        NumberOfTasks = new ArrayList<>();
        storDataInArray();


        customAdapter = new CustomAdapter(MainActivity.this,this, CategoryName, NumberOfTasks);
        rv_Categories.setAdapter(customAdapter);
        rv_Categories.setLayoutManager(new LinearLayoutManager(MainActivity.this));

//
//        Cursor cursor = db.rawQuery("SELECT * FROM Tasks", null);
//        if (cursor.getCount() == 0) {
//            showMessage("Error", "NO");
//            return;
//        };

    }
    void storDataInArray () {
        Cursor cursor = myDB.readAllData();
        if(cursor.getCount() == 0) {
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()) {
                CategoryName.add(cursor.getString(0));
                NumberOfTasks.add(cursor.getString(1));
            }
        }
    }

//      read all Categories records

    @Override
    public void onClick(View v) {

//        adding new Categories
    if (v == btnAdd) {

        Intent intent = new Intent(this, Activity_Add_Gategory.class);
        startActivities(new Intent[]{intent});
    }
    else {

    }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, MENU_ABOUT_ID, 0, "About programmers");
        menu.add(0, MENU_QUIT_ID, 0, "Close the application");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case MENU_ABOUT_ID:
                Intent intent = new Intent(this, Activity_About.class);
                startActivities(new Intent[]{intent});
                break;

            case MENU_QUIT_ID:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }


}