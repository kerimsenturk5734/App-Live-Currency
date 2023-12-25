package com.example.applivecurrency.data.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.applivecurrency.data.repository.db.CurrencyDao
import com.example.applivecurrency.data.repository.db.RoomLocalDatabase
import com.example.applivecurrency.domain.model.Currency
import com.example.applivecurrency.domain.payload.UpdateCurrencyRatesRequest
import kotlinx.coroutines.InternalCoroutinesApi

class CurrencyRepository(private val currencyDao:CurrencyDao){
    companion object {
        @Volatile
        private var INSTANCE : CurrencyRepository? = null

        @OptIn(InternalCoroutinesApi::class)
        fun getInstance(context : Context) : CurrencyRepository {
            var tempInstance = INSTANCE

            if(tempInstance != null)
                return tempInstance

            synchronized(this) {
                val instance = CurrencyRepository(RoomLocalDatabase.getInstance(context).currencyDao())

                tempInstance = instance

                return instance
            }
        }
    }

    val readAllData : LiveData<List<Currency>> = currencyDao.getAllCurrencies()
    val getFavorites : LiveData<List<Currency>> = currencyDao.getFavorites()

    suspend fun insertCurrency(currency: Currency) = currencyDao.insertCurrency(currency)
    suspend fun updateCurrency(currency:Currency) = currencyDao.updateCurrency(currency)
    suspend fun deleteCurrency(currency: Currency) = currencyDao.deleteCurrency(currency)
    suspend fun updateCurrenciesRates(updateCurrenciesRates : List<UpdateCurrencyRatesRequest>) =
        currencyDao.updateCurrenciesRates(updateCurrenciesRates)
}