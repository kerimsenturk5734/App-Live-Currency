package com.example.applivecurrency.ui.components.tab

import SearchBar
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.applivecurrency.di.InstanceProvider
import com.example.applivecurrency.domain.model.Currency
import com.example.applivecurrency.ui.components.CurrencyCard
import com.example.applivecurrency.ui.components.ErrorComponent
import com.example.applivecurrency.ui.components.ErrorShower
import com.example.applivecurrency.ui.components.bar.InfoBar
import com.example.applivecurrency.ui.util.Screen
import com.example.applivecurrency.ui.util.foregroundColor
import com.example.applivecurrency.viewmodel.CurrencyViewModel
import java.util.Calendar

@Composable
fun LiveCurrencyTab(nav: NavController){
    val context = LocalContext.current

    val apiCurrencyViewModel = InstanceProvider.provideAPICurrencyViewModel(context)
    val status by apiCurrencyViewModel.statusCode.observeAsState(200)

    val currencyViewModel : CurrencyViewModel = InstanceProvider
        .provideCurrencyViewModel(context)

    val dbCurrencies by currencyViewModel.allCurrencies.observeAsState(emptyList())

    val isRefreshing by apiCurrencyViewModel.isRefreshing.collectAsState()

    Column{
        //Info Bar
        InfoBar(
            status = status.toString(),
            currencySize = dbCurrencies.size,
            lastUpdate = Calendar.getInstance().time)

        if(dbCurrencies.isEmpty())
            RenderError(status, nav)

        else{
            //Show a toast if data couldn't update
            InformWarning(status = status)

            //Filtered Currency list by search bar
            var filteredCurrencies by remember { mutableStateOf(dbCurrencies) }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(15.dp),
                modifier = Modifier.padding(10.dp)
            ){

               //Create SearchBar
               SearchBar(onSearch = { query ->
                   //Search process
                   filteredCurrencies = dbCurrencies.filter { currency: Currency ->
                       currency.symbol.contains(query, true)
                   }
               })

                if(isRefreshing.not()){
                    //Create a refresh button to refresh screen
                    IconButton(
                        modifier = Modifier.size(50.dp),
                        onClick = {nav.navigate(Screen.SPLASH_SCREEN.name)}
                    ) {
                        val iconVector = Icons.Default.Refresh

                        Column(horizontalAlignment = Alignment.CenterHorizontally){
                            Icon(
                                imageVector = iconVector,
                                contentDescription = iconVector.name
                            )
                            Text(color= foregroundColor(),text = "Refresh")
                        }
                    }
                }
                else{
                    CircularProgressIndicator()
                }
            }

            //Create Currency List in a lazy column
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ){

                items(filteredCurrencies){
                        currency ->
                    CurrencyCard(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(horizontal = 15.dp, vertical = 5.dp),
                        currency = currency,
                        favoriteOnClick = { currencyViewModel.favoriteCurrency(currency) }
                    )
                }
            }
        }

        LaunchedEffect(true) {
            apiCurrencyViewModel.refresh()
        }
    }
}

@Composable
fun RenderError(statusCode : Int?, nav: NavController){
    val apiCurrencyViewModel = InstanceProvider.provideAPICurrencyViewModel(LocalContext.current)
    when(statusCode){
        404 -> ErrorShower(errorComponent = ErrorComponent.NOT_FOUND)
        429 -> ErrorShower(errorComponent = ErrorComponent.UNAUTHORIZED)
        else -> Loading(nav = nav)
    }
}

@Composable
fun Loading(nav: NavController){

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp)){

            IconButton(
                modifier = Modifier.size(50.dp),
                onClick = {nav.navigate(Screen.SPLASH_SCREEN.name)}
            ) {
                val iconVector = Icons.Default.Refresh

                Icon(
                    imageVector = iconVector,
                    contentDescription = iconVector.name
                )
            }
        }
    }
}

@Composable
fun InformWarning(status : Int?){
    when(status){
        404 -> Toast.makeText(
            LocalContext.current,
            "Currencies couldn't refreshed. \n These currencies are out of date.",
            Toast.LENGTH_LONG).show()

        429 -> Toast.makeText(
            LocalContext.current,
            "Currencies couldn't refreshed. \n API denied the request. Please check your API KEY",
            Toast.LENGTH_LONG).show()

        else -> Toast.makeText(
            LocalContext.current,
            "Currencies Successfully Loaded",
            Toast.LENGTH_SHORT).show()
    }
}
