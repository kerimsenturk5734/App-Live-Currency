package com.example.applivecurrency.domain.model

data class APICurrency(
    val code: String,
    val name:String,
    val rate:Double,
    val calculatedStr:String,
    val calculated:Double)
