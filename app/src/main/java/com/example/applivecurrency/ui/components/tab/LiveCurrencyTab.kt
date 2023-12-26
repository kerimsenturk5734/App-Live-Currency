package com.example.applivecurrency.ui.components.tab

import SearchBar
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.applivecurrency.di.InstanceProvider
import com.example.applivecurrency.domain.model.Currency
import com.example.applivecurrency.ui.components.CurrencyCard
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

    //currencyViewModel.insertListOfCurrency(currencyTestList)

    val dbCurrencies = currencyViewModel.allCurrencies.observeAsState().value


    //Render live currencies
    if (dbCurrencies != null) {
        Toast.makeText(LocalContext.current, "Currencies Successfully Loaded", Toast.LENGTH_SHORT).show()

        var filteredCurrencies by remember { mutableStateOf(dbCurrencies) }

        SearchBar(onSearch = { query ->
            //Search process
            filteredCurrencies = dbCurrencies.filter { currency: Currency ->
                currency.symbol.contains(query, true)
            }
        })

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp)){

            items(filteredCurrencies){
                    currency ->
                CurrencyCard(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(horizontal = 15.dp, vertical = 5.dp),
                    currency = currency,
                    favoriteOnClick = { currencyViewModel.favoriteCurrency(currency) })
            }
        }
    }
}