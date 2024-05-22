package com.genius.compose_single_graph_navigation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.genius.compose_single_graph_navigation.AppScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController
) {
    Column {
        TopAppBar(
            title = {
                Text(text = AppScreens.Home.label)
            },
            actions = {
                Spacer(modifier = Modifier.width(16.dp))
                Icon(
                    imageVector = Icons.Default.Phone,
                    contentDescription = "Notifications",
                    modifier = Modifier.clickable {
                        navController.navigate(AppScreens.HomeToNextScreen.route)
                    }
                )
                Spacer(modifier = Modifier.width(16.dp))
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "Notifications",
                    modifier = Modifier.clickable {
                        navController.navigate(AppScreens.Notifications.route)
                    }
                )
                Spacer(modifier = Modifier.width(16.dp))
            }
        )



        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
            content = {

                Text(
                    modifier = Modifier.wrapContentWidth(),
                    text = "Home screen",
                    style = TextStyle(fontSize = 18.sp),
                    textAlign = TextAlign.Center
                )
            }
        )
    }
}
