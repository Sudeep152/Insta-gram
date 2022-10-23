package com.shashank.instagram.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.shashank.instagram.R
import com.shashank.instagram.viewmodel.IgViewModel


@Composable
fun DummyStories(){

    val igViewModel= hiltViewModel<IgViewModel>()
    Column() {
        Row {

            LazyRow(content = {
             item {
                 UserStorySection(igViewModel = igViewModel)
                 SingleStory(name = "Shashank", profilePic = painterResource(id = R.drawable.dptest))
                 SingleStory(name = "Shashank", profilePic = painterResource(id = R.drawable.dptest))
                 SingleStory(name = "Shashank", profilePic = painterResource(id = R.drawable.dptest))
                 SingleStory(name = "Shashank", profilePic = painterResource(id = R.drawable.dptest))
                 SingleStory(name = "Shashank", profilePic = painterResource(id = R.drawable.dptest))
                 SingleStory(name = "Shashank", profilePic = painterResource(id = R.drawable.dptest))
             }
            })


        }
    }

}




@Composable
fun UserStorySection(igViewModel: IgViewModel){

    val username = igViewModel.userData.value?.name

    Column(modifier = Modifier
        .wrapContentSize()
        .padding(5.dp), horizontalAlignment = Alignment.CenterHorizontally) {


        Image(painter = painterResource(id = R.drawable.userdp), contentDescription ="dp",modifier= Modifier
            .size(60.dp)
            .clip(
                CircleShape)
            .border(3.dp,
                brush = Brush.linearGradient(listOf(Color(180, 11, 100), Color(124, 31, 160))),
                CircleShape)
            , contentScale = ContentScale.Crop

        )
        Text(text = username.toString(), style = TextStyle(fontSize = 12.sp, color = Color.LightGray))
    }

}







@Composable
fun SingleStory(name:String, profilePic:Painter, modifier: Modifier=Modifier){

    Column(modifier = modifier
        .wrapContentSize()
        .padding(5.dp), horizontalAlignment = Alignment.CenterHorizontally) {


        Image(painter = profilePic, contentDescription ="dp",modifier= Modifier
            .size(60.dp)
            .clip(
                CircleShape)
            .border(3.dp,
                brush = Brush.linearGradient(listOf(Color(180, 11, 100), Color(124, 31, 160))),
                CircleShape)
            , contentScale = ContentScale.Crop

        )
        Text(text = name, style = TextStyle(fontSize = 12.sp, color = Color.LightGray))
    }
}

@Preview
@Composable
fun ShowScreen(){
    SingleStory(name = "Shashank", profilePic = painterResource(id = R.drawable.dptest) )
    
}