package com.example.applivecurrency.ui.screens

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.applivecurrency.data.repository.CurrencyRepository
import com.example.applivecurrency.di.InstanceProvider
import com.example.applivecurrency.ui.util.ScreenNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val currencyRepository : CurrencyRepository = InstanceProvider.provideCurrencyRepository(applicationContext)
            ScreenNavigation()
            Toast.makeText(this, currencyRepository.getFavorites.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}



