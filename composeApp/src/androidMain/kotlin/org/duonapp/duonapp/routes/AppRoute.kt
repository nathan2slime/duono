package org.duonapp.duonapp.routes

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.duonapp.duonapp.pages.home.HomeScreen
import org.duonapp.duonapp.pages.login.LoginScreen

@Composable
fun AppRoute() {
    val navController = rememberNavController()

    NavHost(
        navController = navController, startDestination = Routes.Home
    ) {
        composable(Routes.Login) {
            LoginScreen()
        }

        composable(Routes.Home) {
            HomeScreen(onNavigate = { route ->
                navController.navigate(route)
            })
        }
    }
}
