package com.example.applivecurrency.ui.components.tab

import SearchBar
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import com.example.applivecurrency.ui.components.ErrorComponent
import com.example.applivecurrency.ui.components.ErrorShower
import com.example.applivecurrency.viewmodel.CurrencyViewModel


@Composable
fun LiveCurrencyTab(){
    val context = LocalContext.current

    val apiCurrencyViewModel = InstanceProvider.provideAPICurrencyViewModel(context)
    val error by apiCurrencyViewModel.error.observeAsState()

    val currencyViewModel : CurrencyViewModel = InstanceProvider
        .provideCurrencyViewModel(context)

    val dbCurrencies by currencyViewModel.allCurrencies.observeAsState(emptyList())
    

    Column{
        //Render live currencies
        Text(text = "Error: $error", color = MaterialTheme.colors.error)

        if(dbCurrencies.isEmpty())
            RenderError(errorCode = error)

        else{
            //Show a toast if data couldn't update
            InformError(errorCode = error)

            var filteredCurrencies by remember { mutableStateOf(dbCurrencies) }
            //Create SearchBar
            SearchBar(onSearch = { query ->
                //Search process
                filteredCurrencies = dbCurrencies.filter { currency: Currency ->
                    currency.symbol.contains(query, true)
                }
            })

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
fun Loading(){

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp)){

            CircularProgressIndicator()
        }
    }
}

@Composable
fun RenderError(errorCode : Int?){
    when(errorCode){
        404 -> ErrorShower(errorComponent = ErrorComponent.EMPTY_LIST)
        429 -> ErrorShower(errorComponent = ErrorComponent.UNAUTHORIZED)
        else -> Text(text = "Bir sorun yok")
    }
}

@Composable
fun InformError(errorCode : Int?){
    when(errorCode){
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
