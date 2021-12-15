package com.example.newsupdate.ui

import Articles
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsupdate.viewModel.NewsViewModel
import com.example.newsupdate.R
import com.example.newsupdate.adapter.NewsAdapter
import com.example.newsupdate.databinding.NewsFragmentBinding

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



    }


}