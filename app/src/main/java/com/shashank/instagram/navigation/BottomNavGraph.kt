package com.shashank.instagram.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.shashank.instagram.screens.bottom.*
import com.shashank.instagram.screens.main.NewFeedScreen
import com.shashank.instagram.screens.main.ProfileScreen
import com.shashank.instagram.sealed.BottomNavItem
import com.shashank.instagram.viewmodel.IgViewModel

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun BottomNavGraph(navController: NavHostController) {

    AnimatedNavHost(navController = navController, startDestination = BottomNavItem.HomeNavItem.route ){

        composable(route = BottomNavItem.HomeNavItem.route,enterTransition = {
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
        ){
            NewFeedScreen()
        }
        composable(route=BottomNavItem.SearchNavItem.route, enterTransition = {
            slideIntoContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(200))

        }, exitTransition = {
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

        ){
            SearchScreen()
        }
        composable(route = BottomNavItem.AddPostNavItem.route, enterTransition = {
            slideIntoContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(200))

        }, exitTransition = {
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


        ){
          AddPostScreen()
        }

        composable(BottomNavItem.NotificationNavItem.route, enterTransition = {
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
        ){
            NotificationScreen()
        }

        composable(BottomNavItem.ProfileNavItem.route, enterTransition = {
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

        ){

            val igViewModel = hiltViewModel<IgViewModel>()
            ProfileScreen(igViewModel)
        }

    }
}