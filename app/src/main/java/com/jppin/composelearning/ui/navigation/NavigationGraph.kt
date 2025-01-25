package com.jppin.composelearning.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jppin.composelearning.ui.screens.*

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "home_screen"
    ) {
        composable("home_screen") { HomeScreen()  }
        composable("meditate_screen") { MeditateScreen() }
        composable("sleep_screen") { SleepScreen() }
        composable("music_screen") { MusicScreen() }
        composable("profile_screen") { ProfileScreen() }
    }
}

