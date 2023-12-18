package com.example.task_management;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    //Definition of elements
    Button btnAdd, btnList, btnSearch;

    private DBHandler dbHandler;

    final int MENU_ABOUT_ID = 1;
    final int MENU_QUIT_ID = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//         initializing all our objects
        btnAdd = findViewById(R.id.btnAdd);

//        below line is to add onclick listener for our buttons
        btnAdd.setOnClickListener(this);

//      creating a new handler class
        dbHandler = new DBHandler(MainActivity.this);

        readAllData();

//        style for layout bar
        Objects.requireNonNull(getSupportActionBar()).setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_barlayout);

    }

//      read all Categories records
    public void readAllData() {

    }

    @Override
    public void onClick(View v) {

//        adding new Categories
    if (v == btnAdd) {

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
}