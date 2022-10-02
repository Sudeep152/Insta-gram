package com.shashank.instagram.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.shashank.instagram.main.NotificationMessage
import com.shashank.instagram.screens.auth.LoginScreen
import com.shashank.instagram.screens.auth.SignUpScreen
import com.shashank.instagram.screens.splash.SplashScreen
import com.shashank.instagram.sealed.Screen
import com.shashank.instagram.viewmodel.IgViewModel

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun setUpNavGraph(navController: NavHostController) {

    NavHost(navController =
    navController, startDestination = Screen.SplashScreen.route) {
        composable(route = Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.LoginScreen.route) {


            val igViewModel = hiltViewModel<IgViewModel>()
            NotificationMessage(vm = igViewModel)




            LoginScreen(navController, igViewModel)
        }
        composable(route = Screen.SignUpScreen.route) {

            val igViewModel = hiltViewModel<IgViewModel>()
            NotificationMessage(vm = igViewModel)
            SignUpScreen(navController = navController, igViewModel)
        }

    }

}

