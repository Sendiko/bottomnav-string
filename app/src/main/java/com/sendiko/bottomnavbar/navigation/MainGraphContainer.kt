package com.sendiko.bottomnavbar.navigation

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
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
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val isVisible = navBackStackEntry?.destination?.route?.contains(HomeScreen.toString()) ?: false || navBackStackEntry?.destination?.route?.contains(SettingsScreen.toString()) ?: false
    var currentRoute by remember {
        mutableStateOf(HomeScreen.toString())
    }

    val bottomNavItems = listOf(
        BottomNavItem(
            name = "Home",
            route = HomeScreen,
            icon = Icons.Default.Home
        ),
        BottomNavItem(
            name = "Settings",
            route = SettingsScreen,
            icon = Icons.Default.Settings
        )
    )
    Log.i("DESTINATION", "currentRouteState: ${navBackStackEntry?.destination?.route}")
    Log.i("DESTINATION", "currentRoute: $currentRoute")
    Scaffold(
        bottomBar = {
            AnimatedVisibility(
                visible = isVisible,
                enter = expandVertically(),
                exit = shrinkVertically()
            ) {
                NavigationBar {
                    bottomNavItems.forEach { item ->
                        NavigationBarItem(
                            selected = currentRoute.contains(item.route.toString()),
                            onClick = {
                                currentRoute = item.route.toString()
                                navHostController.navigate(item.route)
                            },
                            icon = {
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = item.name
                                )
                            },
                            label = { Text(item.name) },
                            alwaysShowLabel = currentRoute.contains(item.route.toString())
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