package com.shashank.instagram.screens.main.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.shashank.instagram.main.LoadingScreen

import com.shashank.instagram.viewmodel.IgViewModel


@SuppressLint("UnrememberedMutableState")
@Composable
fun EditProfileScreen(igViewModel: IgViewModel, navHostController: NavHostController) {

    val isLoading = igViewModel.progressBar.value;
    if (isLoading) {
        LoadingScreen()
    } else {
        val userData = igViewModel.userData.value;
        var name by rememberSaveable {
            mutableStateOf(userData?.name ?: "")
        }
        var bio by rememberSaveable {
            mutableStateOf(userData?.bio ?: "")
        }
        var profileImg by rememberSaveable {
            mutableStateOf(userData?.imageUri ?: "")
        }

        ProfileContent(igViewModel, name, bio, profileImg, onNameChange = {
            name = it
        }, onBioChange = {
            bio = it
        },
            onImageChange = {
                profileImg = it
            }, onSave = {

            }, onBack = {

            }, onLogout = {

            }
        )


    }

}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ProfileContent(
    vm: IgViewModel, name: String, bio: String, imageUri: String,
    onNameChange: (String) -> Unit,
    onBioChange: (String) -> Unit,
    onImageChange: (String) -> Unit,
    onSave: () -> Unit,
    onBack: () -> Unit,
    onLogout: () -> Unit,
) {
    
    var scroll = rememberScrollState();

        Column(modifier = Modifier
            .verticalScroll(scroll)
            .fillMaxSize()) {

            Text(text = "Helllo")



        }

    



}