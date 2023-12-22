package com.example.applivecurrency.ui.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun backgroundColor() : Color{
    return if(isSystemInDarkTheme()) Color.Black else Color.White
}

@Composable
fun foregroundColor() : Color{
    return if(isSystemInDarkTheme()) Color.White else Color.Black
}

@Composable
fun primaryComponentColor() : Color{
    return if(isSystemInDarkTheme()) Color(0xFF252525) else Color(0xFF7EA7F3)
}

@Composable
fun componentColor() : Color{
    return if(isSystemInDarkTheme()) Color(0xFF252525) else Color(0xFFACACAC)
}

@Composable
fun borderColor() : Color{
    return if(isSystemInDarkTheme()) Color.DarkGray else Color.Gray
}