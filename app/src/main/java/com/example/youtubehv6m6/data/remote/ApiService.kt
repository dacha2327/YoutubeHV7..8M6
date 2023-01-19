package com.example.youtubehv6m6.data.remote

import com.example.youtubehv6m6.data.model.Playlists
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface
ApiService {

     @GET("playlists")
     suspend fun getPlaylists(
          @Query("part") part : String,
          @Query("channelId") channelId : String,
          @Query("key") key : String,
          @Query("maxResults") maxResults : Int
     ) : Response<Playlists>

}