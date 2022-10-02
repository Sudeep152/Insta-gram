package com.shashank.instagram.data

open class Event<out T>(private val content:T) {

    var hasbeenHandled =false
    private set


    fun getContentOrNull():T?{
        return if(hasbeenHandled){
            null
        }else{
            hasbeenHandled =true
            return content
        }
    }


}