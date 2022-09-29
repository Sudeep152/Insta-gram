package com.shashank.instagram.screens.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.shashank.instagram.R
import com.shashank.instagram.viewmodel.IgViewModel


@Composable
fun SignUpScreen(navController: NavController,igViewModel: IgViewModel){


    Surface(modifier = Modifier.fillMaxSize(), color = Color(0,0,0)){
        Column(horizontalAlignment = Alignment.CenterHorizontally,  modifier = Modifier.padding(30.dp)) {
            rememberScrollState()
            InstagramLogo(painter = painterResource(id = R.drawable.instagram_logo))
            Text(text = "Sign up to see photos and videos", color = Color(129,129,129))
            Text(text = "from your friends" ,color = Color(129,129,129))
            MyButton(text = "Log in with Facebook"){}
            Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Box(modifier = Modifier
                    .padding(top = 5.dp)
                    .heightIn(0.19f.dp)
                    .width(50.dp)
                    .background(Color(129, 129, 129)))
                Text(text = " OR " ,color = Color(129,129,129), fontWeight =FontWeight.Bold)
                Box(modifier = Modifier
                    .padding(top = 5.dp)
                    .heightIn(0.19f.dp)
                    .width(50.dp)
                    .background(Color(129, 129, 129)))
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                EdtTextField(hint = "Mobile Number or Email")
                EdtTextField(hint = "Full Name")
                EdtTextField(hint = "Username")
                EdtTextField(hint = "Password")
                MyButton(text = "Sign Up") {

                    ////BUtton
                    //CALL
                    //Handle





                }
                Spacer(modifier = Modifier
                    .heightIn(20.dp)
                    .fillMaxWidth())
                TwoCustomText(
                    firstText = "Have an account? ",
                    secondText = " Log in.",
                    textSize = 13,
                     click = {

                    }
                )
            }




        }


    }



}


