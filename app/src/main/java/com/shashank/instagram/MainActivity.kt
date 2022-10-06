package com.shashank.instagram

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.Surface
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.shashank.instagram.navigation.setUpNavGraph
import com.shashank.instagram.screens.splash.SplashScreen
import com.shashank.instagram.ui.theme.InstagramTheme
import dagger.hilt.android.AndroidEntryPoint
import com.google.accompanist.navigation.animation.navigation
import com.google.accompanist.navigation.animation.composable

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("SuspiciousIndentation")
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

                 val navController = rememberAnimatedNavController()
                    setUpNavGraph(navController = navController)





        }
    }
}

