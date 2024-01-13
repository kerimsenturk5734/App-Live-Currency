package com.example.applivecurrency.domain

import com.example.applivecurrency.domain.model.APICurrency
import com.example.applivecurrency.domain.model.Currency

class CurrencyMapper {
    fun apiCurrencyToCurrency(from: APICurrency) : Currency{
        return Currency(
            symbol = from.code,
            rate = from.calculated,
            change = 0.0,
            imageURL = "https://cdn-icons-png.flaticon.com/512/10593/10593703.png",
            isFavorite = false)
    }
    fun apiCurrenciesToCurrencies(fromList: List<APICurrency>) : List<Currency>{
        return fromList.map { apiCurrencyToCurrency(it) }
    }
}