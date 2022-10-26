package com.shashank.instagram.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shashank.instagram.screens.components.DummyStories
import  com.shashank.instagram.R


@Composable
fun NewFeedScreen() {

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color(24, 24, 24))) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize()
            .background(Color(24, 24, 24))) {
            DummyStories()
        }
        Spacer(modifier = Modifier.height(10.dp))

        Box(modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize()
            .padding(15.dp)) {


            LazyColumn() {
                item {
                    SinglePost(name = "Sas",
                        postPhoto = painterResource(id = R.drawable.covid),
                        description = "SACRIFICE | VIRUS this photomanipulation inspired in the virus ")
                    SinglePost(name = "Sas",
                        postPhoto = painterResource(id = R.drawable.covid),
                        description = "SACRIFICE | VIRUS this photomanipulation inspired in the virus ")
                    SinglePost(name = "Sas",
                        postPhoto = painterResource(id = R.drawable.covid),
                        description = "SACRIFICE | VIRUS this photomanipulation inspired in the virus ")
                }

            }


        }

    }

}

@Composable
fun SinglePost(name: String, postPhoto: Painter, description: String) {

    Card(modifier = Modifier
        .fillMaxWidth().padding(top = 5.dp, bottom = 5.dp)
        .wrapContentSize(), backgroundColor = Color(49, 50, 59), shape = RoundedCornerShape(10.dp)
    ) {
        Column() {
            Row(modifier = Modifier.wrapContentHeight(),
                verticalAlignment = Alignment.CenterVertically) {
                Box(modifier = Modifier
                    .wrapContentSize()
                    .padding(5.dp)) {
                    Image(painter = painterResource(id = R.drawable.userdp),
                        contentDescription = "dp",
                        modifier =
                        Modifier
                            .size(35.dp)
                            .clip(
                                CircleShape)
                    )
                }

                Column(
                    modifier = Modifier
                    .wrapContentSize()
                    .padding(3.dp)) {
                    Text(text = "Shashank152",
                        style = TextStyle(fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White))
                    Text(text = "30 minutes ago",
                        style = TextStyle(fontSize = 8.sp, color = Color.LightGray))

                }
            }

            Box(contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                .wrapContentSize()
                .padding(5.dp, top = 0.dp, end = 5.dp, bottom = 0.dp)) {
                Image(painter = postPhoto,
                    contentDescription = "img",
                    modifier = Modifier.size(300.dp),
                    contentScale = ContentScale.Fit
                )
                Icon(imageVector = Icons.Outlined.ThumbUp,
                    contentDescription = "icon",
                    modifier = Modifier
                        .align(
                            Alignment.BottomStart)
                        .padding(bottom = 25.dp, start = 10.dp),
                    tint = Color.White)
            }
            Text(text = description,
                style = TextStyle(color = Color.White),
                modifier = Modifier.padding(10.dp, top = 0.dp, bottom = 10.dp))


        }
    }


}