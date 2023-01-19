package com.example.youtubehv6m6.di

import com.example.youtubehv6m6.ui.playlists.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

var viewModules = module {
    viewModel{ MainViewModel(get()) }
}