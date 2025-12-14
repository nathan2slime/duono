package org.duonapp.duonapp.routes

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.duonapp.duonapp.pages.home.HomeScreen
import org.duonapp.duonapp.pages.login.LoginRoute

@Composable
fun AppRoute() {
    val navController = rememberNavController()

    NavHost(
        navController = navController, startDestination = Routes.Home,
        enterTransition = {
            slideInHorizontally(
                initialOffsetX = { it },
                animationSpec = tween(300)
            )
        },

        exitTransition = {
            slideOutHorizontally(
                targetOffsetX = { -it },
                animationSpec = tween(300)
            )
        },

        popEnterTransition = {
            slideInHorizontally(
                initialOffsetX = { -it },
                animationSpec = tween(300)
            )
        },

        popExitTransition = {
            slideOutHorizontally(
                targetOffsetX = { it },
                animationSpec = tween(300)
            )
        }
    ) {
        composable(Routes.Login) {
            LoginRoute(onNavigateHome = { navController.navigate(Routes.Home) })
        }

        composable(Routes.Home) {
            HomeScreen(onNavigate = { route ->
                navController.navigate(route)
            })
        }
    }
}
