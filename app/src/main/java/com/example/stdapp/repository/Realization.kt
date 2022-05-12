package com.example.stdapp.repository

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns
import android.widget.SearchView
import com.example.stdapp.model.StudentItem

class Realization(context: Context) {

    val helperDatabase = HelperDatabase(context)  // используем helperDatabase
    var db:SQLiteDatabase? = null   // иницилизируем базу данных для работы с ней


    fun dbOpen(){
        db = helperDatabase.writableDatabase //функция для оькрытия базы данных
    }
    // функция для записи в базу данных
    fun insert(name:String,age:String,url:String){
        val values  = ContentValues().apply {
            put(MyStydentApp.COLUMN_NAME,name) //сохраняем наши значение аналог HashMap (key:value)
            put(MyStydentApp.COLUMN_AGE,age)
            put(MyStydentApp.COLUMN_URL,url)
        }
        //реализуем запись в базу данных
        db?.insert(MyStydentApp.TABLE_NAME,null,values)

    }
    fun updateDB(name:String,age:String,url:String,id:Int){
        val select =BaseColumns._ID + "=$id"
        val values  = ContentValues().apply {
            put(MyStydentApp.COLUMN_NAME,name) //сохраняем наши значение аналог HashMap (key:value)
            put(MyStydentApp.COLUMN_AGE,age)
            put(MyStydentApp.COLUMN_URL,url)
        }
        //реализуем запись в базу данных
        db?.update(MyStydentApp.TABLE_NAME,values,select,null)

    }

    fun delitDb(id:String){

        val selectId =BaseColumns._ID + "=$id"  //удалить элемент по его индификатору найти в калоне id эллемент
        //реализуем запись в базу данных
        db?.insert(MyStydentApp.TABLE_NAME,selectId,null)

    }

    @SuppressLint("Range")
    fun readDb(searchView: String):ArrayList<StudentItem>{ //берем поля name/age/url из модели
        val dataList = ArrayList<StudentItem>()
        val selection ="${MyStydentApp.COLUMN_NAME} like ?" //название запроса  like ?
        val cursor = db?.query(MyStydentApp.TABLE_NAME,null,selection, arrayOf("%$searchView%"),null,null,null)


            while (cursor?.moveToNext()!!){
                //Достать все элементы из Столбика Имен с помощью COLUMN_NAME
                    ///////////////////////////////
                        ///достаем все элементы из нужной колоны и передаем в dataText
                val dataTextName= cursor.getString(cursor.getColumnIndex(MyStydentApp.COLUMN_NAME))
                val dataTextAge= cursor.getString(cursor.getColumnIndex(MyStydentApp.COLUMN_AGE))
                val dataTextUrl= cursor.getString(cursor.getColumnIndex(MyStydentApp.COLUMN_URL))
                val dataId= cursor.getInt(cursor.getColumnIndex(BaseColumns._ID))
                // и записываем все в dataList
                var item = StudentItem()
                //передаем данные в переменные из БД
                item.nameStudent = dataTextName
                item.age = dataTextAge
                item.urls = dataTextUrl
                item.id = dataId
                dataList.add(item)
            }
        
        cursor?.close()
        return dataList
    }
    fun closeDb(){
        //закрываем БД
        helperDatabase.close()
    }

}