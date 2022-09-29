package com.shashank.instagram.data

data class UserModel(
    var userId:String?=null,
    var name:String?=null,
    var username:String?=null,
    var imageUri :String?=null,
    var email:String?=null,
    var bio:String?=null,
    var following:List<String>?=null
){

    fun toMap()= mapOf(
        "userId" to userId,
        "name" to  name,
        "username" to username,
        "imageUri" to imageUri,
        "email" to email,
        "bio" to  bio,
        "following" to following

    )

}
