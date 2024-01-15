package com.example.applivecurrency.data.api

import com.example.applivecurrency.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APICurrencyService {
    //API Root Endpoint
    private const val BASE_URL = "https://api.collectapi.com/economy/"

    //API KEY
    private const val API_KEY = BuildConfig.API_KEY

    private val client: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(Interceptor { chain ->
            val original = chain.request()
            val requestBuilder = original.newBuilder()
                .header("authorization", "apikey $API_KEY")
                .header("content-type", "application/json")
            val request = requestBuilder.build()
            chain.proceed(request)
        })
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: APICurrencyDao = retrofit.create(APICurrencyDao::class.java)
}