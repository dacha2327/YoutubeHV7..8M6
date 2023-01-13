package com.example.youtubehv6m6.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.youtubehv6m6.BuildConfig
import com.example.youtubehv6m6.data.remote.ApiService
import com.example.youtubehv6m6.core.network.RetrofitClient
import com.example.youtubehv6m6.data.model.Playlists
import retrofit2.Call
import retrofit2.Response

class Repository {

    private val apiService : ApiService by lazy {
        RetrofitClient.create()
    }

    fun getPlaylists() : LiveData<Playlists> {
        val data = MediatorLiveData<Playlists>()

        apiService.getPlaylists("snippet,contentDetails" , "UCshNYNzkggNqtKD09vLq3SQ" ,
            BuildConfig.API_KEY, 30)
            .enqueue(object : retrofit2.Callback<Playlists> {
                override fun onResponse(call: Call<Playlists>, response: Response<Playlists>) {
                    if (response.isSuccessful) {
                        data.value = response.body()
                    }
                }

                override fun onFailure(call: Call<Playlists>, t: Throwable) {

                }
            })
        return data
    }
}