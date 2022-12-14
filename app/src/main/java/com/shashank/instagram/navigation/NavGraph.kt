@file:OptIn(ExperimentalAnimationApi::class)

package com.shashank.instagram.navigation

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.runtime.*

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.shashank.instagram.main.NotificationMessage
import com.shashank.instagram.screens.auth.LoginScreen
import com.shashank.instagram.screens.auth.SignUpScreen
import com.shashank.instagram.screens.home.HomeScreen
import com.shashank.instagram.screens.main.profile.EditProfileScreen
import com.shashank.instagram.screens.splash.SplashScreen
import com.shashank.instagram.sealed.Screen
import com.shashank.instagram.viewmodel.IgViewModel

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun setUpNavGraph(navController: NavHostController) {


    AnimatedNavHost(navController =
    navController, startDestination = Screen.SplashScreen.route) {
        composable(route = Screen.SplashScreen.route, enterTransition = {
            slideIntoContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(200))
        },
            exitTransition = {
                slideOutOfContainer(AnimatedContentScope.SlideDirection.Left,
                    animationSpec = tween(200))
            },
            popEnterTransition = {
                slideIntoContainer(AnimatedContentScope.SlideDirection.Right,
                    animationSpec = tween(200))
            },
            popExitTransition = {
                slideOutOfContainer(AnimatedContentScope.SlideDirection.Right,
                    animationSpec = tween(200))
            }

        ) {

            SplashScreen(navController = navController)


        }
        composable(route = Screen.LoginScreen.route,
            enterTransition = {
                slideIntoContainer(AnimatedContentScope.SlideDirection.Left,
                    animationSpec = tween(200))
            },
            exitTransition = {
                slideOutOfContainer(AnimatedContentScope.SlideDirection.Left,
                    animationSpec = tween(200))
            },
            popEnterTransition = {
                slideIntoContainer(AnimatedContentScope.SlideDirection.Right,
                    animationSpec = tween(200))
            },
            popExitTransition = {
                slideOutOfContainer(AnimatedContentScope.SlideDirection.Right,
                    animationSpec = tween(200))
            }

        ) {


            val igViewModel = hiltViewModel<IgViewModel>()
            NotificationMessage(vm = igViewModel)




            LoginScreen(navController, igViewModel)

        }
        composable(route = Screen.SignUpScreen.route,
            enterTransition = {
                slideIntoContainer(AnimatedContentScope.SlideDirection.Left,
                    animationSpec = tween(200))
            },
            exitTransition = {
                slideOutOfContainer(AnimatedContentScope.SlideDirection.Left,
                    animationSpec = tween(200))
            },
            popEnterTransition = {
                slideIntoContainer(AnimatedContentScope.SlideDirection.Right,
                    animationSpec = tween(200))
            },
            popExitTransition = {
                slideOutOfContainer(AnimatedContentScope.SlideDirection.Right,
                    animationSpec = tween(200))
            }
        ) {

            val igViewModel = hiltViewModel<IgViewModel>()
            NotificationMessage(vm = igViewModel)

            SignUpScreen(navController = navController, igViewModel)

        }
        composable(route = Screen.HomeScreen.route
        ,   enterTransition = {
                slideIntoContainer(AnimatedContentScope.SlideDirection.Left,
                    animationSpec = tween(100))
            },
            exitTransition = {
                slideOutOfContainer(AnimatedContentScope.SlideDirection.Left,
                    animationSpec = tween(100))
            },
            popEnterTransition = {
                slideIntoContainer(AnimatedContentScope.SlideDirection.Right,
                    animationSpec = tween(100))
            },
            popExitTransition = {
                slideOutOfContainer(AnimatedContentScope.SlideDirection.Right,
                    animationSpec = tween(100))
            }
        ){

            val igViewModel = hiltViewModel<IgViewModel>()
            HomeScreen(navController = navController, igViewModel =igViewModel )
        }



    }

}


