package com.sendiko.bottomnavbar.navigation

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun MainGraphContainer(
    modifier: Modifier = Modifier,
    navHostController: NavHostController = rememberNavController()
) {
    var currentRoute by remember { mutableStateOf(Destinations.HomeScreen.route) }
    val bottomNavItems = listOf(
        BottomNavItem(
            name = "Home",
            route = Destinations.HomeScreen.route,
            icon = Icons.Default.Home
        ),
        BottomNavItem(
            name = "Settings",
            route = Destinations.SettingsScreen.route,
            icon = Icons.Default.Settings
        )
    )
    Scaffold(
        bottomBar = {
            val slideUp = tween<Float>(
                durationMillis = 300, // Adjust duration as needed
                easing = {
                    when {
                        it < 0.5f -> 2 * it
                        else -> 1 - (it - 0.5f) * 2
                    }
                }
            )

            val slideDown = tween<Float>(
                durationMillis = 300, // Adjust duration as needed
                easing = {
                    when {
                        it < 0.5f -> (it - 0.5f) * 2
                        else -> 1.0f
                    }
                }
            )
            val navBackStackEntry by navHostController.currentBackStackEntryAsState()
            val isVisible = navBackStackEntry?.destination?.route == Destinations.HomeScreen.route || navBackStackEntry?.destination?.route == Destinations.SettingsScreen.route
            Log.i("DESTINATION", "MainGraphContainer: $isVisible")
            AnimatedVisibility(
                visible = isVisible,
                enter = expandVertically(),
                exit = shrinkVertically()
            ) {
                NavigationBar {
                    bottomNavItems.forEach { item ->
                        NavigationBarItem(
                            selected = item.route == currentRoute,
                            onClick = {
                                currentRoute = item.route
                                navHostController.navigate(item.route)
                            },
                            icon = {
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = item.name
                                )
                            },
                            label = { Text(item.name) },
                            alwaysShowLabel = item.route == currentRoute
                        )
                    }
                }
            }
        }
    ) {
        MainGraph(
            navHostController = navHostController,
            modifier = Modifier.padding(it)
        )
    }
}