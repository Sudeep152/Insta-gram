package com.shashank.instagram.screens.splash

import android.annotation.SuppressLint
import androidx.annotation.RestrictTo.Scope
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Colors
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.airbnb.lottie.compose.*
import com.shashank.instagram.R
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.shashank.instagram.sealed.Screen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.logging.Handler

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun SplashScreen(navController: NavController) {


    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color(0, 0, 0)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(220.dp))
        LottieLoader()
        Spacer(modifier = Modifier.height(200.dp))
        Column(modifier = Modifier
            .wrapContentSize()
            .padding(100.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Text(text = "from",
                modifier = Modifier.fillMaxWidth(),
                color = Color.LightGray,
                textAlign = TextAlign.Center)
            Image(modifier = Modifier
                .size(110.dp)
                .wrapContentSize(),
                painter = painterResource(id = R.drawable.metalogo),
                contentDescription = "metalogf")


        }


    }

   LaunchedEffect(key1 = true){
       delay(2000)
       navController.navigate(Screen.LoginScreen.route){
           popUpTo(0)
       }
   }


}


@Composable
fun LottieLoader() {
//
    val compositionResult by rememberLottieComposition(spec =
    LottieCompositionSpec.RawRes(R.raw.instagram_icon)
    )
    LottieAnimation(composition = compositionResult, contentScale = ContentScale.Inside,
        modifier = Modifier.size(150.dp), iterations = Int.MAX_VALUE
    )


}


@Preview
@Composable
fun showScreen() {
    SplashScreen(navController = rememberNavController())

}



