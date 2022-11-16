package com.shashank.instagram.viewmodel

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.auth.User
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.storage.FirebaseStorage
import com.shashank.instagram.data.Event
import com.shashank.instagram.data.UserModel
import com.shashank.instagram.main.NotificationMessage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

const val USER = "users"

@HiltViewModel
class IgViewModel @Inject constructor(
    val auth: FirebaseAuth,
    val db: FirebaseFirestore,
    val storage: FirebaseStorage,
) : ViewModel() {


    val progressBar = mutableStateOf(false)
    val isSigned = mutableStateOf(false)
    val userData = mutableStateOf<UserModel?>(null)
    val popNotification = mutableStateOf<Event<String>?>(null)



    init {

      //  auth.signOut()
        val currentUser = auth.currentUser
        isSigned.value = currentUser!=null
        currentUser?.uid?.let {getUserData(it)
        }


    }


    fun onSignUp(username: String, email: String, pass: String, fullName: String,imageUrl: String?,bio: String?) {
        progressBar.value = true
        db.collection(USER).whereEqualTo("username", username).get()
            .addOnSuccessListener { document ->
                if (document.size() > 0) {
                    viewModelScope.launch {
                       delay(1500)
                        progressBar.value = false
                        ErrorHandleing(customMsg = "username is already taken")
                    }




                } else {

                    if (email.isNotEmpty() || pass.isNotEmpty()) {
                        auth.createUserWithEmailAndPassword(email, pass)
                            .addOnCompleteListener {
                                if (it.isSuccessful) {
                                    isSigned.value = true
                                    ///CREATE PROFILE
                                    createOrUpdateProfile(username,email,fullName,imageUrl,bio)


                                } else {

                                    viewModelScope.launch {
                                        delay(1500)
                                        ErrorHandleing(it.exception, "Sign up failed")
                                        progressBar.value = false
                                    }

                                }

                            }
                    } else {
                        viewModelScope.launch {
                            delay(1000)

                            ErrorHandleing(customMsg = "Please enter all field ")
                            progressBar.value = false
                        }
                    }


                }

            }
            .addOnFailureListener {

            }

    }

    fun createOrUpdateProfile(
        username: String,
        email: String? = null, name: String? = null,
        imageUrl: String?,
        bio: String? = null,
    ) {
        val uid = auth.currentUser?.uid
        bio?:"Hi iam using shashank's meta"
        imageUrl?:"https://cdn-icons-png.flaticon.com/512/847/847969.png?w=740&t=st=1668632210~exp=1668632810~hmac=94a6dc121dc2ced555ce9bf51913d4030ff2ef4a45356b773864527d3f22a80a"
        val userData = UserModel(
            userId = uid,
            username = username,
            imageUri = imageUrl,
            name = name ?: userData.value?.name,
            email = email ?: userData.value?.email,
            bio = bio ?: userData.value?.bio,
            following = userData.value?.following
        )

        uid?.let {
            progressBar.value = true;
            db.collection(USER).document(uid).get().addOnSuccessListener { mydata ->
                if (mydata.exists()) {
                    mydata.reference.update(userData.toMap()).addOnSuccessListener {
                        this.userData.value = userData
                        viewModelScope.launch {
                            delay(1500)
                            progressBar.value = false;
                        }

                    }.addOnFailureListener {
                        viewModelScope.launch {
                        delay(1500)
                        progressBar.value = false
                        ErrorHandleing(it, "Cannot update account")
                    }


                    }
                } else {

                    db.collection(USER).document(uid).set(userData).addOnSuccessListener {
                        getUserData(uid)
                        viewModelScope.launch {
                            delay(1500)
                            progressBar.value = false;
                        }



                    }


                }.addOnFailureListener {
                    viewModelScope.launch {
                        delay(1500)
                        progressBar.value = false;
                        ErrorHandleing(it, "Cannot create your account")
                    }
                }


            }


        }


    }

    private fun getUserData(uid: String) {
        progressBar.value = true
        db.collection(USER).document(uid).get().addOnSuccessListener {

            val user = it.toObject<UserModel>()
            userData.value = user
            popNotification.value = Event("User data retrieved ${userData.value?.username} ")
            progressBar.value = false



        }.addOnFailureListener {
            ErrorHandleing(it, "Cannot retrieve user data")
            progressBar.value = false
        }


    }






    fun  onLogin(email:String ,pass: String){
        if (email.isEmpty() || pass.isEmpty()){
            ErrorHandleing(customMsg = "Enter all field")
        }else{

            progressBar.value=true
            auth.signInWithEmailAndPassword(email,pass).addOnCompleteListener {
                if (it.isSuccessful){
                    isSigned.value=true;
                  auth.currentUser?.uid?.let { uid->
                      getUserData(uid)
                  }
                    progressBar.value=false
                    ErrorHandleing(customMsg = "Login Successfully")
                }else{
                    ErrorHandleing(it.exception,"Login Failed.")
                }

            }.addOnFailureListener {
                progressBar.value=false
                ErrorHandleing(it, it.localizedMessage!!)
            }


        }



    }










    fun ErrorHandleing(e: Exception? = null, customMsg: String = "") {

        e?.printStackTrace()
        val errMsg = e?.localizedMessage ?: ""
        val messageCustom = if (customMsg.isEmpty()) errMsg else "$customMsg : $errMsg"
        popNotification.value = Event(messageCustom)

    }


}