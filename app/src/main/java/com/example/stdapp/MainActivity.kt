package com.example.stdapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SearchView
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.stdapp.adapter.StudentAdapter
import com.example.stdapp.repository.Realization
import com.example.stdapp.screen.EditActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    var realization = Realization(this)
    var studentAdapter = StudentAdapter(ArrayList(),this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()

    }

    override fun onResume() {
        super.onResume()
        realization.dbOpen()
        createAdapter()
    }

    fun OnclicSave(view: View) {
       val i = Intent(this,EditActivity::class.java)
        startActivity(i)



    }

    override fun onDestroy() {
        super.onDestroy()
        realization.closeDb()
    }
    fun init(){
        rc_view.adapter = studentAdapter
        val swapManager = touchMG()
        swapManager.attachToRecyclerView(rc_view)  //подключаем RecyclerView для работы татча
        searchView()
    }
    fun createAdapter(){
        studentAdapter.updateAdapter(realization.readDb(""))
    }
    fun searchView(){
        searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                TODO("Not yet implemented")
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                val list = realization.readDb(p0!!)
                studentAdapter.updateAdapter(list)
                return true
            }
        })
    }
    //создание обработки работы с татчем
    private fun touchMG():ItemTouchHelper{
        return ItemTouchHelper(object:ItemTouchHelper.
        SimpleCallback(0,ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                //получение позиции для удаления из RecyclerView  по тачу

                studentAdapter.delitItem(viewHolder.adapterPosition,realization) //удаляем их адаптера и из базы даных
            }
        })
    }
}