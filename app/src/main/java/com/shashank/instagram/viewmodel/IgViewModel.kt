package com.shashank.instagram.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.shashank.instagram.data.UserModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

const val  USER="users"
@HiltViewModel
class IgViewModel @Inject constructor(
    val auth: FirebaseAuth,
    val db:FirebaseFirestore,
    val storage: FirebaseStorage
):ViewModel() {

    val progressBar = mutableStateOf(false)
    val isSigned = mutableStateOf(false)
    val userData = mutableStateOf<UserModel?>(null)


    fun onSignUp(username:String,email:String,pass:String){
        progressBar.value=true
        db.collection(USER).whereEqualTo("username",username).get()
            .addOnSuccessListener { document->
                if (document.size() >0){
                    ErrorHandleing(customMsg = "username is already taken")
                    progressBar.value=true
                }else{
                    auth.createUserWithEmailAndPassword(email,pass)
                        .addOnCompleteListener{
                         if (it.isSuccessful){
                             isSigned.value=true
                             ///CREATE PROFILE




                         }else{
                             ErrorHandleing(it.exception,"Sign up failed")
                         }

                        }
                    progressBar.value=true

                }

            }
            .addOnFailureListener {

            }

    }


fun ErrorHandleing(e:Exception?=null, customMsg:String?=""){

}





}