package com.shashank.instagram.sealed

sealed class Screen(val route:String) {

    object SplashScreen:Screen("splash_screen")
    object LoginScreen:Screen("login_screen")
    object SignUpScreen:Screen("signup_screen")
    object HomeScreen:Screen("home_screen")
    object EditProfileScreen:Screen("edit_profile")
}