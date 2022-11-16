package com.shashank.instagram.screens.main.profile.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.shashank.instagram.viewmodel.IgViewModel

@Composable
fun  ProfileFullInformation(imageUrl :String,username:String,userbio:String) {
    ProfilePhoto(imgUrl = imageUrl, storyRing =true )
    Text(text = username,
        style = TextStyle(fontSize = 25.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold))
    Text(text = userbio,
        style = TextStyle(fontSize = 15.sp, color = Color.White))
}