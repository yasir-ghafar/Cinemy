package com.techlads.cinemy.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.techlads.cinemy.presentation.screens.home.HomeScreen
import com.techlads.cinemy.presentation.screens.movie_details.MovieDetailsScreen
import com.techlads.cinemy.presentation.screens.profile.ProfileScreen
import com.techlads.cinemy.presentation.screens.splash.SplashScreen

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppNavigation(navController: NavHostController) {
    AnimatedNavHost(navController = navController,
        startDestination = Screen.SplashScreen.route) {

        composable(route = Screen.SplashScreen.route) {
            SplashScreen {
                navController.navigate(Screen.HomeScreen.route)
            }
        }

        composable(route = Screen.HomeScreen.route) {
          HomeScreen(
              navigateToDetails = { navController.navigate(Screen.ProfileScreen.route) }
          )
        }

        composable(route = Screen.ProfileScreen.route) {
            ProfileScreen()
        }

        composable(route = Screen.DetailsScreen.route) {
            MovieDetailsScreen()
        }
    }
}