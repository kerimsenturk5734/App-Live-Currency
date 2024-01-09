package com.example.applivecurrency.data.api

import com.example.applivecurrency.data.api.payload.APICurrencyToAllResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APICurrencyDao {
    @GET("currencyToAll")
    fun callCurrencyToAll(@Query("base") base: String, @Query("int") int: Int) : Call<APICurrencyToAllResponse>
}