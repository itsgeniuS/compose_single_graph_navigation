package com.genius.compose_single_graph_navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * @Author: Thulasi Rajan P
 * @Date: 22-05-2024
 */
sealed class AppScreens(
    val route: String,
    val label: String,
    val drawable: ImageVector? = null
) {
    //direct screens
    data object Splash : AppScreens(route = "splash", label = "SplashScreen")
    data object Notifications : AppScreens(route = "notifications", label = "Notifications")
    data object HomeToNextScreen : AppScreens(route = "homeToNext", label = "HomeToNextScreen")

    //bottom menu screens
    data object Home : AppScreens(
        route = "home",
        label = "Home",
        drawable = Icons.Default.Home
    )

    data object Orders : AppScreens(
        route = "orders",
        label = "Orders",
        drawable = Icons.Default.List
    )

    data object Profile : AppScreens(
        route = "profile",
        label = "Profile",
        drawable = Icons.Default.AccountCircle
    )
}

val bottomMenuScreens = listOf(
    AppScreens.Home.route,
    AppScreens.Profile.route,
    AppScreens.Orders.route
)