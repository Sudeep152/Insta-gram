package com.shashank.instagram.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.shashank.instagram.viewmodel.IgViewModel
import  com.shashank.instagram.R
import com.shashank.instagram.screens.main.profile.components.FollowFollowerPostBar
import com.shashank.instagram.screens.main.profile.components.MyPost
import com.shashank.instagram.screens.main.profile.components.ProfileFullInformation
import com.shashank.instagram.screens.main.profile.components.ProfilePhoto

@Composable
fun ProfileScreen(igViewModel: IgViewModel) {
//    navController: NavHostController, igViewModel: IgViewModel
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .wrapContentSize(Alignment.Center)
//    ) {
//        Text(
//            text = "Profile Screen",
//            fontWeight = FontWeight.Bold,
//            color = Color.Black,
//            modifier = Modifier.align(Alignment.CenterHorizontally),
//            textAlign = TextAlign.Center,
//            fontSize = 20.sp
//        )
//        Column() {
//            Text(text = "${igViewModel.userData.value}")
//        }
//    }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color(24, 24, 24))) {
        Column(modifier = Modifier
            .background(Color(24, 24, 24))
            .wrapContentWidth()) {
            ProfileInfo(igViewModel)
        }

        Spacer(modifier = Modifier.height(15.dp))
        postTagBar()
        MyPost()

    }


}


@Composable
fun postTagBar() {
    Column(modifier = Modifier.padding(5.dp)) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .background(Color(37, 39, 53), shape = RoundedCornerShape(10.dp))
            .wrapContentHeight(), horizontalArrangement = Arrangement.SpaceEvenly) {
            DesginText(text = "Post")
            DesginText(text = "Tag")
        }

    }

}

@Composable
fun DesginText(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(text = text,
        style = TextStyle(fontSize = 20.sp, color = Color.White, fontWeight = FontWeight.Bold),
        modifier = Modifier.padding(5.dp)
    )
}


@Composable
fun ProfileInfo(viewModel: IgViewModel) {

    val userData = viewModel.userData.value
    Card(modifier = Modifier
        .fillMaxWidth()
        .wrapContentSize(),
        backgroundColor = Color(37, 39, 53),
        shape = RoundedCornerShape(bottomStart = 30.dp, bottomEnd = 30.dp)
    )
    {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(10.dp)) {
            ProfileFullInformation(imageUrl = userData?.imageUri.toString(),
                username = userData?.username.toString(),
                userbio = userData?.bio.toString())
            Spacer(modifier = Modifier.height(15.dp))
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically) {
                FollowFollowerPostBar(title = "Post", valueS = "24")
                FollowFollowerPostBar(title = "Followers", valueS = "39")
                FollowFollowerPostBar(title = "Follow", valueS = "50")
            }
            Spacer(modifier = Modifier.height(15.dp))
            IButton()
        }

    }

}

@Composable
fun IButton() {

    Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
        backgroundColor = Color.Transparent

    ), shape = RoundedCornerShape(90.dp), contentPadding = PaddingValues(),
        elevation = ButtonDefaults.elevation(
            focusedElevation = 15.dp
        )

    ) {

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .height(30.dp)
                .width(200.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(brush = Brush.linearGradient(listOf(Color(180, 11, 100),
                    Color(124, 31, 160))))
        ) {
            Text(text = "Edit Profile",
                style = TextStyle(fontSize = 15.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold))

        }
    }


}

@Preview
@Composable
fun ScreePre() {

}