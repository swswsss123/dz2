package com.example.mynews.model

data class NewsJson(
    val location: String,
    val name: String,
    val news: List<New>
)