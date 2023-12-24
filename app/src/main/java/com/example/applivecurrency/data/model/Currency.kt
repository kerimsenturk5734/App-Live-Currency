package com.example.applivecurrency.data.model

import androidx.annotation.DrawableRes

data class Currency(
    val name: String,
    val rate: Double,
    val change: Double,
    @DrawableRes val image: Int
)
