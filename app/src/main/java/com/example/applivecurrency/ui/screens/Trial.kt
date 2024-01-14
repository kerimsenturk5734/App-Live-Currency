package com.example.applivecurrency.ui.screens

import com.example.applivecurrency.viewmodel.APICurrencyViewModel
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState

import androidx.compose.ui.platform.LocalContext

/*
    THIS COMPOSABLE CLASS CREATED TO TEST SOME FUNCTIONALITIES
*/
@Composable
fun Trial() {
    // UI is composed using the Composable functions
    // The UI reacts to the LiveData updates using the collectAsState extension function
    /*val viewModel = APICurrencyViewModel(LocalContext.current)
    val error = viewModel.error.observeAsState().value

    //val a by viewModel.currencyData.observeAsState()
    // A Column is a Composable that places its children in a vertical sequence
    Column {
        // Display the data or error based on the state
        Text(text = "Error: $error", color = MaterialTheme.colors.error)
       // Text(text = "val: ${a?.size}", color = MaterialTheme.colors.error)
        // Trigger the data fetching when the Composable is first created
        LaunchedEffect(true) {
            viewModel.fetchCurrencyToAll("USD", 1)
        }
    }*/
}