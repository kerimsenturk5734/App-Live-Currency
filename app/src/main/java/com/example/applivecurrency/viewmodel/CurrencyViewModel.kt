package com.example.applivecurrency.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.applivecurrency.data.repository.CurrencyRepository
import com.example.applivecurrency.di.InstanceProvider
import com.example.applivecurrency.domain.model.Currency
import com.example.applivecurrency.domain.payload.UpdateCurrencyRatesRequest
import kotlinx.coroutines.launch

class CurrencyViewModel(vmContext: Context) : ViewModel(){

    //Inject repository instance
    private val currencyRepository : CurrencyRepository = InstanceProvider
        .provideCurrencyRepository(vmContext)

    val allCurrencies = currencyRepository.readAllData
    val favoriteCurrencies = currencyRepository.getFavorites

    fun insertCurrency(currency: Currency) {
        viewModelScope.launch {
            currencyRepository.insertCurrency(currency)
        }
    }

    fun insertListOfCurrency(currencyList: List<Currency>) {
        viewModelScope.launch {
            currencyRepository.insertListOfCurrency(currencyList)
        }
    }

    fun updateCurrency(currency: Currency) {
        viewModelScope.launch {
            currencyRepository.updateCurrency(currency)
        }
    }

    fun deleteCurrency(currency: Currency) {
        viewModelScope.launch {
            currencyRepository.deleteCurrency(currency)
        }
    }

    //This method will be using by api service to update db if net connection exist !!!
    fun updateCurrenciesRates(updateCurrenciesRates: List<UpdateCurrencyRatesRequest>) {
        viewModelScope.launch {
            currencyRepository.updateCurrenciesRates(updateCurrenciesRates)
        }
    }
}