package com.shashank.instagram.screens.auth

import android.util.Log
import android.view.RoundedCorner
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.shashank.instagram.R
import com.shashank.instagram.navigation.setUpNavGraph
import com.shashank.instagram.sealed.Screen
import com.shashank.instagram.viewmodel.IgViewModel

@Composable
fun LoginScreen(navController: NavController, igViewModel: IgViewModel) {

    fun natv(){
        navController.navigate(Screen.SignUpScreen.route){

        }
    }

    Box(contentAlignment = Alignment.Center, modifier = Modifier
        .fillMaxSize()
        .background(Color(0, 0, 0))) {

        Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(20.dp)) {
            Image(painter = painterResource(id = R.drawable.instagram_logo),
                contentDescription = "logo")
            EdtTextField(hint = "Phone number, username or email")
            EdtTextField(hint = "Password")
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp), contentAlignment = Alignment.BottomEnd){
                Text(text = "Forget password?", color =Color(0, 136, 248) )
            }
            MyButton(text = "Log in", click = { natv() })
            Spacer(modifier = Modifier
                .heightIn(50.dp)
                .fillMaxWidth())
            Box(modifier = Modifier
                .padding(top = 5.dp)
                .heightIn(0.19f.dp)
                .fillMaxWidth()
                .background(Color(129, 129, 129)))
            Spacer(modifier = Modifier
                .heightIn(30.dp)
                .fillMaxWidth())
            TwoCustomText(firstText = "Don't have an account? ", secondText = " Sign Up.", textSize = 13,
            modifier  = Modifier.clickable {
              navController.navigate(Screen.SignUpScreen.route){

              }

            })

        }

    }

}

@Composable
fun EdtTextField(hint: String) {


    Box(modifier = Modifier
        .padding(top = 25.dp)
        .fillMaxWidth()
        .height(55.dp)) {
        var textState by remember { mutableStateOf("") }
        val maxLength = 100
        val lightBlue = Color(24, 24, 24)
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = textState,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = lightBlue,
                textColor = Color.White,
                cursorColor = Color(0, 136, 248),
                disabledLabelColor = lightBlue,
                placeholderColor = Color(129, 129, 129),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            onValueChange = {
                if (it.length <= maxLength) textState = it
            },
            placeholder = {
                Text(text = "$hint", fontSize = 14.sp)
            },
            shape = RoundedCornerShape(8.dp),
            singleLine = true,
            trailingIcon = {
                if (textState.isNotEmpty()) {
                    IconButton(onClick = { textState = "" }) {
                        Icon(
                            imageVector = Icons.Outlined.Close,
                            contentDescription = null
                        )
                    }
                }
            }
        )


    }


}




@Composable
fun MyButton(text: String,modifier: Modifier=Modifier,click:()-> Unit={

}) {

    Button(onClick = { Log.d("TAG" ,"click") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 18.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0, 136, 248)
        )
    ) {
        Text(text = text, color = Color.White)

    }


}


@Composable
fun TwoCustomText(firstText:String,secondText:String,modifier: Modifier=Modifier,textSize:Int){
    
    Text( text =  buildAnnotatedString {
        append(firstText)

        withStyle(
            style = SpanStyle(color = Color(0, 136, 248), fontSize = textSize.sp)
        ) {
            append(secondText)
        }

    }
    , fontSize = textSize.sp, color = Color(129, 129, 129)
    ,
    )

}