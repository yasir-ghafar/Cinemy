package com.techlads.cinemy.navigation

import com.techlads.cinemy.R

sealed  class BottomBarNavItem(
    val title: String,
    val icon: Int,
    val route: String,
) {

    object Splash: BottomBarNavItem(
        title = "Home",
        icon = R.drawable.ic_movie_reel,
        route = "splash_screen",
    )
    object Home: BottomBarNavItem(
        title = "Home",
        icon = R.drawable.ic_movie_reel,
        route = "home_screen",
    )
    object Tickets: BottomBarNavItem(
        title = "Tickets",
        icon = R.drawable.ic_event_ticket,
        route = "tickets_screen",
    )

    object Notifications: BottomBarNavItem(
        title = "Notifications",
        icon = R.drawable.ic_alarm,
        route = "notification_screen",
    )
    object Profile: BottomBarNavItem(
        title = "Profile",
        icon = R.drawable.ic_person,
        route = "profile_screen",
    )
}