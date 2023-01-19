package com.example.youtubehv6m6.core.network

import com.example.youtubehv6m6.data.remote.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModules = module {
    factory { provideApi(get()) }
    single { provideRetrofit(get()) }
    factory { provideOkHttpClient() }
}

fun provideOkHttpClient(): OkHttpClient {
    val interceptor = HttpLoggingInterceptor()
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

    return OkHttpClient.Builder()
        .writeTimeout(30 , TimeUnit.SECONDS)
        .readTimeout(30 , TimeUnit.SECONDS)
        .connectTimeout(30 , TimeUnit.SECONDS)
        .addInterceptor(interceptor)
        .build()
}

fun provideApi(retrofit : Retrofit) : ApiService {
    return retrofit.create(ApiService::class.java)
}

fun provideRetrofit(okHttpClient : OkHttpClient) : Retrofit {
    return Retrofit.Builder()
        .baseUrl(com.example.youtubehv6m6.BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
}
