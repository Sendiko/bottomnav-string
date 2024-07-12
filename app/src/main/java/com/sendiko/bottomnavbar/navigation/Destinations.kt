package com.sendiko.bottomnavbar.navigation

sealed class Destinations(val route: String) {
    data object WelcomeScreen: Destinations("welcome")
    data object HomeScreen: Destinations("home")
    data object SettingsScreen: Destinations("settings")
    data object AboutScreen: Destinations("about")
}

sealed class Graph(val route: String) {
    data object RootGraph: Graph("root")
    data object AuthGraph: Graph("auth")
    data object MainGraph: Graph("main")
    data object DetailsGraph: Graph("details")
}