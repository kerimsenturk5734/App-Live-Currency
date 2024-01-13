package com.example.applivecurrency.data.api.payload

import com.example.applivecurrency.domain.model.APICurrency
import java.util.Date

data class CurrencyToAllResult(
    val base:String,
    val lastUpdate:Date,
    val data: List<APICurrency>)
