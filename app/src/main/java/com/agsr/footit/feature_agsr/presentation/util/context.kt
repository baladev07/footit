package com.agsr.footit.feature_agsr.presentation.util

import android.annotation.SuppressLint
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.database.Cursor
import android.content.ContentValues
import android.content.Context


class dataManager(context: Context, factory: SQLiteDatabase.CursorFactory?) :
        SQLiteOpenHelper(context, "db_footit", factory, 1){
    private val db : SQLiteDatabase = context.openOrCreateDatabase("FootIt", Context.MODE_PRIVATE, null);

    override fun onCreate(db: SQLiteDatabase) {
       initTables()
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        // this method is to check if table already exists
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
//        onCreate(db)
    }

    @SuppressLint("SuspiciousIndentation")
    fun initTables() {
        val modulesCreateQueryUserTable =
                "CREATE TABLE IF NOT EXISTS `User` (UserId INTEGER PRIMARY KEY," +
                "FirstName TEXT," +
                "LastName TEXT," +
                " DateFormatType INTEGER," +
                " MetricType TEXT," +
                " CreatedTimeStamp TEXT NOT NULL," +
                " UpdatedTimeStamp TEXT NOT NULL," +
                " IsDeleted TEXT NOT NULL" +
                ")";
            db.execSQL(modulesCreateQueryUserTable)

        val modulesCreateQueryGoalsTable =
            "CREATE TABLE IF NOT EXISTS `Goal` (GoalId INTEGER PRIMARY KEY," +
                    "GoalName TEXT," +
                    "StepCount TEXT," +
                    " IsGoalActive TEXT," +
                    " CreatedTimeStamp TEXT NOT NULL," +
                    " UpdatedTimeStamp TEXT NOT NULL," +
                    " IsDeleted TEXT NOT NULL," +
                    " FOREIGN KEY (User) REFERENCES  Goal (UserId)" +
                    ")";
        db.execSQL(modulesCreateQueryGoalsTable)

        val modulesCreateQueryStepsTable =
            "CREATE TABLE IF NOT EXISTS `Steps` (UserId INTEGER PRIMARY KEY," +
                    "StepCount INTEGER," +
                    "ActivityDate TEXT," +
                    " CreatedTimeStamp TEXT NOT NULL," +
                    " UpdatedTimeStamp TEXT NOT NULL," +
                    " IsDeleted TEXT NOT NULL," +
                    " FOREIGN KEY (User) REFERENCES  Goal (UserId)" +
                    ")";
        db.execSQL(modulesCreateQueryStepsTable)
    }
}