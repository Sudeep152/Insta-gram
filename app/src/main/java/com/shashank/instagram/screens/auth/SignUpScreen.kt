package com.shashank.instagram.screens.auth

import android.widget.Toast
import androidx.compose.foundation.background
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.shashank.instagram.R
import com.shashank.instagram.main.LoadingScreen
import com.shashank.instagram.main.checkAutoLogin
import com.shashank.instagram.sealed.Screen
import com.shashank.instagram.viewmodel.IgViewModel


@Composable
fun SignUpScreen(navController: NavController, igViewModel: IgViewModel) {
    val context = LocalContext.current

    val usernameState = remember {
        mutableStateOf(TextFieldValue())
    }
    val emailState = remember {
        mutableStateOf(TextFieldValue())
    }
    val fullNameState = remember {
        mutableStateOf(TextFieldValue())
    }
    val passwordState = remember {
        mutableStateOf(TextFieldValue())
    }
checkAutoLogin(igViewModel = igViewModel, navController =navController )

    Surface(modifier = Modifier.fillMaxSize(), color = Color(0, 0, 0)) {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(30.dp)) {
            rememberScrollState()
            InstagramLogo(painter = painterResource(id = R.drawable.instagram_logo))
            Text(text = "Sign up to see photos and videos", color = Color(129, 129, 129))
            Text(text = "from your friends", color = Color(129, 129, 129))
            MyButton(text = "Log in with Facebook") {}
            Row(horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically) {
                Box(modifier = Modifier
                    .padding(top = 5.dp)
                    .heightIn(0.19f.dp)
                    .width(50.dp)
                    .background(Color(129, 129, 129)))
                Text(text = " OR ", color = Color(129, 129, 129), fontWeight = FontWeight.Bold)
                Box(modifier = Modifier
                    .padding(top = 5.dp)
                    .heightIn(0.19f.dp)
                    .width(50.dp)
                    .background(Color(129, 129, 129)))
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {


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
                        trailingIcon = {
//                            if (emailState.value.text.isNotEmpty()) {
//                                IconButton(onClick = { emailState.value.text.  }) {
//                                    Icon(
//                                        imageVector = Icons.Outlined.Close,
//                                        contentDescription = null
//                                    )
//                                }
//                            }
                        }
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
                        value = fullNameState.value,
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
                            fullNameState.value = it
                        },
                        placeholder = {
                            Text(text = "Full Name", fontSize = 14.sp)
                        },
                        shape = RoundedCornerShape(8.dp),
                        singleLine = true,
                        trailingIcon = {
//                            if (fullNameState.isNotEmpty()) {
//                                IconButton(onClick = { fullNameState = "" }) {
//                                    Icon(
//                                        imageVector = Icons.Outlined.Close,
//                                        contentDescription = null
//                                    )
//                                }
//                            }
                        }
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
                        value = usernameState.value,
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
                            usernameState.value = it
                        },
                        placeholder = {
                            Text(text = "Username", fontSize = 14.sp)
                        },
                        shape = RoundedCornerShape(8.dp),
                        singleLine = true,
                        trailingIcon = {
//                            if (usernameState.isNotEmpty()) {
//                                IconButton(onClick = { usernameState = "" }) {
//                                    Icon(
//                                        imageVector = Icons.Outlined.Close,
//                                        contentDescription = null
//                                    )
//                                }
//                            }
                        }
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







                MyButton(text = "Sign Up") {


//                    Toast.makeText(context,emailState.value.text.toString(),Toast.LENGTH_SHORT).show()
                    ////BUtton
                    //CALL
                    //Handle
                    igViewModel.onSignUp(usernameState.value.text,
                        emailState.value.text,
                        passwordState.value.text,fullNameState.value.text)


                }
                Spacer(modifier = Modifier
                    .heightIn(20.dp)
                    .fillMaxWidth())
                TwoCustomText(
                    firstText = "Have an account? ",
                    secondText = " Log in.",
                    textSize = 13,
                    click = {
                       navController.popBackStack()
                    }
                )
            }


        }


    }

    val isLoading = igViewModel.progressBar.value
    if (isLoading){
        LoadingScreen()
    }

}


