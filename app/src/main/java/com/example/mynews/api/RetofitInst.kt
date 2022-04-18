package com.example.mynews.api

import com.example.mynews.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
//модели собирал не вручнкю а через Json конвертор
object RetofitInst {
    var api:ApiRequests = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiRequests::class.java)
}