package com.genius.compose_single_graph_navigation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun NotificationScreen(
    navController: NavController
) {
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Column {
            Text(text = "Notification screen", style = TextStyle(fontSize = 18.sp))
            Button(
                onClick = {
                    navController.navigateUp()
                },
                modifier = Modifier.padding(top = 10.dp)
            ) {
                Text(text = "Go back")
            }
        }
    }
}
