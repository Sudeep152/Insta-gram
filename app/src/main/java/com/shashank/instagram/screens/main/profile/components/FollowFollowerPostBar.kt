package com.shashank.instagram.screens.main.profile.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


@Composable
fun FollowFollowerPostBar(title:String,valueS :String,modifier: Modifier=Modifier) {
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = valueS,
            style = TextStyle(fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold))
        Text(text = title, style = TextStyle(fontSize = 13.sp, color = Color.White))

    }
}