package com.sendiko.bottomnavbar.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.sendiko.bottomnavbar.AboutScreen
import com.sendiko.bottomnavbar.HomeScreen
import com.sendiko.bottomnavbar.SettingsScreen
import com.sendiko.bottomnavbar.navigation.Destinations.HomeScreen
import com.sendiko.bottomnavbar.navigation.Destinations.SettingsScreen

@Composable
fun MainGraph(
    modifier: Modifier = Modifier,
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = HomeScreen.route
    ) {
        composable(
            route = HomeScreen.route
        ) {
            HomeScreen(
                onNavigate = {
                    navHostController.navigate(it)
                }
            )
        }
        composable(SettingsScreen.route) {
            SettingsScreen()
        }
        navigation(
            route = Graph.DetailsGraph.route,
            startDestination = Destinations.AboutScreen.route
        ) {
            composable(
                route = Destinations.AboutScreen.route
            ) {
                AboutScreen(
                    onNavigateBack = {
                        navHostController.navigateUp()
                    }
                )
            }
        }
    }
}