package com.example.task_management;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
import androidx.annotation.Nullable;

import com.example.task_management.Model.Category;

import java.util.ArrayList;

class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "Task.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "Tasks";

    private static final String COLUM_ID = "_id";

    private static final String GATEGORY_NAME_COL = "CategoryName";


    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                GATEGORY_NAME_COL + " TEXT);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    void addGategory(String title) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(GATEGORY_NAME_COL, title);
        long result = db.insert(TABLE_NAME, null, cv);
        if (result != 1) {
            Toast.makeText(context, "Please Enter Data", Toast.LENGTH_SHORT).show();
            return;
        } else {
            Toast.makeText(context, "Save", Toast.LENGTH_SHORT).show();
        }
        db.close();
    }


    Cursor readAllData() {
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    void updateData(String row_id, String title) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(GATEGORY_NAME_COL, title);


        long result = db.update(TABLE_NAME, cv, "_id=?", new String[]{row_id});
        if (result != 1) {
            Toast.makeText(context, "Please Enter Data", Toast.LENGTH_SHORT).show();
            return;
        } else {
            Toast.makeText(context, "Updated Successfully!", Toast.LENGTH_SHORT).show();
        }
        db.close();
    }

    void deleteOneRow(String row_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, "_id=?", new String[]{row_id});
        if (result != 1) {
            Toast.makeText(context, "Failed to Delete.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Successfully Deleted.", Toast.LENGTH_SHORT).show();
        }
    }
        ArrayList<Category> searchCategory(String NumberOfTasks) {
        SQLiteDatabase db = this.getReadableDatabase();
        String queryString = "SELECT * FROM " + TABLE_NAME + " WHERE " + GATEGORY_NAME_COL + " = ? ";
        Cursor cursor_categury = db.rawQuery(queryString , new String[]{NumberOfTasks});
        ArrayList<Category> categoryArrayList = new ArrayList<>();
        if (cursor_categury.moveToFirst()) {
            do {
               categoryArrayList.add(new Category(
                      cursor_categury.getInt(0),
                       cursor_categury.getString(1)
               ));
            }while(cursor_categury.moveToNext());
        }
        cursor_categury.close();
        return categoryArrayList;
    }


}


