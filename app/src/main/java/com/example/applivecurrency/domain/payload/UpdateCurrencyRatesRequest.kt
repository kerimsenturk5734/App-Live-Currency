package com.example.applivecurrency.domain.payload

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UpdateCurrencyRatesRequest(
    @PrimaryKey
    @ColumnInfo(name = "symbol")
    val symbol : String,
    @ColumnInfo(name = "rate")
    val rate : Double,
    @ColumnInfo(name = "change")
    val change : Double
)
