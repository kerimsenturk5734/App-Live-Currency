package com.example.applivecurrency.domain

import com.example.applivecurrency.domain.model.APICurrency
import com.example.applivecurrency.domain.model.Currency
import com.example.applivecurrency.ui.util.CurrencyIcon

class CurrencyMapper {
    fun apiCurrencyToCurrency(from: APICurrency) : Currency{
        return Currency(
            symbol = from.code,
            name = from.name,
            rate = from.calculated,
            change = 0.0,
            imageURL = CurrencyIcon.getOrDefault(from.code, "https://cdn-icons-png.flaticon.com/512/11948/11948471.png"),
            isFavorite = false)
    }
    fun apiCurrenciesToCurrencies(fromList: List<APICurrency>) : List<Currency>{
        return fromList.map { apiCurrencyToCurrency(it) }
    }
}