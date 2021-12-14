package com.example.newsupdate.adapter

import Articles
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsupdate.R
import android.widget.TextView
import com.squareup.picasso.Picasso

class TopicAdapter(context: Context, topics:List<Articles>): RecyclerView.Adapter<TopicAdapter.CustomViewHolder>()
{
    private var inflater: LayoutInflater? = null
    private var topics: List<Articles>? = null
    private var context: Context? = null
    private var onItemClickListener: ClickListener? = null

    init {
        this.context=context
        this.topics=topics
        this.inflater=LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder
    {
        var view: View
        view = inflater!!.inflate(R.layout.event,parent,false)
        return CustomViewHolder(view)

    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int)
    {
        var chapter=topics!!.get(position)
        holder.tvTitle!!.text=chapter.title
        Picasso.get()
            .load(chapter.urlToImage)
            .fit()
            .centerCrop()
            .into(holder.imgEvent)
        holder.tvDate!!.text=chapter.publishedAt
        holder.tvContent!!.text=chapter.content
        holder.itemView.setOnClickListener{
            onItemClickListener!!.onItemClicked(chapter)

        }


    }

    override fun getItemCount(): Int
    {
        return topics!!.size
    }


    interface ClickListener {
        fun onItemClicked(articles: Articles)
    }
    public fun setItemClickListener(clickListener: ClickListener) {
        onItemClickListener = clickListener
    }

    class CustomViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView)
    {
        var imgEvent: ImageView? = null
        var tvDate: TextView? = null
        var tvTitle:TextView?=null
        var tvContent:TextView?=null


        init {
            tvDate = itemView.findViewById<View>(R.id.tvDate) as TextView
            imgEvent = itemView.findViewById<View>(R.id.img_event) as ImageView
            tvTitle=itemView.findViewById<View>(R.id.tvEvent) as TextView
            tvContent=itemView.findViewById<View>(R.id.tvContent) as TextView
        }

    }


}