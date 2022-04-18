package com.example.mynews.api

import com.example.mynews.model.NewsJson
import retrofit2.Call
import retrofit2.http.GET

interface ApiRequests {
    //сделал отдельный класс для использование  ретрофита
// да бы не брать URL целиком разбил его на 2 части для дольнейшего удобства при разработке
    @GET("/static/it_news.json")
    fun getNews():Call<NewsJson>
}