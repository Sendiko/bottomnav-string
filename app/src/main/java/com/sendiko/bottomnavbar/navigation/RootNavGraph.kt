package com.sendiko.bottomnavbar.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.sendiko.bottomnavbar.WelcomeScreen
import com.sendiko.bottomnavbar.navigation.Destinations.WelcomeScreen
import com.sendiko.bottomnavbar.navigation.Graph.AuthGraph

@Composable
fun RootNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Graph.AuthGraph.route,
        route = Graph.RootGraph.route
    ) {
        navigation(
            startDestination = WelcomeScreen.route,
            route = AuthGraph.route
        ) {
            composable(
                route = WelcomeScreen.route
            ) {
                WelcomeScreen(
                    onNavigate = {
                        navController.navigate(it)
                    }
                )
            }
        }
        composable(
            route = Graph.MainGraph.route
        ) {
            MainGraphContainer()
        }
    }
}