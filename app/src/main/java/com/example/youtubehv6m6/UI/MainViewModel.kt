package com.example.youtubehv6m6.UI

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.youtubehv6m6.BuildConfig
import com.example.youtubehv6m6.base.BaseViewModel
import com.example.youtubehv6m6.data.ApiService
import com.example.youtubehv6m6.data.RetrofitClient
import com.example.youtubehv6m6.model.Playlists
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainViewModel : BaseViewModel() {

    private val apiService : ApiService by lazy {
        RetrofitClient.create()
    }

    fun playlist() : LiveData<Playlists> {
        return getPlaylists()
    }

    private fun getPlaylists() : LiveData<Playlists> {
         val data = MediatorLiveData<Playlists>()

        apiService.getPlaylists("snippet,contentDetails" , "UCWOA1ZGywLbqmigxE4Qlvuw" , BuildConfig.API_KEY)
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