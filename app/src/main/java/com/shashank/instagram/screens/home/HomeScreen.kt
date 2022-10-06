package com.shashank.instagram.screens.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.shashank.instagram.viewmodel.IgViewModel

@Composable
fun HomeScreen(navController: NavHostController, igViewModel: IgViewModel) {
Surface(modifier = Modifier.fillMaxSize()) {
    Text(text = "Hello ${igViewModel.userData.value}")
}

}