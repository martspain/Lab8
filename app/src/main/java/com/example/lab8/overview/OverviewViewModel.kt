package com.example.lab8.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Callback
import com.example.lab8.network.GitApi
import retrofit2.Call
import retrofit2.Response

class OverviewViewModel : ViewModel(){

    private val _response = MutableLiveData<String>()

    val response: LiveData<String>
        get() = _response

    init {
        getGitHubProperties()
    }

    private fun getGitHubProperties() {
        GitApi.retrofitService.getProperties().enqueue(
            object: Callback<String> {
                override fun onFailure(call: Call<String>, t: Throwable) {
                    _response.value = "Failure: " + t.message
                }

                override fun onResponse(call: Call<String>, response: Response<String>) {
                    _response.value = response.body()
                }
            })
    }


}