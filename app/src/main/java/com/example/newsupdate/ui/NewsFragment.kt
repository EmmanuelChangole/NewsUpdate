package com.example.newsupdate.ui

import Articles
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.bottomsheets.BottomSheet
import com.afollestad.materialdialogs.customview.customView
import com.example.newsupdate.viewModel.NewsViewModel
import com.example.newsupdate.R
import com.example.newsupdate.adapter.NewsAdapter
import com.example.newsupdate.databinding.NewsFragmentBinding
import com.squareup.picasso.Picasso

class NewsFragment : Fragment(),NewsAdapter.ClickListener {

    private lateinit var binding:NewsFragmentBinding
    private lateinit var mRecycler:RecyclerView
    private lateinit var newsProgress:ProgressBar

    companion object {
        fun newInstance() = NewsFragment()
    }

    private lateinit var viewModel: NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= NewsFragmentBinding.inflate(layoutInflater)

       return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mRecycler=binding.newsRecycler
        newsProgress=binding.newsProgress
        viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
        viewModel.getPolitical()?.observe(viewLifecycleOwner, Observer {
         var mAdapter= context?.let { it1 -> NewsAdapter(it.articles, it1,this) }
         mRecycler.adapter=mAdapter
         mRecycler.layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
          mRecycler.setHasFixedSize(true)
          newsProgress.visibility=View.GONE

        })





    }

    override fun onItemClicked(articles: Articles)
    {
        context?.let {
            MaterialDialog(it, BottomSheet()).cornerRadius(20f).title(R.string.news).show() {
                customView(R.layout.news_update)
                var imageView = view.findViewById<ImageView>(R.id.imgNews)
                Picasso.get().load(articles.urlToImage).fit().into(imageView)
                var tvTitle=view.findViewById<TextView>(R.id.tvTitle)
                val tvContent=view.findViewById<TextView>(R.id.tvContent)
                val tvDate=view.findViewById<TextView>(R.id.tvDate)
                val tvDescription=view.findViewById<TextView>(R.id.tvDescription)

                tvTitle.text=articles.title
                tvContent.text=articles.content
                tvDate.text=articles.publishedAt
                tvDescription.text=articles.description





            }

        }



    }


}