package com.example.newsupdate.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsupdate.model.NewsBase
import com.example.newsupdate.repository.HomeFragmentRepository

class NewsViewModel : ViewModel() {
    var servicesLiveData: MutableLiveData<NewsBase>? = null

    fun getPolitical() : LiveData<NewsBase>? {
        servicesLiveData = HomeFragmentRepository.getPoliticalApiCall()
        return servicesLiveData
    }
}