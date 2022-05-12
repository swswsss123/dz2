package com.example.stdapp.repository

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class HelperDatabase(context: Context):SQLiteOpenHelper(context,MyStydentApp.DATABASE_NAME,
null,MyStydentApp.DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(MyStydentApp.CREAT_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL(MyStydentApp.SQL_DELETE_ENTRIES)
        onCreate(db)
    }
}