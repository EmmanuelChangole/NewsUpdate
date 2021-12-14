package com.example.newsupdate.ui

import Articles
import ParentAdapter
import android.app.Dialog
import android.content.Intent
import android.icu.text.IDNA
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.newsupdate.R
import com.example.newsupdate.viewModel.HomeViewModel
import com.example.newsupdate.adapter.NewsAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.bottomsheets.BottomSheet
import com.afollestad.materialdialogs.customview.customView
import com.example.newsupdate.adapter.TopicAdapter
import com.example.newsupdate.model.NewsBase
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.dialog.MaterialDialogs
import com.google.gson.Gson
import com.squareup.picasso.Picasso


class HomeFragment : Fragment(),ChildAdapter.ItemClickListener,TopicAdapter.ClickListener{

    private var rvSubject: RecyclerView? = null
    private var rvEvent:RecyclerView?=null
    lateinit var itemListener:ChildAdapter.ItemClickListener
    lateinit var itemClickListener:TopicAdapter.ClickListener

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        super.onViewCreated(view, savedInstanceState)
        rvSubject=view.findViewById(R.id.rvSubject)
        rvEvent=view.findViewById(R.id.rvEvent)
        itemListener=this
        itemClickListener=this
        viewModel.getEntertainment()!!.observe(viewLifecycleOwner, Observer {
            val articles=it.articles
            val subjects = ArrayList<List<Articles>>()
            subjects.add(articles)
             var adapter= context?.let { ParentAdapter(articles, "News update",itemListener) }
             val manager = LinearLayoutManager(context)
            rvSubject!!.layoutManager=manager
            rvSubject!!.adapter=adapter

       })

        viewModel.getSports()!!.observe(viewLifecycleOwner,{
            val articles=it.articles
            var adapter= context?.let { NewsAdapter(articles,
                requireContext(),"Upcoming events",itemClickListener) }
            val manager = LinearLayoutManager(context)
            rvEvent!!.layoutManager=manager
            rvEvent!!.adapter=adapter
        })




    }



    override fun onItemClick(articles: Articles) {
        val gson= Gson()
        var  intent= Intent(context,DetailsActivity::class.java)
        intent.putExtra("news",gson.toJson(articles))
        startActivity(intent)


    }

    override fun onItemClicked(articles: Articles)
    {
        context?.let {
            MaterialDialog(it, BottomSheet()).cornerRadius(20f).title(R.string.event).show() {
                customView(R.layout.event_details)
                var imageView = view.findViewById<ImageView>(R.id.imgNews)
                Picasso.get().load(articles.urlToImage).fit().into(imageView)
                var tvTitle=view.findViewById<TextView>(R.id.tvTitle)
                val tvContent=view.findViewById<TextView>(R.id.tvContent)
                val tvDate=view.findViewById<TextView>(R.id.tvDate)
                val tvLocation=view.findViewById<TextView>(R.id.tvLocation)

                tvTitle.text=articles.title
                tvContent.text=articles.content
                tvDate.text=articles.publishedAt
                tvLocation.text="Nairobi, Kenya"




            }

        }

    }


}