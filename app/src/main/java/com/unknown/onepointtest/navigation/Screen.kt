package com.unknown.onepointtest.navigation

sealed class Screen (val route: String) {
    object HomeScreen: Screen("home")
    object DetailScreen: Screen("detail")
}
