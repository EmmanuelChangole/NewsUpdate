package com.example.newsupdate.interfaces

import com.example.newsupdate.model.NewsBase
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface
{
    @GET("everything?from=2021-11-30&to=2021-12-30&sortBy=popularity&apiKey=b30efe7dc1294213b32e09b4571b0c74&q=football")
    fun getSports() : Call<NewsBase>

    @GET("everything?from=2021-11-30&to=2021-12-30&sortBy=popularity&apiKey=b30efe7dc1294213b32e09b4571b0c74&q=political")
    fun getPolitical() : Call<NewsBase>
    @GET("everything?from=2021-11-30&to=2021-12-30&sortBy=popularity&apiKey=b30efe7dc1294213b32e09b4571b0c74&q=international")
    fun getInternational() : Call<NewsBase>
    @GET("everything?from=2021-11-30&to=2021-12-30&sortBy=popularity&apiKey=b30efe7dc1294213b32e09b4571b0c74&q=entertainment")
    fun getEntertainment() : Call<NewsBase>
    @GET("everything?from=2021-11-30&to=2021-12-30&sortBy=popularity&apiKey=b30efe7dc1294213b32e09b4571b0c74&q=technology")
    fun getTechnology() : Call<NewsBase>




}