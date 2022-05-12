package com.example.stdapp.repository

import android.provider.BaseColumns

object MyStydentApp:BaseColumns {
    // иницилизация таблицы
    const val TABLE_NAME = "student_table"
    const val COLUMN_NAME = "name"
    const val COLUMN_AGE = "age"
    const val COLUMN_URL = "url"
    //иницилизация базы данных
    const val DATABASE_VERSION = 1
    const val DATABASE_NAME = "StudentDatabase.db"

    const val CREAT_TABLE ="CREATE TABLE IF NOT EXISTS $TABLE_NAME("+
    "${BaseColumns._ID} INTEGER PRIMARY KEY,$COLUMN_NAME TEXT,$COLUMN_AGE TEXT,$COLUMN_URL TEXT)"

    const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS $TABLE_NAME"
}