package com.example.newsupdate.adapter

import Articles
import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import com.example.newsupdate.R
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager

class NewsUpdateAdapter(articles:List<Articles>, context:Context, private val title:String, private val listener:TopicAdapter.ClickListener): RecyclerView.Adapter<NewsUpdateAdapter.ViewHolder>() {
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
        val view: View =layoutInflater!!.inflate(R.layout.single_subject,parent,false)
        return ViewHolder(view)



    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {

        var adapterHolder=TopicAdapter(context!!, articles!!)
        adapterHolder.setItemClickListener(listener)

        holder.recyclerView!!.adapter = adapterHolder
        holder.recyclerView!!.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        holder.recyclerView!!.setHasFixedSize(true);
        holder.tvHeading!!.text=title

    }

    override fun getItemCount(): Int
    {
       return 1
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var recyclerView: RecyclerView? = null
        var tvHeading: TextView? = null
        init {
            recyclerView = itemView.findViewById<View>(R.id.rvChapters) as RecyclerView
            tvHeading = itemView.findViewById<View>(R.id.tvSubjectName) as TextView
        }

    }

}