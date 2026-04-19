package com.example.tugaspam3.ui.navigation

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.example.tugaspam3.ui.ProfileScreen
import com.example.tugaspam3.viewmodel.ProfileViewModel
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.padding
import com.example.tugaspam3.ui.NotesScreen
import com.example.tugaspam3.ui.screens.AddNoteScreen
import com.example.tugaspam3.ui.screens.DetailScreen
import com.example.tugaspam3.ui.screens.FavoritesScreen
import com.example.tugaspam3.ui.screens.EditNoteScreen

@Composable
fun AppNavigation(viewModel: ProfileViewModel) {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavBar(navController)
        }
    ) { padding ->

        NavHost(
            navController = navController,
            startDestination = "notes",
            modifier = Modifier.padding(padding)
        ) {
            composable("notes") {
                NotesScreen(navController, viewModel)
            }

            composable("favorites") {
                FavoritesScreen(navController, viewModel)
            }

            composable("profile") {
                ProfileScreen(viewModel)
            }

            composable("add_note") {
                AddNoteScreen(navController, viewModel)
            }

            composable("edit_note/{noteId}") { backStackEntry ->
                val id = backStackEntry.arguments?.getString("noteId")?.toIntOrNull() ?: 0
                EditNoteScreen(navController, id, viewModel)
            }

            composable("detail/{noteId}") { backStackEntry ->
                val id = backStackEntry.arguments?.getString("noteId")?.toIntOrNull() ?: 0
                DetailScreen(navController, id, viewModel)
            }
        }
    }
}
