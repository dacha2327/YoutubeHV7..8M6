package com.example.youtubehv6m6

import android.app.Application
import com.example.youtubehv6m6.repository.Repository

class App : Application() {

    val repository : Repository by lazy {
        Repository()
    }
}