package com.example.applivecurrency.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.applivecurrency.domain.model.Currency
import com.example.applivecurrency.ui.util.backgroundColor
import com.example.applivecurrency.ui.util.foregroundColor
import com.example.applivecurrency.ui.util.primaryComponentColor


@Composable
fun CurrencyCard(
    modifier: Modifier = Modifier,
    currency: Currency,
    favoriteOnClick:() -> Unit = {}){

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(4.dp)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            backgroundColor(),
                            primaryComponentColor()
                        ),
                        tileMode = TileMode.Mirror
                    )
                )
                .padding(3.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically){

            AsyncImage(
                modifier = Modifier
                    .size(30.dp)
                    .clip(CircleShape),

                contentScale = ContentScale.Crop,
                model = currency.imageURL,
                contentDescription = "${currency.symbol}_icon"
            )

            Row(
                modifier =
                Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically){

                Text(text = annotateCurrencyName(currency.symbol), color = foregroundColor())
                Text(
                    modifier = Modifier.fillMaxWidth(0.4f),
                    text = annotateCurrencyRate(currency.rate),
                    color = foregroundColor(),
                    textAlign = TextAlign.Center)

                Row(modifier =
                        Modifier
                            .fillMaxWidth(0.6f)){

                    Text(
                        modifier = Modifier.fillMaxWidth(0.8f),
                        text = annotateCurrencyChange(currency.change),
                        textAlign = TextAlign.Center)
                    Icon(
                        imageVector = if (currency.change >= 0) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                        contentDescription = null,
                        tint = if (currency.change >= 0) Color.Green else Color.Red,
                        modifier = Modifier.size(24.dp)
                    )
                }

                var isIconChanged by remember { mutableStateOf(false) }
                IconButton(
                    onClick = {
                        isIconChanged = !isIconChanged
                        favoriteOnClick()
                    }
                ) {
                    Icon(
                        imageVector = if(isIconChanged) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = "Favorite")
                }
            }



        }
    }
}

fun annotateCurrencyName(text: String): AnnotatedString {
    return buildAnnotatedString{
        withStyle(
            style = SpanStyle(
                fontSize = 17.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = FontFamily.Monospace)
        ){
            append(text)
        }
    }
}

fun annotateCurrencyRate(rate: Double): AnnotatedString {
    return buildAnnotatedString{
        withStyle(
            style = SpanStyle(
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
            )
        ){
            append(rate.toString())
        }
    }
}

fun annotateCurrencyChange(change: Double): AnnotatedString {
    val isIncreasing = change > 0
    val isDecreasing = change < 0

    return buildAnnotatedString{
        withStyle(
            style = SpanStyle(
                fontSize = 17.sp,
                fontWeight = FontWeight.Medium,
                color = if(isIncreasing) Color.Green else if(isDecreasing) Color.Red else Color.White,
                fontFamily = FontFamily.Monospace
            )
        ){
            if(isIncreasing) append("+") else if(!isDecreasing) append(" ")
            append(change.toString())
            append("%")
        }
    }
}

@Composable
fun CreateCurrencyCardList(
    modifier: Modifier = Modifier,
    currencies:List<Currency>){

    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp)){

        items(currencies){
                currency ->
            CurrencyCard(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(horizontal = 15.dp, vertical = 5.dp),
                currency = currency)
        }
    }
}

