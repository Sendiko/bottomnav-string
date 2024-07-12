package com.sendiko.bottomnavbar.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.sendiko.bottomnavbar.WelcomeScreen

@Composable
fun RootNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = AuthGraph,
    ) {
        navigation<AuthGraph>(
            startDestination = WelcomeScreen,
        ) {
            composable<WelcomeScreen> {
                WelcomeScreen(
                    onNavigate = {
                        navController.navigate(it)
                    }
                )
            }
        }
        composable<MainGraph> {
            MainGraphContainer()
        }
    }
}