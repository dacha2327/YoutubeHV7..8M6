package com.example.youtubehv6m6.data

import com.example.youtubehv6m6.model.PlayListItems
import com.example.youtubehv6m6.model.Playlists
import okhttp3.Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

     @GET("playlists")
     fun getPlaylists(
          @Query("part") part : String,
          @Query("channelId") channelId : String,
          @Query("key") key : String
     ) : Call<Playlists>

}