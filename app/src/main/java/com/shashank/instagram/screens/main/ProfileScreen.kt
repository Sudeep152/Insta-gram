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

@Composable
fun ProfileScreen() {
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
        .background(Color(24, 24, 24))
        .fillMaxSize()) {
        ProfileInfo()
    }
}

@Composable
fun ProfileInfo() {

    Card(modifier = Modifier
        .fillMaxWidth()
        .wrapContentSize(),
        backgroundColor = Color(37, 39, 53),
        shape = RoundedCornerShape(bottomStart = 30.dp, bottomEnd = 30.dp)
    )
    {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(10.dp)) {
            Image(painter = painterResource(id = R.drawable.userdp),
                contentDescription = "test",
                Modifier
                    .size(106.dp)
                    .clip(
                        CircleShape)
                    .border(3.dp,
                        brush = Brush.linearGradient(listOf(Color(180, 11, 100),
                            Color(124, 31, 160))),
                        CircleShape),
                contentScale = ContentScale.Crop
            )
            Text(text = "Shashank Dahiya",
                style = TextStyle(fontSize = 25.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold))
            Text(text = "Native Android Developer ",
                style = TextStyle(fontSize = 15.sp, color = Color.White))
            Text(text = "\uD83D\uDCF7 #Developer #Android #Jetpack ",
                style = TextStyle(fontSize = 10.sp, color = Color(81, 91, 212)))

            Spacer(modifier = Modifier.height(15.dp))
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically) {
                Column(verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "24",
                        style = TextStyle(fontSize = 20.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold))
                    Text(text = "Post", style = TextStyle(fontSize = 13.sp, color = Color.White))

                }
                Column(verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "39",
                        style = TextStyle(fontSize = 20.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold))
                    Text(text = "Followers",
                        style = TextStyle(fontSize = 13.sp, color = Color.White))

                }
                Column(verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "44",
                        style = TextStyle(fontSize = 20.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold))
                    Text(text = "Following",
                        style = TextStyle(fontSize = 13.sp, color = Color.White))

                }
            }
            Spacer(modifier = Modifier.height(15.dp))
            IButton()
        }

    }

}
@Composable
fun  IButton(){

    Button(onClick = { /*TODO*/ }
     , colors = ButtonDefaults.buttonColors(
             backgroundColor = Color.Transparent

     ), shape = RoundedCornerShape(90.dp),   contentPadding = PaddingValues(),
        elevation =ButtonDefaults.elevation(
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
            Text(text = "Edit Profile", style = TextStyle(fontSize = 15.sp, color = Color.White, fontWeight = FontWeight.Bold) )

        }
    }


}

@Preview
@Composable
fun ScreePre() {
    ProfileScreen()
}