package com.example.applivecurrency.ui.components.tab

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.applivecurrency.di.InstanceProvider
import com.example.applivecurrency.ui.components.CurrencyCard
import com.example.applivecurrency.ui.components.ErrorComponent
import com.example.applivecurrency.ui.components.ErrorShower
import com.example.applivecurrency.viewmodel.CurrencyViewModel

@Composable
fun FavoritesTab(nav : NavController){
    val currencyViewModel : CurrencyViewModel = InstanceProvider
        .provideCurrencyViewModel(LocalContext.current)

    val myFavoriteCurrencies = currencyViewModel
        .favoriteCurrencies
        .observeAsState()
        .value?.toMutableList()

    if(myFavoriteCurrencies != null){

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp)){
            items(myFavoriteCurrencies){
                    currency ->
                CurrencyCard(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(horizontal = 15.dp, vertical = 5.dp),
                    currency = currency,
                    icon = Icons.Default.Clear,
                    favoriteOnClick = {
                        currencyViewModel.favoriteCurrency(currency)
                        myFavoriteCurrencies.remove(currency)
                    }
                )
            }
        }

        if(myFavoriteCurrencies.isEmpty())
            ErrorShower(errorComponent = ErrorComponent.EMPTY_LIST, nav = nav)
    }
}