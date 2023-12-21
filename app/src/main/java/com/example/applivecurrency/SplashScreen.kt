package com.example.applivecurrency

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.applivecurrency.ui.components.Screen
import com.example.applivecurrency.util.Gif
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(if (isSystemInDarkTheme()) Color.Black else Color.White)
    ) {
        Box(modifier= Modifier.fillMaxHeight(), contentAlignment = Alignment.Center){
            Gif(modifier = Modifier.padding(bottom = 250.dp), gif = R.drawable.splash)
        }
        Box(modifier= Modifier
            .fillMaxSize()
            .padding(bottom = 50.dp), contentAlignment = Alignment.BottomCenter){
            Text(text = buildAnnotatedString {
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
            })
        }
    }

    LaunchedEffect(true) {
        //Check the internet Connection
        //If it is exist
        // Then request to api end wait until coming
        // Write to db the have gotten data
        //Read from db
        delay(3000)
        navController.navigate(Screen.MAIN_SCREEN.name)
        //navigate to next screen with gotten data
    }
}