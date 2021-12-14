package com.example.newsupdate.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsupdate.model.NewsBase
import com.example.newsupdate.repository.HomeFragmentRepository

class HomeViewModel : ViewModel()
{
    var servicesLiveData: MutableLiveData<NewsBase>? = null
    fun getSports() : LiveData<NewsBase>? {
        servicesLiveData = HomeFragmentRepository.getSportsApiCall()
        return servicesLiveData
    }
    fun getEntertainment() : LiveData<NewsBase>? {
    servicesLiveData = HomeFragmentRepository.getEntertainmentApiCall()
    return servicesLiveData
}
    fun getTechnology() : LiveData<NewsBase>? {
        servicesLiveData = HomeFragmentRepository.getTechnologyApiCall()
        return servicesLiveData
    }
    fun getInternational() : LiveData<NewsBase>? {
        servicesLiveData = HomeFragmentRepository.getInternationalApiCall()
        return servicesLiveData
    }
    fun getPolitical() : LiveData<NewsBase>? {
        servicesLiveData = HomeFragmentRepository.getPoliticalApiCall()
        return servicesLiveData
    }


}