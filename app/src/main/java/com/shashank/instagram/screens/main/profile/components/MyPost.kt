package com.shashank.instagram.screens.main.profile.components
import  com.shashank.instagram.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun MyPost() {

    Column() {
    SinglePost(painter = painterResource(id = R.drawable.post))
        SinglePost(painter = painterResource(id = R.drawable.post))
    }
}

@Composable
fun SinglePost(painter: Painter) {

    Box(modifier = Modifier.padding(10.dp)
        .height(150.dp)
        .height(80.dp)) {
        Image(painter = painter, contentDescription = "post")
    }

}
