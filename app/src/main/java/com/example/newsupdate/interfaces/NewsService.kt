package com.example.newsupdate.interfaces

import com.example.newsupdate.model.NewsBase
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService
{
    @GET("everything?from=2022-1-1&to=2022-1-3&sortBy=popularity&apiKey=b30efe7dc1294213b32e09b4571b0c74&q=football")
    fun getSports() : Call<NewsBase>

    @GET("everything?from=2022-1-1&to=2022-1-3&sortBy=popularity&apiKey=b30efe7dc1294213b32e09b4571b0c74&q=political")
    fun getPolitical() : Call<NewsBase>
    @GET("everything?from=2022-1-1&to=2022-1-3&sortBy=popularity&apiKey=b30efe7dc1294213b32e09b4571b0c74&q=international")
    fun getInternational() : Call<NewsBase>
    @GET("everything?from=2022-1-1&to=2022-1-3&sortBy=popularity&apiKey=b30efe7dc1294213b32e09b4571b0c74&q=entertainment")
    fun getEntertainment() : Call<NewsBase>
    @GET("everything?from=2022-1-1&to=2022-1-3&sortBy=popularity&apiKey=b30efe7dc1294213b32e09b4571b0c74&q=technology")
    fun getTechnology() : Call<NewsBase>

    @GET("everything?from=2022-1-1&to=2022-1-3&sortBy=popularity&apiKey=b30efe7dc1294213b32e09b4571b0c74&q=technology")
    suspend fun getNews(@Query("page") page:Int,@Query("pageSize") pageSize:Int) : List<NewsBase>





}