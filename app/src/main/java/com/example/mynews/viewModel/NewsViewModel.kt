package com.example.mynews.viewModel

import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynews.api.RetofitInst
import com.example.mynews.model.NewsJson
import com.example.mynews.repository.NewsRepository
import com.example.mynews.repository.NewsRepositoryImpl
import com.example.mynews.view.MainActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.awaitResponse
import java.lang.Exception
import java.text.DateFormat

class NewsViewModel:MainActivity() {



}