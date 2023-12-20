package com.example.task_management;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

 class MyDatabaseHelper extends SQLiteOpenHelper {

     private Context context;
     public static final String DATABASE_NAME = "Task.db";
     public static final int DATABASE_VERSION = 1;
     private static final String TABLE_NAME  =   "Tasks";

     private static final String COLUM_ID  =   "_id";

     private static final String GATEGORY_NAME_COL  =   "CategoryName";
     private static final String NUMBER_OF_TASKS_COL  =   "NumberOfTasks";
    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                        " (" + COLUM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        GATEGORY_NAME_COL + " TEXT, " +
                        NUMBER_OF_TASKS_COL + " INTEGER);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
