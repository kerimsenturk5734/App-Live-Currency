package com.example.applivecurrency.ui.components.bar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.applivecurrency.ui.util.foregroundColor
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun InfoBar(status: String, currencySize: Int,lastUpdate: Date){
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxWidth()
            .background(foregroundColor())
            .padding(3.dp)
    ){
        Text(text = "Status: $status", color = Color.Magenta, fontSize = 11.sp)
        Text(text = "Currency Count: $currencySize", color = Color.Magenta, fontSize = 11.sp)
        Text(text = "Last Update: ${lastUpdate.toString("yyyy/MM/dd HH:mm:ss")}", color = Color.Magenta, fontSize = 11.sp)
    }
}

fun Date.toString(format: String, locale: Locale = Locale.getDefault()): String {
    val formatter = SimpleDateFormat(format, locale)
    return formatter.format(this)
}