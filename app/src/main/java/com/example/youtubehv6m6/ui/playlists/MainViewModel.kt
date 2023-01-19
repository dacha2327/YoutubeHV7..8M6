package com.example.youtubehv6m6.ui.playlists

import androidx.lifecycle.LiveData
import com.example.youtubehv6m6.App
import com.example.youtubehv6m6.core.ui.BaseViewModel
import com.example.youtubehv6m6.data.model.Playlists
import com.example.youtubehv6m6.repository.Repository

class MainViewModel(private val repository: Repository) : BaseViewModel() {

    fun playlist() : LiveData<Playlists> {
        return repository.getPlaylists()
    }
}