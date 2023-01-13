package com.example.youtubehv6m6.UI.playlists

import androidx.lifecycle.LiveData
import com.example.youtubehv6m6.App
import com.example.youtubehv6m6.core.ui.BaseViewModel
import com.example.youtubehv6m6.data.model.Playlists

class MainViewModel : BaseViewModel() {


    fun playlist() : LiveData<Playlists> {
        return App().repository.getPlaylists()
    }



}