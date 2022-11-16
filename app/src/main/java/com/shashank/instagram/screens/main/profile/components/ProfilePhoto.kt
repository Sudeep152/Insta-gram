package com.shashank.instagram.screens.main.profile.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.shashank.instagram.R

@Composable
fun ProfilePhoto(imgUrl:String,storyRing:Boolean){

    val painter  = rememberImagePainter(data = imgUrl)
    Image(painter = painter,
        contentDescription = "test",
        Modifier
            .size(106.dp)
            .clip(
                CircleShape)
            .border(3.dp,
                brush =
                Brush.linearGradient(listOf(Color(180, 11, 100),
                    Color(124, 31, 160))),
                CircleShape),
        contentScale = ContentScale.Crop
    )
}
