package com.example.mynews.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.mynews.R
import com.example.mynews.api.RetofitInst.api
import com.example.mynews.model.NewsJson
import com.example.mynews.viewModel.NewsViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.awaitResponse
import java.lang.Exception
import java.text.DateFormat

open class MainActivity : AppCompatActivity() {
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navController =Navigation.findNavController(this,R.id.nav_host_fragment)



    }

}
