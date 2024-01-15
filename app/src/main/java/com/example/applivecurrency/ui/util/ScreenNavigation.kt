package com.example.applivecurrency.ui.util

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.applivecurrency.ui.screens.MainScreen
import com.example.applivecurrency.ui.screens.SplashScreen
import com.example.applivecurrency.ui.screens.Trial

@Composable
fun ScreenNavigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.SPLASH_SCREEN.name){
        composable(route = Screen.SPLASH_SCREEN.name){
            SplashScreen(navController = navController)
        }

        composable(route = Screen.MAIN_SCREEN.name){
            MainScreen(navController = navController)
        }

        composable(route = Screen.TRIAL_SCREEN.name){
            Trial()
        }
    }
}

enum class Screen(screenName: String){
    SPLASH_SCREEN("splash_screen"),
    MAIN_SCREEN("main_screen"),
    TRIAL_SCREEN("trial_screen")
}