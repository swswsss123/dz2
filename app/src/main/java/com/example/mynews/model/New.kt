package com.example.mynews.model

data class New(
    val date: String,
    val description: String,
    val id: Int,
    val keywords: List<String>,
    val title: String,
    val visible: Boolean
)