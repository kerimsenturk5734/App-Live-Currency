package com.example.applivecurrency.ui.components.tab

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.applivecurrency.R
import com.example.applivecurrency.di.InstanceProvider
import com.example.applivecurrency.ui.components.CurrencyCard
import com.example.applivecurrency.ui.util.foregroundColor
import com.example.applivecurrency.viewmodel.CurrencyViewModel

@Composable
fun FavoritesTab(){
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

        if(myFavoriteCurrencies.isEmpty()){
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(20.dp)){
                    Image(
                        modifier = Modifier.size(100.dp),
                        painter = painterResource(id = R.drawable.outofstock),
                        contentDescription = "out_of_stock")

                    Text(
                        text = "Your favorites list looking empty",
                        textAlign = TextAlign.Center,
                        fontFamily = FontFamily.Monospace,
                        color = foregroundColor())
                }
            }
        }


    }
}