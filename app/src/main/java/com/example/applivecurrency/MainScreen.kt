package com.example.applivecurrency

import BottomNavigationBar
import SearchBar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.applivecurrency.ui.components.backgroundColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController){
    var selectedTab by remember { mutableStateOf(Tab.LIVE_CURRENCY) }

    Scaffold(
        bottomBar = {
            BottomNavigationBar(selectedTab = selectedTab) {
                selectedTab = it
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            RenderTab(
                modifier = Modifier
                    .fillMaxSize()
                    .background(backgroundColor()),
                tab = selectedTab)
        }
    }
}


@Composable
fun RenderTab(
    modifier: Modifier = Modifier,
    tab:Tab?){

   Column(modifier = modifier){
       when(tab){
           Tab.LIVE_CURRENCY -> {
               var searchResult by remember { mutableStateOf("") }
               //Render live currency
               Column(modifier = Modifier.padding(5.dp)){
                   SearchBar(onSearch = { query ->
                      //Arama işlemi
                   })

                   Text(text = searchResult)
               }
           }
           Tab.FAVORITES -> {
               //Render favorite currencies list
           }
           Tab.CALCULATOR ->{
               //Render currency calculator
           }

           else -> {
               print("Content not found")
           }
       }
   }
}


enum class Tab{
    LIVE_CURRENCY,
    FAVORITES,
    CALCULATOR
}
