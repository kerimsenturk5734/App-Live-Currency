package com.example.applivecurrency.ui.components.bar

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.applivecurrency.R
import com.example.applivecurrency.ui.screens.appText
import com.example.applivecurrency.ui.components.componentColor
import com.example.applivecurrency.ui.components.foregroundColor
import com.example.applivecurrency.ui.util.Gif

@Composable
fun TopBannerBar() {
    TopAppBar(backgroundColor = componentColor()) {
        Gif(modifier = Modifier.padding(5.dp), gif = R.drawable.splash)
        Row(modifier = Modifier.fillMaxWidth()){
            Text(modifier = Modifier.fillMaxWidth(), text = appText(), textAlign = TextAlign.Center, color = foregroundColor())
        }
    }
}