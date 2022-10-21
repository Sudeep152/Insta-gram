package com.shashank.instagram.sealed

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(val route :String, val title:String, val icon:ImageVector) {

    object HomeNavItem:BottomNavItem(route = "home_screen","Home",Icons.Default.Home)
    object SearchNavItem:BottomNavItem(route = "search_screen","Search",Icons.Default.Search)
    object NotificationNavItem:BottomNavItem("notification_screen","Notification",Icons.Default.Notifications)
    object ProfileNavItem:BottomNavItem("profile_screen","Profile",Icons.Default.Person)
    object AddPostNavItem:BottomNavItem("add_post_screen","AddPost",Icons.Default.Add)

}