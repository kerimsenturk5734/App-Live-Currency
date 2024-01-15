package com.example.applivecurrency.ui.components.bar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.applivecurrency.R
import com.example.applivecurrency.ui.screens.Tab
import com.example.applivecurrency.ui.util.backgroundColor
import com.example.applivecurrency.ui.util.borderColor

@Composable
fun BottomNavigationBar(selectedTab: Tab, onTabSelected: (Tab) -> Unit) {
    BottomAppBar(
        contentPadding = PaddingValues(0.dp),
    ) {
        Row(
            modifier = Modifier
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            backgroundColor(),
                            borderColor()
                        ),
                        tileMode = TileMode.Mirror
                    )
                )
                .fillMaxSize()
                .padding(horizontal = 20.dp, vertical = 10.dp)
                .clip(RoundedCornerShape(10.dp)),

            horizontalArrangement = Arrangement.spacedBy(70.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            BottomNavigationItem(
                modifier = Modifier
                    .background(
                        if (selectedTab == Tab.LIVE_CURRENCY) borderColor() else Color.Transparent),
                icon = { Image(
                    modifier = Modifier
                        .size(26.dp),
                    painter = painterResource(id = R.drawable.exchange),
                    contentDescription = "Currencies") },

                label = { Text(
                    text = "Currencies",
                    color = Color.White,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.Bold) },

                selected = selectedTab == Tab.LIVE_CURRENCY,
                onClick = { onTabSelected(Tab.LIVE_CURRENCY) }
            )
            BottomNavigationItem(
                modifier = Modifier
                    .background(
                        if (selectedTab == Tab.FAVORITES) borderColor() else Color.Transparent),
                icon = { Image(
                    modifier = Modifier
                        .size(26.dp),
                    painter = painterResource(id = R.drawable.favoriteicon),
                    contentDescription = "Favorites") },

                label = { Text(
                    text = "Favorites",
                    color = Color.White,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.Bold)},

                selected = selectedTab == Tab.FAVORITES,
                onClick = { onTabSelected(Tab.FAVORITES) }
            )
        }
    }
}