package com.example.applivecurrency.ui.util

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun backgroundColor() : Color{
    return if(isSystemInDarkTheme()) Color.Black else Color.White
}

@Composable
fun foregroundColor() : Color{
    return if(isSystemInDarkTheme()) Color.White else Color(0xFF02076B)
}

@Composable
fun primaryComponentColor() : Color{
    return if(isSystemInDarkTheme()) Color(0xFF252525) else Color(0xFFF7CA5F)
}

@Composable
fun componentColor() : Color{
    return if(isSystemInDarkTheme()) Color(0xFF252525) else Color.White
}

@Composable
fun borderColor() : Color{
    return if(isSystemInDarkTheme()) Color.DarkGray else Color.Gray
}