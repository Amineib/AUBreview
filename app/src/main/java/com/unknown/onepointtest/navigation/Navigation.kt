package com.unknown.onepointtest.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.unknown.onepointtest.ui.screens.detail.DetailScreen
import com.unknown.onepointtest.ui.screens.home.HomeScreen


@Composable
fun Navigation(
    
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route){
        composable(
            route = Screen.HomeScreen.route
        ){
            HomeScreen(
                onDetailClicked = {
                    navController.navigate(Screen.DetailScreen.route+"/$it")
                }
            )
        }

        composable(
            route = Screen.DetailScreen.route+"/{id}",
            arguments = listOf(
                navArgument("id"){
                    type = NavType.StringType
                }
            )
        ){
            DetailScreen(
                id = it.arguments!!.getString("id")
            )
        }
    }
}