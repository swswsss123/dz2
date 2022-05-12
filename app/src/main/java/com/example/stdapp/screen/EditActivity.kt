package com.example.stdapp.screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.stdapp.R
import com.example.stdapp.repository.Const
import com.example.stdapp.repository.Realization
import kotlinx.android.synthetic.main.activity_edit.*

class EditActivity : AppCompatActivity() {
    var id = 0
    var state = false
    var realization = Realization(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        getMyIntents()
    }


    override fun onResume() {
        super.onResume()
        realization.dbOpen()

    }
    override fun onDestroy() {
        super.onDestroy()
        realization.closeDb()
    }

    fun onClickSave2(view: View) {

        val editname = editName.text.toString()
        val editage = editAge.text.toString()
        val editurl = editUrl.text.toString()

        if(editname.isNotEmpty() && editage.isNotEmpty() && editurl.isNotEmpty()){
            if(state){
                realization.insert(editname,editage,editurl,)
            }else{
                realization.insert(editname,editage,editurl)
            }

        }
    }
    fun getMyIntents(){
        val i = intent

        if(i != null) {
            if (i.getStringExtra(Const.TITLE_NAME_KEY) != null) {
                id = i.getIntExtra(Const.TITLE_ID_KEY,0)
                state = true
                editName.setText(i.getStringExtra(Const.TITLE_NAME_KEY))
                editAge.setText(i.getStringExtra(Const.TITLE_AGE_KEY))
                editUrl.setText(i.getStringExtra(Const.TITLE_URL_KEY))


            }
        }
    }
}