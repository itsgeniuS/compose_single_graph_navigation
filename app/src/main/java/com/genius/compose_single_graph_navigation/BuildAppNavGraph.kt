package com.genius.compose_single_graph_navigation

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.genius.compose_single_graph_navigation.screens.HomeScreen
import com.genius.compose_single_graph_navigation.screens.HomeToNextScreen
import com.genius.compose_single_graph_navigation.screens.NotificationScreen
import com.genius.compose_single_graph_navigation.screens.OrdersScreen
import com.genius.compose_single_graph_navigation.screens.ProfileScreen
import com.genius.compose_single_graph_navigation.screens.SplashScreen

/**
 * @Author: Thulasi Rajan P
 * @Date: 22-05-2024
 */

@Composable
fun BuildAppNavGraph() {
    val navController = rememberNavController()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val canShowBottomBar = currentRoute in bottomMenuScreens

    Scaffold(
        bottomBar = {
            if (canShowBottomBar) {
                BuildBottomNavigationBar(navController, currentRoute)
            }
        },
        content = { paddingValues ->
            Box(
                modifier = Modifier.padding(
                    bottom = paddingValues.calculateBottomPadding()
                )
            ) {
                NavHost(
                    navController = navController,
                    startDestination = AppScreens.Splash.route
                ) {
                    composable(route = AppScreens.Splash.route) {
                        SplashScreen(navController)
                    }
                    composable(route = AppScreens.Home.route) {
                        HomeScreen(navController)
                    }
                    composable(route = AppScreens.Orders.route) {
                        OrdersScreen(navController)
                    }
                    composable(route = AppScreens.Profile.route) {
                        ProfileScreen(navController)
                    }
                    composable(route = AppScreens.Notifications.route) {
                        NotificationScreen(navController)
                    }
                    composable(route = AppScreens.HomeToNextScreen.route) {
                        HomeToNextScreen(navController)
                    }
                }
            }
        }
    )
}

@Composable
fun BuildBottomNavigationBar(
    navController: NavHostController,
    currentRoute: String?
) {
    val bottomMenus = listOf(
        AppScreens.Home,
        AppScreens.Orders,
        AppScreens.Profile
    )

    BottomAppBar(
        modifier = Modifier.fillMaxWidth(),
        content = {
            bottomMenus.forEach { item ->
                BottomNavigationItem(
                    selected = currentRoute == item.route,
                    onClick = {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }
                    },
                    icon = { Icon(imageVector = item.drawable!!, contentDescription = item.label) },
                    label = { Text(item.label) },
                    selectedContentColor = Color.Black,
                    unselectedContentColor = Color.Gray,
                )
            }
        }
    )
}
