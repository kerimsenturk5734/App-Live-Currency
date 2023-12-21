package com.example.applivecurrency.ui.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
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
fun componentColor() : Color{
    return if(isSystemInDarkTheme()) Color(0xFF252525) else MaterialTheme.colorScheme.inversePrimary
}