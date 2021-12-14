package com.example.newsupdate.ui

import Articles
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.newsupdate.R
import com.example.newsupdate.databinding.ActivityDetailsBinding
import com.example.newsupdate.databinding.ActivityMainBinding
import com.google.gson.Gson
import com.squareup.picasso.Picasso

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    private lateinit var imgNews:ImageView
    private lateinit var tvTitle:TextView
    private lateinit var tvDescription:TextView
    private lateinit var tvPublishAt:TextView
    private lateinit var tvContent:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDetailsBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        val gson = Gson()
        val news = gson.fromJson<Articles>(intent.getStringExtra("news"), Articles::class.java)
        imgNews=binding.imgNews
        tvTitle=binding.tvTitle
        tvDescription=binding.tvDescription
        tvPublishAt=binding.tvPublishAt
        tvContent=binding.tvContent

        tvTitle.text=news.title
        tvDescription.text=news.description
        tvPublishAt.text=news.publishedAt
        tvContent.text=news.content
        Picasso.get().load(news.urlToImage).fit().into(imgNews)


    }

    fun onClick(view: android.view.View)
    {
        super.onBackPressed()
    }
}