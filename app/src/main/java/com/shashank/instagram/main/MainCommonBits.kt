package com.shashank.instagram.main

import android.app.Notification
import android.widget.Toast

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.shashank.instagram.viewmodel.IgViewModel

@Composable
fun  NotificationMessage(vm :IgViewModel){
    val conte = LocalContext.current
    val notifState = vm.popNotification.value
    val notificationMsg = notifState?.getContentOrNull()
    if (notificationMsg!=null){
      Toast.makeText(conte,notificationMsg,Toast.LENGTH_SHORT).show()
    }


}