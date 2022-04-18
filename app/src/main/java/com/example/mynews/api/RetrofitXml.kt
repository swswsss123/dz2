package com.example.mynews.api

import com.example.mynews.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

class RetrofitXml {

        var apiX:ApiRequests= Retrofit.Builder()
            .baseUrl("https://api.kiparo.com/static/it_news.xml")
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build()
            .create(ApiRequests::class.java)
    }
