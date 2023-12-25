package com.example.applivecurrency.data.repository.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.applivecurrency.domain.model.Currency
import com.example.applivecurrency.domain.payload.UpdateCurrencyRatesRequest
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(entities = [Currency::class, UpdateCurrencyRatesRequest::class], version = 1)
abstract class RoomLocalDatabase : RoomDatabase() {
    abstract fun currencyDao() : CurrencyDao

    companion object {
        @Volatile
        private var INSTANCE : RoomLocalDatabase? = null

        @OptIn(InternalCoroutinesApi::class)
        fun getInstance(context : Context) : RoomLocalDatabase {
            var tempInstance = INSTANCE

            if(tempInstance != null)
                return tempInstance

            synchronized(this){
                val instance = Room
                    .databaseBuilder(context, RoomLocalDatabase::class.java, "app_live_currency_db")
                    .build()

                tempInstance = instance

                return instance
            }
        }
    }
}