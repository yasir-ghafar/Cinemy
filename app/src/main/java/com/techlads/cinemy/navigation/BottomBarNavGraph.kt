package com.techlads.cinemy.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.techlads.cinemy.presentation.screens.home.HomeScreen
import com.techlads.cinemy.presentation.screens.notifications.NotificationsScreen
import com.techlads.cinemy.presentation.screens.profile.ProfileScreen
import com.techlads.cinemy.presentation.screens.ticket.TicketsScreen

@Composable
fun BottomBarNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController ,
        startDestination = BottomBarNavItem.Home.route) {

        /*composable(route = BottomBarNavItem.Splash.route) {
            SplashScreen {
                navController.navigate(Screen.HomeScreen.route)
            }
        }*/
        composable(route = BottomBarNavItem.Home.route) {
            HomeScreen { }
        }

        composable(route = BottomBarNavItem.Profile.route) {
            ProfileScreen()
        }

        composable(route = BottomBarNavItem.Notifications.route) {
            NotificationsScreen()
        }

        composable(route = BottomBarNavItem.Tickets.route) {
            TicketsScreen()
        }

    }
}


