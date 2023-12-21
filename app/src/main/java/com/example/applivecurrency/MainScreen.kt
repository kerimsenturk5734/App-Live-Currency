package com.example.applivecurrency

import BottomNavigationBar
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

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
            RenderTab(tab = selectedTab)
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
               //Render live currency
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
