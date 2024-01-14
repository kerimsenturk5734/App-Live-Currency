package com.example.applivecurrency.ui.screens

import com.example.applivecurrency.ui.components.bar.BottomNavigationBar
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
import com.example.applivecurrency.ui.components.tab.FavoritesTab
import com.example.applivecurrency.ui.components.tab.LiveCurrencyTab
import com.example.applivecurrency.ui.util.backgroundColor
import com.example.applivecurrency.ui.components.bar.TopBannerBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController){
    var selectedTab by remember { mutableStateOf(Tab.LIVE_CURRENCY) }

    Scaffold(
        topBar = { TopBannerBar()},
        bottomBar = {
            BottomNavigationBar(selectedTab = selectedTab) {
                selectedTab = it
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundColor())
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            RenderTab(
                modifier = Modifier
                    .fillMaxSize()
                    .background(backgroundColor()),
                tab = selectedTab,
                nav = navController)
        }
    }
}


@Composable
fun RenderTab(
    modifier: Modifier = Modifier,
    tab: Tab?,
    nav: NavController){

   Column(modifier = modifier.padding(5.dp)){
       when(tab){
           Tab.LIVE_CURRENCY -> LiveCurrencyTab(nav)
           Tab.FAVORITES -> FavoritesTab()

           else -> Text("Content not found")
       }
   }
}



enum class Tab{
    LIVE_CURRENCY,
    FAVORITES,
}
