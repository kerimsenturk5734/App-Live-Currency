package com.example.applivecurrency.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.applivecurrency.R
import com.example.applivecurrency.di.InstanceProvider
import com.example.applivecurrency.ui.util.Screen
import com.example.applivecurrency.ui.util.Gif
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    val apiCurrencyViewModel = InstanceProvider.provideAPICurrencyViewModel(LocalContext.current)

    //  Update/Insert the db with currency values matching with 1 unit TRY
    apiCurrencyViewModel.fetchCurrencyToAll("TRY", 1)

    val isLoading by apiCurrencyViewModel.isLoading.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(if (isSystemInDarkTheme()) Color.Black else Color.White)
    ) {
        Box(modifier= Modifier.fillMaxHeight(), contentAlignment = Alignment.Center){
            Gif(modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 250.dp),
                gif = R.drawable.splash
            )
        }
        Box(modifier= Modifier
            .fillMaxSize()
            .padding(bottom = 50.dp), contentAlignment = Alignment.BottomCenter){
            Text(text = appText())
        }
    }

    LaunchedEffect(true) {
        delay(3000)

        //If fetching done navigate
        if (isLoading.not())
            navController.navigate(Screen.MAIN_SCREEN.name)

    }
}

@Composable
fun appText():AnnotatedString{
    return buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                fontSize = 32.sp,
                fontFamily = FontFamily.Cursive,
                fontWeight = FontWeight.Bold,
                color = if(isSystemInDarkTheme()) Color.White else Color(0xFF02076B)
            )
        ){
            append("Live Currency")
        }
    }
}