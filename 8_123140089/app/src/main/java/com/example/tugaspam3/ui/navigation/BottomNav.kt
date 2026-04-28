package com.example.tugaspam3.ui.navigation

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavBar(navController: NavController) {

    val items = listOf("notes", "favorites", "profile")

    NavigationBar {
        val navBackStackEntry = navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry.value?.destination?.route

        items.forEach { screen ->
            NavigationBarItem(
                selected = currentRoute == screen,
                onClick = {
                    navController.navigate(screen) {
                        popUpTo("notes")
                        launchSingleTop = true
                    }
                },
                label = {
                    Text(screen.replaceFirstChar { it.uppercase() })
                },
                icon = {}
            )
        }
    }
}