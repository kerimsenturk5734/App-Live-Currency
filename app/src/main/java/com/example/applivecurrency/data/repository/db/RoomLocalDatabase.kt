package com.example.applivecurrency.data.repository.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.applivecurrency.domain.model.Currency

@Database(entities = [Currency::class], version = 3)
abstract class RoomLocalDatabase : RoomDatabase() {
    abstract fun currencyDao() : CurrencyDao
}