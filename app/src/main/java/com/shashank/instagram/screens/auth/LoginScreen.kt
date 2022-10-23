package com.shashank.instagram.screens.auth

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.shashank.instagram.R
import com.shashank.instagram.main.LoadingScreen
import com.shashank.instagram.main.checkAutoLogin
import com.shashank.instagram.sealed.Screen
import com.shashank.instagram.viewmodel.IgViewModel


@Composable
fun LoginScreen(navController: NavController,igViewModel: IgViewModel) {

    val emailState = remember {
        mutableStateOf(TextFieldValue())
    }

    val passwordState = remember {
        mutableStateOf(TextFieldValue())
    }
    checkAutoLogin(igViewModel = igViewModel,navController)
    Box(contentAlignment = Alignment.Center, modifier = Modifier
        .fillMaxSize()
        .background(Color(0, 0, 0))) {

        Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(20.dp)) {
            rememberScrollState()
            InstagramLogo(painter = painterResource(id = R.drawable.instagram_logo))





            Box(modifier = Modifier
                .padding(top = 25.dp)
                .fillMaxWidth()
                .height(55.dp)) {
                val maxLength = 100
                val lightBlue = Color(24, 24, 24)
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = emailState.value,
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
                        emailState.value = it
                    },
                    placeholder = {
                        Text(text = "Mobile Number or Email", fontSize = 14.sp)
                    },
                    shape = RoundedCornerShape(8.dp),
                    singleLine = true,

                )
            }










            Box(modifier = Modifier
                .padding(top = 25.dp)
                .fillMaxWidth()
                .height(55.dp)) {
                val maxLength = 100
                val lightBlue = Color(24, 24, 24)
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = passwordState.value,
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
                        passwordState.value = it
                    },
                    placeholder = {
                        Text(text = "Password", fontSize = 14.sp)
                    },
                    visualTransformation = PasswordVisualTransformation(),
                    shape = RoundedCornerShape(8.dp),
                    singleLine = true,
                    trailingIcon = {
                        if (passwordState.value.text.isNotEmpty()) {
                            IconButton(onClick = {
                                passwordState.value = (TextFieldValue(""))
                            }) {
                                Icon(
                                    imageVector = Icons.Outlined.Close,
                                    contentDescription = null
                                )
                            }
                        }
                    }
                )


            }





            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp), contentAlignment = Alignment.BottomEnd) {
                Text(text = "Forget password?", color = Color(0, 136, 248))
            }
            MyButton(text = "Log in",
                click = {
                   igViewModel.onLogin(emailState.value.text,passwordState.value.text)
                }
            )
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
            TwoCustomText(
                firstText = "Don't have an account? ",
                secondText = " Sign Up.",
                textSize = 13,
               click = {
                    navController.navigate(Screen.SignUpScreen.route) {

                    }
                }
            )

        }

    }

    if(igViewModel.progressBar.value){
        LoadingScreen()
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
fun InstagramLogo(painter: Painter, modifier: Modifier = Modifier) {
    Image(painter = painter,
        contentDescription = "logo"
    , modifier = modifier
    )

}


@Composable
fun MyButton(text: String, modifier: Modifier = Modifier, click: () -> Unit) {

    val context = LocalContext.current
    Button(onClick = {
        click()
    },
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
fun TwoCustomText(
    firstText: String,
    secondText: String,
    modifier: Modifier = Modifier,
    textSize: Int,
    click: () -> Unit
) {

    Text(
        text = buildAnnotatedString {
            append(firstText)

            withStyle(
                style = SpanStyle(color = Color(0, 136, 248), fontSize = textSize.sp)
            ) {
                append(secondText)
            }


        },
        fontSize = textSize.sp, color = Color(129, 129, 129),

        modifier = Modifier.clickable {
            click()
        }
        )

}


