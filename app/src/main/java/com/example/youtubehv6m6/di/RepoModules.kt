package com.example.youtubehv6m6.di

import com.example.youtubehv6m6.repository.Repository
import org.koin.dsl.module

val repoModules = module {
    single { Repository(get()) }
}