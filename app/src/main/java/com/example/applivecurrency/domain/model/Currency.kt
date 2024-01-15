package com.example.applivecurrency.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "currencies")
data class Currency(
    @PrimaryKey()
    @ColumnInfo(name = "symbol")
    val symbol: String,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "rate")
    val rate: Double,

    @ColumnInfo(name = "change")
    val change: Double,

    @ColumnInfo(name = "image")
    val imageURL: String,

    @ColumnInfo(name = "is_favorite")
    var isFavorite : Boolean = false
)
