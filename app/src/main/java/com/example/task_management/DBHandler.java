package com.example.task_management;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    //Name the DB
    private static final String DB_NAME = "taskDB";

    private static final int DB_VERSION = 1;

    private static final String TABLE_NAME  =   "Task-classifications";

    private static final String ID_COL  =   "id";

    private static final String GATEGORY_NAME_COL  =   "CategoryName";
    private static final String NUMBER_OF_TASKS_COL  =   "NumberOfTasks";
    public DBHandler( Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase ) {

        String query = "CREATE TABLE " + TABLE_NAME + "("
                + ID_COL + "INTEGER PRIMARY KEY AUTOINCREMENT,"
                + GATEGORY_NAME_COL + "VARCHAR, "
                + NUMBER_OF_TASKS_COL + "VARCHAR)";

        sqLiteDatabase.execSQL(query);
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }


    public void addNewGategory(String gategoryName) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(GATEGORY_NAME_COL, gategoryName);

        db.insert(TABLE_NAME,null, contentValues);

        db.close();
    }

//    public ArrayList<Gategory_Model> readGategory() {
//        SQLiteDatabase db = this.rawQuery( "SELECT * FROM " + TABLE_NAME)
//    }
//
//    private SQLiteDatabase rawQuery() {
//    };
}


