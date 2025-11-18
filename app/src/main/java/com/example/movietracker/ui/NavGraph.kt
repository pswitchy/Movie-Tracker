package com.example.movietracker.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movietracker.ui.home.HomeScreen
import com.example.movietracker.ui.moviedetails.MovieDetailsScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            HomeScreen(onMovieClick = {
                navController.navigate(Screen.MovieDetails.createRoute(it.id))
            })
        }
        composable(
            route = Screen.MovieDetails.route,
            arguments = listOf(navArgument("movieId") { type = NavType.StringType })
        ) {
            MovieDetailsScreen(onNavigateUp = { navController.navigateUp() })
        }
    }
}