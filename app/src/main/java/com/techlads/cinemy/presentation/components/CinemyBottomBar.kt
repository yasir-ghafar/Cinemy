package com.techlads.cinemy.presentation.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.techlads.cinemy.navigation.BottomBarNavItem

@Composable
fun CinemyBottomBar(
    screens: List<BottomBarNavItem>,
    navController: NavHostController) {


    val navBackStackEntry by navController.currentBackStackEntryAsState()
    var currentDestination = navBackStackEntry?.destination

    NavigationBar {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                navDestination = currentDestination,
                navController = navController)
        }
    }
}


@Composable
fun RowScope.AddItem(
    screen: BottomBarNavItem,
    navDestination: NavDestination?,
    navController: NavHostController
) {
    NavigationBarItem(

        selected = navDestination?.hierarchy?.any { it.route == screen.route} == true,
        onClick = { navController.navigate(screen.route){
            popUpTo(navController.graph.startDestinationId)
            launchSingleTop = true
        } },
        icon = {
            Icon(
                painter = painterResource(id = screen.icon), contentDescription = screen.title)
        }
    )
}