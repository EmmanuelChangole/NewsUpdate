package com.example.newsupdate.adapter

import Articles
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsupdate.R
import com.squareup.picasso.Picasso

class NewsAdapter(articles:List<Articles>, context:Context, private val listener:NewsAdapter.ClickListener):RecyclerView.Adapter<NewsAdapter.ViewHolder>()
{
    var articles: List<Articles>? = null
    private var context: Context? = null
    private var layoutInflater: LayoutInflater? = null
    init {
        this.context=context
        this.articles=articles
        this.layoutInflater= LayoutInflater.from(context)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        val view: View =layoutInflater!!.inflate(R.layout.news_template,parent,false)
        return ViewHolder(view);


    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        var news=articles?.get(position)
        holder.tvTitle?.text=news?.title
        holder.tvDate?.text=news?.publishedAt
        holder.tvContent?.text=news?.content
        Picasso.get().load(news?.urlToImage).fit().into(holder.imgVIew)



    }

    override fun getItemCount(): Int {
      return articles!!.size
    }



    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var imgVIew:ImageView?=null
        var tvTitle:TextView?=null
        var tvDate:TextView?=null
        var tvContent:TextView?=null

        init {
            imgVIew=itemView.findViewById(R.id.imgNews)
            tvTitle=itemView.findViewById(R.id.tvTitle)
            tvDate=itemView.findViewById(R.id.tvDate)
            tvContent=itemView.findViewById(R.id.tvContent)
        }


    }

    interface ClickListener {
        fun onItemClicked(articles: Articles)
    }
}