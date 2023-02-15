package com.example.myapplication99974

import android.window.SplashScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication99974.View.RegistrationPage


@Composable

fun SetUppNewController() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Screen") {
        composable("Screen") {
            SplashScreenAnimate (navController = navController)
        }


        composable("LoginPage", content = {
            LoginPage(navController = navController)
        })


        composable("RegistrationPage", content = {
            RegistrationPage(navController = navController)
        })

    }


}