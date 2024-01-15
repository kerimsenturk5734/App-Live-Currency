package com.example.applivecurrency.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.applivecurrency.data.repository.CurrencyRepository
import com.example.applivecurrency.di.InstanceProvider
import com.example.applivecurrency.domain.model.Currency
import kotlinx.coroutines.launch

class CurrencyViewModel(vmContext: Context) : ViewModel(){

    //Inject repository instance
    private val currencyRepository : CurrencyRepository = InstanceProvider
        .provideCurrencyRepository(vmContext)


    val allCurrencies = currencyRepository.readAllData
    val favoriteCurrencies = currencyRepository.getFavorites

    fun updateCurrency(currency: Currency) {
        viewModelScope.launch {
            currencyRepository.updateCurrency(currency)
        }
    }

    fun upsertCurrenciesFields(currencies: List<Currency>){
        viewModelScope.launch{
            currencyRepository.upsertCurrenciesFields(currencies)
        }
    }
    fun favoriteCurrency(currency: Currency) {
        //Toggle the favorite state
        currency.isFavorite = !currency.isFavorite

        //Update the currency
        updateCurrency(currency)
    }


}