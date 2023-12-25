package com.example.applivecurrency.data.repository

import androidx.lifecycle.LiveData
import com.example.applivecurrency.data.repository.db.CurrencyDao
import com.example.applivecurrency.domain.model.Currency
import com.example.applivecurrency.domain.payload.UpdateCurrencyRatesRequest

class CurrencyRepository(private val currencyDao:CurrencyDao){

    val readAllData : LiveData<List<Currency>> = currencyDao.getAllCurrencies()
    val getFavorites : LiveData<List<Currency>> = currencyDao.getFavorites()

    suspend fun insertCurrency(currency: Currency) = currencyDao.insertCurrency(currency)
    suspend fun updateCurrency(currency:Currency) = currencyDao.updateCurrency(currency)
    suspend fun deleteCurrency(currency: Currency) = currencyDao.deleteCurrency(currency)
    suspend fun updateCurrenciesRates(updateCurrenciesRates : List<UpdateCurrencyRatesRequest>) =
        currencyDao.updateCurrenciesRates(updateCurrenciesRates)
}