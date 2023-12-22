package com.example.applivecurrency.ui.components.tab

import SearchBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.applivecurrency.ui.components.TestCurrencyCard

@Composable
fun LiveCurrencyTab(){
    var searchResult by remember { mutableStateOf("") }

    SearchBar(onSearch = { query ->
        //Search process
    })

    //Render live currencies
    TestCurrencyCard()
}