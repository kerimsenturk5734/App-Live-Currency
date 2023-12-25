package com.example.applivecurrency.ui.components.tab

import SearchBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.applivecurrency.R
import com.example.applivecurrency.ui.components.CreateCurrencyCardList
import com.example.applivecurrency.ui.components.CurrencyTestDto


@Composable
fun LiveCurrencyTab(){
    val currencyList = listOf(
        CurrencyTestDto(symbol = "EUR", rate = 10.20, change = -0.8, image = R.drawable.dollar),
        CurrencyTestDto(symbol = "GBP", rate = 11.80, change = 1.2, image = R.drawable.dollar),
        CurrencyTestDto(symbol = "JPY", rate = 0.07, change = -0.3, image = R.drawable.dollar),
        CurrencyTestDto(symbol = "CNY", rate = 1.30, change = 0.0, image = R.drawable.dollar),
        CurrencyTestDto(symbol = "JPY", rate = 0.07, change = -0.333, image = R.drawable.dollar),
        CurrencyTestDto(symbol = "CNY", rate = 1.30, change = 0.9, image = R.drawable.dollar),
        CurrencyTestDto(symbol = "JPY", rate = 0.07, change = -0.3, image = R.drawable.dollar),
        CurrencyTestDto(symbol = "CNY", rate = 1.30, change = 0.9, image = R.drawable.dollar),
    )

    val currencies by remember { mutableStateOf(currencyList) }
    var filteredCurrencies by remember { mutableStateOf(currencies) }

    SearchBar(onSearch = { query ->
        //Search process
        filteredCurrencies = currencies.filter { currency: CurrencyTestDto ->
            currency.symbol.contains(query, true)
        }
    })

    //Render live currencies
    CreateCurrencyCardList(currencies = filteredCurrencies)
}