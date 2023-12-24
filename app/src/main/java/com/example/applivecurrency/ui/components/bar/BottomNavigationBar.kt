package com.example.applivecurrency.ui.components.bar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.example.applivecurrency.R
import com.example.applivecurrency.ui.screens.Tab
import com.example.applivecurrency.ui.util.backgroundColor
import com.example.applivecurrency.ui.util.borderColor
import com.example.applivecurrency.ui.util.componentColor
import com.example.applivecurrency.ui.util.foregroundColor

@Composable
fun BottomNavigationBar(selectedTab: Tab, onTabSelected: (Tab) -> Unit) {
    BottomAppBar(
        modifier = Modifier
            .background(backgroundColor())
            .border(1.dp, borderColor(), RoundedCornerShape(50.dp))
            .shadow(elevation = 1.dp, RoundedCornerShape(100.dp)),
        contentPadding = PaddingValues(0.dp),
    ) {
        Row(
            modifier = Modifier
                .background(componentColor())
                .fillMaxSize()
                .clip(RoundedCornerShape(50.dp)),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BottomNavigationItem(
                icon = { Image(
                    modifier = Modifier.size(26.dp),
                    painter = painterResource(id = R.drawable.exchange),
                    contentDescription = "Currencies") },

                label = { Text("Currencies", color = foregroundColor(), fontFamily = FontFamily.Monospace) },
                selected = selectedTab == Tab.LIVE_CURRENCY,
                onClick = { onTabSelected(Tab.LIVE_CURRENCY) }
            )
            BottomNavigationItem(
                icon = { Image(
                    modifier = Modifier.size(26.dp),
                    painter = painterResource(id = R.drawable.favoriteicon),
                    contentDescription = "Favorites") },

                label = { Text("Favorites", color = foregroundColor(), fontFamily = FontFamily.Monospace)},
                selected = selectedTab == Tab.FAVORITES,
                onClick = { onTabSelected(Tab.FAVORITES) }
            )
            BottomNavigationItem(
                icon = { Image(
                    modifier = Modifier.size(26.dp),
                    painter = painterResource(id = R.drawable.calculator),
                    contentDescription = "Calculator") },

                label = { Text("Calculator", color = foregroundColor(), fontFamily = FontFamily.Monospace) },
                selected = selectedTab == Tab.CALCULATOR,
                onClick = { onTabSelected(Tab.CALCULATOR) }
            )
        }
    }
}