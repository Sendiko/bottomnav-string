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

@Composable
fun MainGraph(
    modifier: Modifier = Modifier,
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = HomeScreen
    ) {
        composable<HomeScreen> {
            HomeScreen(
                onNavigate = {
                    navHostController.navigate(it)
                }
            )
        }
        composable<SettingsScreen> {
            SettingsScreen()
        }
        navigation<DetailsGraph>(
            startDestination = AboutScreen
        ) {
            composable<AboutScreen>{
                AboutScreen(
                    onNavigateBack = {
                        navHostController.navigateUp()
                    }
                )
            }
        }
    }
}