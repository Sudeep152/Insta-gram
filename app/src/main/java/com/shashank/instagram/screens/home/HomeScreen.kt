package com.shashank.instagram.screens.home

import android.annotation.SuppressLint
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.shashank.instagram.R
import com.shashank.instagram.navigation.BottomNavGraph
import com.shashank.instagram.sealed.BottomNavItem
import com.shashank.instagram.viewmodel.IgViewModel

@Composable
fun HomeScreen(navController: NavHostController, igViewModel: IgViewModel) {

    MainScreen()

}

@OptIn(ExperimentalAnimationApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navController = rememberAnimatedNavController()

    Scaffold(
        bottomBar = {
   BottomBar(navController = navController)
        }
    ) {
        BottomNavGraph(navController = navController)

    }

}


@Composable
fun BottomBar(navController: NavHostController) {
    val screen = listOf(
        BottomNavItem.HomeNavItem,
        BottomNavItem.SearchNavItem,
        BottomNavItem.AddPostNavItem,
        BottomNavItem.NotificationNavItem,
        BottomNavItem.ProfileNavItem
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()

    val currentDestination = navBackStackEntry?.destination

    BottomNavigation(

        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(25.dp, 25.dp, 0.dp, 0.dp)),
   backgroundColor = Color(49,50,59), elevation = 30.dp
    ) {
        screen.forEach { screen ->

            if (currentDestination != null) {
                AddItem(screen = screen, currentDestination = currentDestination, navController =navController )
            }
        }
    }


}

@Composable
fun RowScope.AddItem(
    screen: BottomNavItem,
    currentDestination: NavDestination,
    navController: NavHostController,
) {
    BottomNavigationItem(
        icon = {
            Icon(imageVector = screen.icon, contentDescription = "Nav", tint =
                if(screen.title =="AddPost") Color(215,11,123)
                else Color.White
                , modifier = if (screen.title=="AddPost"){

                    Modifier.size(50.dp).clip(RoundedCornerShape(50.dp)).background(Color.White)

                }else{
                    Modifier.size(25.dp)
                }

            )
        },




        selected = currentDestination.hierarchy.any{
            it.route==screen.route
        }
    ,   onClick = {
            navController.navigate(screen.route) {
                // Pop up to the start destination of the graph to
                // avoid building up a large stack of destinations
                // on the back stack as users select items
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                // Avoid multiple copies of the same destination when
                // reselecting the same item
                launchSingleTop = true
                // Restore state when reselecting a previously selected item
                restoreState = true
            }
        }
        )

}