package com.shashank.instagram.sealed

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter

sealed class BottomScreen(val route :String,val title:String,val icon:ImageVector) {

    object HomeScreen:BottomScreen(route = "home_screen","Home",Icons.Default.Home)
    object SearchScreen:BottomScreen(route = "search_screen","Search",Icons.Default.Search)
    object NotificationScreen:BottomScreen("notification_screen","Notification",Icons.Default.Notifications)
    object ProfileScreen:BottomScreen("profile_screen","Profile",Icons.Default.Person)
    object AddPostScreen:BottomScreen("add_post_screen","AddPost",Icons.Default.Add)

}