package com.example.applivecurrency.ui.components.tab

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.LocalContext
import com.example.applivecurrency.di.InstanceProvider
import com.example.applivecurrency.domain.model.Currency
import com.example.applivecurrency.ui.components.CreateCurrencyCardList
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
            "https://cdn-icons-png.flaticon.com/512/733/733324.png"),
        Currency(
            symbol = "GBP", rate = 12.95, change = 1.7,
            imageURL =
            "https://cdn-icons-png.flaticon.com/512/10593/10593703.png"),
        Currency(
            symbol = "JPY", rate = 15.5, change = 0.0,
            imageURL =
            "https://cdn-icons-png.flaticon.com/512/11197/11197819.png\n")
    )

    currencyViewModel.insertListOfCurrency(currencyTestList)

    val dbCurrenciesState = currencyViewModel.allCurrencies.observeAsState().value

    //Render live currencies
    if (dbCurrenciesState != null) {
        Toast.makeText(LocalContext.current, "Currencies Successfully Loaded", Toast.LENGTH_SHORT).show()
        CreateCurrencyCardList(currencies = dbCurrenciesState)
    }
}