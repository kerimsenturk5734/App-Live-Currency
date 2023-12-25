package com.example.applivecurrency.data.repository.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.applivecurrency.domain.model.Currency
import com.example.applivecurrency.domain.payload.UpdateCurrencyRatesRequest


@Database(entities = [Currency::class, UpdateCurrencyRatesRequest::class], version = 1)
abstract class RoomLocalDatabase : RoomDatabase() {
    abstract fun currencyDao() : CurrencyDao
}