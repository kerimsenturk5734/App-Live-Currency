package com.example.applivecurrency.ui.components.tab

import SearchBar
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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

    val dbCurrencies = currencyViewModel.allCurrencies.observeAsState().value


    //Render live currencies
    if (dbCurrencies != null) {
        //Toast.makeText(LocalContext.current, "Currencies Successfully Loaded", Toast.LENGTH_SHORT).show()

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
    }else{
        //Loading...
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }
}