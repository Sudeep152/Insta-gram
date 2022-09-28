package com.shashank.instagram.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.shashank.instagram.screens.auth.LoginScreen
import com.shashank.instagram.screens.auth.SignUpScreen
import com.shashank.instagram.screens.splash.SplashScreen
import com.shashank.instagram.sealed.Screen
import com.shashank.instagram.viewmodel.IgViewModel

@Composable
fun setUpNavGraph(navController: NavHostController) {

    NavHost(navController =
    navController, startDestination = Screen.SplashScreen.route) {
        composable(route = Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.LoginScreen.route) {

            val igViewModel = hiltViewModel<IgViewModel>()

            LoginScreen(navController, igViewModel)
        }
        composable(route=Screen.SignUpScreen.route){
            val igViewModel = hiltViewModel<IgViewModel>()
            SignUpScreen(navController = navController, igViewModel = igViewModel)
        }

    }

}

