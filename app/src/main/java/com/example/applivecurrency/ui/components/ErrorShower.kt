package com.example.applivecurrency.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.applivecurrency.R
import com.example.applivecurrency.ui.util.Screen
import com.example.applivecurrency.ui.util.foregroundColor

@Composable
fun ErrorShower(errorComponent: ErrorComponent, nav: NavController){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp)){

            when(errorComponent){
                ErrorComponent.NOT_FOUND -> NotFound()
                ErrorComponent.EMPTY_LIST -> EmptyList()
                ErrorComponent.UNAUTHORIZED -> Unauthorized()
            }
            if(errorComponent != ErrorComponent.EMPTY_LIST){
                IconButton(
                    modifier = Modifier.size(50.dp),
                    onClick = {nav.navigate(Screen.SPLASH_SCREEN.name)}
                ) {
                    val iconVector = Icons.Default.Refresh

                    Column(horizontalAlignment = Alignment.CenterHorizontally){
                        Icon(
                            imageVector = iconVector,
                            contentDescription = iconVector.name,
                            tint = foregroundColor()
                        )
                        Text(color= Color.Magenta,text = "Refresh")
                    }
                }
            }
        }
    }
}

enum class ErrorComponent{
    NOT_FOUND,
    EMPTY_LIST,
    UNAUTHORIZED
}

@Composable
private fun NotFound(){
    Image(
        modifier = Modifier.size(100.dp),
        painter = painterResource(id = R.drawable.notfound),
        contentDescription = "not_found")

    Text(
        text = "Currencies couldn't fetch \n Please check your connection",
        textAlign = TextAlign.Center,
        fontFamily = FontFamily.Monospace,
        color = foregroundColor()
    )
}

@Composable
private fun EmptyList(){
    Image(
        modifier = Modifier.size(100.dp),
        painter = painterResource(id = R.drawable.outofstock),
        contentDescription = "out_of_stock"
    )

    Text(
        text = "Your favorites list looking empty",
        textAlign = TextAlign.Center,
        fontFamily = FontFamily.Monospace,
        color = foregroundColor()
    )
}

@Composable
private fun Unauthorized(){
    Image(
        modifier = Modifier.size(100.dp),
        painter = painterResource(id = R.drawable.unauthorized),
        contentDescription = "unauthorized"
    )

    Text(
        text = "User unauthorized \n Please check your API KEY",
        textAlign = TextAlign.Center,
        fontFamily = FontFamily.Monospace,
        color = foregroundColor()
    )
}

