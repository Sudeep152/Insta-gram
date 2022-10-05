package com.shashank.instagram.main

import android.app.Notification
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.shashank.instagram.R
import com.shashank.instagram.viewmodel.IgViewModel

@Composable
fun NotificationMessage(vm: IgViewModel) {
    val conte = LocalContext.current
    val notifState = vm.popNotification.value
    val notificationMsg = notifState?.getContentOrNull()
    if (notificationMsg != null) {
        Toast.makeText(conte, notificationMsg, Toast.LENGTH_SHORT).show()
    }


}

@Preview
@Composable
fun LoadingScreen(){


    Box(modifier = Modifier.fillMaxSize()) {

        Surface(
            color = Color.Black.copy(0.5f), modifier = Modifier
                .fillMaxSize()

        ) {

            Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                val compositionResult by rememberLottieComposition(spec =
                LottieCompositionSpec.RawRes(R.raw.loading))

                LottieAnimation(composition = compositionResult, contentScale = ContentScale.Fit, iterations = Int.MAX_VALUE
                    , modifier = Modifier.size(70.dp), isPlaying = true, restartOnPlay = true
                )
            }



        }
    }




}