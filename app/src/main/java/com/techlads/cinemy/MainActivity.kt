package com.techlads.cinemy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.techlads.cinemy.navigation.AppNavigation
import com.techlads.cinemy.navigation.BottomBarNavGraph
import com.techlads.cinemy.navigation.BottomBarNavItem
import com.techlads.cinemy.presentation.components.CinemyBottomBar
import com.techlads.cinemy.presentation.screens.home.HomeScreen
import com.techlads.cinemy.presentation.screens.splash.SplashScreen
import com.techlads.cinemy.ui.theme.CinemyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            var screens = listOf(
                BottomBarNavItem.Home,
                BottomBarNavItem.Tickets,
                BottomBarNavItem.Notifications,
                BottomBarNavItem.Profile,
            )

            val navController = rememberAnimatedNavController()
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            var currentDestination = navBackStackEntry?.destination

            CinemyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    Scaffold(
                        bottomBar = {
                            CinemyBottomBar(
                                screens = screens,
                                navController = navController)
                        }
                    ) { innerPadding ->
                        Box(modifier = Modifier.padding(innerPadding)) {
                            BottomBarNavGraph(navController = navController)
                        }
                    }
                    /*val navController = rememberAnimatedNavController()
                    CinemyThemeHandler(navController = navController)*/
                }
            }
        }
    }
}

/*@Composable
fun CinemyThemeHandler(navController: NavHostController) {
    CinemyTheme {
        AppNavigation(navController = navController)
    }
}*/
