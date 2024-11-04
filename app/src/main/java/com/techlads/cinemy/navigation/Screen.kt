package com.techlads.cinemy.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val label: String, val icon: ImageVector) {

    object SplashScreen: Screen("splash_screen", "",Icons.Default.Home)
    object HomeScreen: Screen("home_screen", "Home",Icons.Default.ExitToApp)
    object DetailsScreen: Screen("details_screen", "Details",Icons.Default.ExitToApp)
    object ProfileScreen: Screen("profile_screen", "Profile",Icons.Default.Person)
}
