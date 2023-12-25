package com.example.applivecurrency.ui.components.tab

import SearchBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import com.example.applivecurrency.R
import com.example.applivecurrency.di.InstanceProvider
import com.example.applivecurrency.domain.model.Currency
import com.example.applivecurrency.ui.components.CreateCurrencyCardList
import com.example.applivecurrency.ui.components.CurrencyTestDto
import com.example.applivecurrency.viewmodel.CurrencyViewModel


@Composable
fun LiveCurrencyTab(){
    val currencyViewModel : CurrencyViewModel = InstanceProvider
        .provideCurrencyViewModel(LocalContext.current)

    val currencyTestList = listOf<Currency>(
        Currency(
            symbol = "USD", rate = 29.95, change = -1.27,
            imageURL =
            "https://t4.ftcdn.net/jpg/01/34/67/51/240_F_134675192_TC1KncAkC6EAEBDxXj5Uy1900F1ZbJ6v.jpg"),
        Currency(
            symbol = "EUR", rate = 31.95, change = -1.03,
            imageURL =
            "https://t4.ftcdn.net/jpg/01/34/67/51/240_F_134675192_TC1KncAkC6EAEBDxXj5Uy1900F1ZbJ6v.jpg"),
        Currency(
            symbol = "GBP", rate = 12.95, change = 1.7,
            imageURL =
            "https://t4.ftcdn.net/jpg/01/34/67/51/240_F_134675192_TC1KncAkC6EAEBDxXj5Uy1900F1ZbJ6v.jpg"),
        Currency(
            symbol = "JPY", rate = 15.5, change = 0.0,
            imageURL =
            "https://t4.ftcdn.net/jpg/01/34/67/51/240_F_134675192_TC1KncAkC6EAEBDxXj5Uy1900F1ZbJ6v.jpg")
    )

    currencyViewModel.insertListOfCurrency(currencyTestList)

    val dbCurrenciesState = currencyViewModel.allCurrencies.value

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