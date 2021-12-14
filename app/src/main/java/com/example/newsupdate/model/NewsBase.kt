package com.example.newsupdate.model
import Articles

data class NewsBase
    (
    val status : String,
    val totalResults : Int,
    val articles : List<Articles>
            )