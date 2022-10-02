package com.shashank.instagram.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.auth.User
import com.google.firebase.storage.FirebaseStorage
import com.shashank.instagram.data.Event
import com.shashank.instagram.data.UserModel
import dagger.hilt.android.lifecycle.HiltViewModel
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


    fun onSignUp(username: String, email: String, pass: String, fullName: String) {
        progressBar.value = true
        db.collection(USER).whereEqualTo("username", username).get()
            .addOnSuccessListener { document ->
                if (document.size() > 0) {
                    ErrorHandleing(customMsg = "username is already taken")
                    progressBar.value = true
                } else {

                    if (email.isNotEmpty() || pass.isNotEmpty()) {
                        auth.createUserWithEmailAndPassword(email, pass)
                            .addOnCompleteListener {
                                if (it.isSuccessful) {
                                    isSigned.value = true
                                    ///CREATE PROFILE

                                    createOrUpdateProfile(username)

                                } else {
                                    ErrorHandleing(it.exception, "Sign up failed")
                                }

                            }
                        progressBar.value = true
                    } else {
                        ErrorHandleing(customMsg = "Please enter all field ")
                    }


                }

            }
            .addOnFailureListener {

            }

    }

    fun createOrUpdateProfile(
        username: String,
        email: String? = null, name: String? = null,
        imageUrl: String? = null,
        bio: String? = null
    ) {
        val uid = auth.currentUser?.uid
        val userData = UserModel(
            userId = uid,
            username= username,
            name= name ?:userData.value?.name,
            email = email ?:userData.value?.email,
            bio = bio ?:userData.value?.bio,
            following = userData.value?.following
        )

        uid?.let {
            progressBar.value=true;
            db.collection(USER).document(uid).get().addOnSuccessListener { mydata->
                if (mydata.exists()){
                    mydata.reference.update(userData.toMap()).addOnSuccessListener {
                        this.userData.value= userData
                       progressBar.value=false;
                    }.addOnFailureListener {
                        ErrorHandleing(it,"Cannot update account")
                    }
                }else{

                    db.collection(USER).document(uid).set(userData).addOnSuccessListener {
                        getUserData(uid)
                        progressBar.value=false;
                    }


                }.addOnFailureListener {
                    ErrorHandleing(it,"Cannot create your account")
                    progressBar.value=false;
                }


            }


        }


    }

    private fun getUserData(uid: String) {

    }


    fun ErrorHandleing(e: Exception? = null, customMsg: String = "") {

        e?.printStackTrace()
        val errMsg = e?.localizedMessage ?: ""
        val messageCustom = if (customMsg.isEmpty()) errMsg else "$customMsg : $errMsg"
        popNotification.value = Event(messageCustom)

    }


}