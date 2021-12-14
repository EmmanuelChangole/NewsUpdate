package com.example.newsupdate.repository
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.newsupdate.model.NewsBase
import com.example.newsupdate.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


object HomeFragmentRepository
{
    fun getSportsApiCall(): MutableLiveData<NewsBase> {
        val serviceNewsGetter=MutableLiveData<NewsBase>()

        val call = RetrofitClient.apiInterface.getSports()

        call.enqueue(object: Callback<NewsBase> {
            override fun onResponse(call: Call<NewsBase>, response: Response<NewsBase>)
            {
                val data =response.body() as NewsBase
                serviceNewsGetter.value=data
                Log.d("msg","error")

            }

            override fun onFailure(call: Call<NewsBase>, t: Throwable) {

            }

        })

        return serviceNewsGetter
    }
    fun getPoliticalApiCall(): MutableLiveData<NewsBase> {
        val serviceNewsGetter=MutableLiveData<NewsBase>()

        val call = RetrofitClient.apiInterface.getPolitical()

        call.enqueue(object: Callback<NewsBase> {
            override fun onResponse(call: Call<NewsBase>, response: Response<NewsBase>)
            {
                val data =response.body() as NewsBase
                serviceNewsGetter.value=data
                Log.d("msg","error")

            }

            override fun onFailure(call: Call<NewsBase>, t: Throwable) {

            }

        })

        return serviceNewsGetter
    }
    fun getTechnologyApiCall(): MutableLiveData<NewsBase> {
        val serviceNewsGetter=MutableLiveData<NewsBase>()

        val call = RetrofitClient.apiInterface.getTechnology()

        call.enqueue(object: Callback<NewsBase> {
            override fun onResponse(call: Call<NewsBase>, response: Response<NewsBase>)
            {
                val data =response.body() as NewsBase
                serviceNewsGetter.value=data
                Log.d("msg","error")

            }

            override fun onFailure(call: Call<NewsBase>, t: Throwable) {

            }

        })

        return serviceNewsGetter
    }
    fun getEntertainmentApiCall(): MutableLiveData<NewsBase>  {
        val serviceNewsGetter=MutableLiveData<NewsBase>()

        val call = RetrofitClient.apiInterface.getEntertainment()

        call.enqueue(object: Callback<NewsBase> {
            override fun onResponse(call: Call<NewsBase>, response: Response<NewsBase>)
            {
                val data =response.body() as NewsBase
                serviceNewsGetter.value=data
                Log.d("msg","error")


            }

            override fun onFailure(call: Call<NewsBase>, t: Throwable) {

            }

        })

        return serviceNewsGetter
    }
    fun getInternationalApiCall(): MutableLiveData<NewsBase> {
        val serviceNewsGetter=MutableLiveData<NewsBase>()

        val call = RetrofitClient.apiInterface.getInternational()

        call.enqueue(object: Callback<NewsBase> {
            override fun onResponse(call: Call<NewsBase>, response: Response<NewsBase>)
            {
                val data =response.body() as NewsBase
                serviceNewsGetter.value=data
                Log.d("msg","error")


            }

            override fun onFailure(call: Call<NewsBase>, t: Throwable) {

            }

        })

        return serviceNewsGetter
    }



}