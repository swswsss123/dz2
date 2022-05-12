package com.example.stdapp.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.stdapp.R
import com.example.stdapp.model.StudentItem
import com.example.stdapp.repository.Const
import com.example.stdapp.repository.Realization
import com.example.stdapp.screen.EditActivity

class StudentAdapter(list:ArrayList<StudentItem>,contextV: Context):RecyclerView.Adapter<StudentAdapter.StudentHolderAdapter>() {
    var myList = list
    var context = contextV

    class StudentHolderAdapter(itemView:View,contextH:Context):RecyclerView.ViewHolder(itemView) {
        //переменая для поиска  textName
        var context = contextH
        var textName:TextView = itemView.findViewById(R.id.textName)
        //функция с передачей данных из textName
        fun setName(item:StudentItem){
            textName.text = item.nameStudent

            //Слушателель нажатия на целиком на всю вьюшку
            itemView.setOnClickListener {
                var intent = Intent(context,EditActivity::class.java).apply {

                    //передаем все данные в EditActivity
                    putExtra(Const.TITLE_NAME_KEY,item.nameStudent)
                    putExtra(Const.TITLE_AGE_KEY,item.age)
                    putExtra(Const.TITLE_URL_KEY,item.urls)
                    putExtra(Const.TITLE_ID_KEY,item.id)
                }
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentHolderAdapter {
        val inflaters = LayoutInflater.from(parent.context)
        return StudentHolderAdapter(inflaters.inflate(R.layout.item_layout,parent,false),context)
    }
    override fun onBindViewHolder(holder: StudentHolderAdapter, position: Int) {
        holder.setName(myList[position])
    }

    override fun getItemCount(): Int {
        return myList.size
    }
    @SuppressLint("NotifyDataSetChanged")
    fun updateAdapter(listItem:List<StudentItem>){
        myList.clear()
        myList.addAll(listItem)
        notifyDataSetChanged()
    }
    fun delitItem(pos:Int,realization: Realization){
        realization.delitDb(myList[pos].id.toString())  //берем из item.id = dataId
        myList.removeAt(pos)
        notifyItemRangeChanged(0,myList.size) // изменили длину адаптера
        notifyItemRemoved(pos) //удалили элемент по позиции
    }
}


