package com.example.youtubehv6m6.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.youtubehv6m6.BuildConfig
import com.example.youtubehv6m6.data.model.Playlists
import com.example.youtubehv6m6.data.remote.ApiService
import kotlinx.coroutines.Dispatchers

class Repository(private var apiService: ApiService) {

    fun getPlaylists() : LiveData<Playlists> {
        return liveData(Dispatchers.IO) {
            val response = apiService.getPlaylists(
                "snippet,contentDetails" ,
                "UCshNYNzkggNqtKD09vLq3SQ" ,
                BuildConfig.API_KEY,
                30)

            response.body()?.let { emit(it) }
        }
    }
}