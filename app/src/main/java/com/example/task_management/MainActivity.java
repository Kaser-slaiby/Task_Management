package com.example.task_management;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Definition of elementsS
    RecyclerView rv_Categories;
    Button btnAdd, btnList, btnSearch;
    ImageView empty_imageview;
    TextView no_data;
    MyDatabaseHelper myDB;
    ArrayList<String> CategoryName, NumberOfTasks;
    CustomAdapter customAdapter;

    //For menu view
    final int MENU_ABOUT_ID = 1;
    final int MENU_QUIT_ID = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//         initializing all our objects
        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);
        empty_imageview = findViewById(R.id.empty_imageview);
        no_data = findViewById(R.id.no_data);

        myDB = new MyDatabaseHelper(MainActivity.this);
        CategoryName = new ArrayList<>();
        NumberOfTasks = new ArrayList<>();
        storDataInArray();

//      RV
        rv_Categories = findViewById(R.id.rv_Categories);
        customAdapter = new CustomAdapter(MainActivity.this,this, CategoryName, NumberOfTasks);
        rv_Categories.setAdapter(customAdapter);
        rv_Categories.setLayoutManager(new LinearLayoutManager(MainActivity.this));

//        style for layout bar
        Objects.requireNonNull(getSupportActionBar()).setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_barlayout);
    }

    // Refresh update
    @Override 
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate();
        }
    }
    void storDataInArray () {
        Cursor cursor = myDB.readAllData();
        if(cursor.getCount() == 0) {
            empty_imageview.setVisibility(View.VISIBLE);
            no_data.setVisibility(View.VISIBLE);
        }else {
            while (cursor.moveToNext()) {
                CategoryName.add(cursor.getString(0));
                NumberOfTasks.add(cursor.getString(1));
            }
            empty_imageview.setVisibility(View.GONE);
            no_data.setVisibility(View.GONE);
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