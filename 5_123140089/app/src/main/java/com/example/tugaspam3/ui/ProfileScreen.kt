package com.example.tugaspam3.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tugaspam3.viewmodel.ProfileViewModel
import androidx.compose.runtime.Composable
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState


@Composable
fun ProfileScreen(viewModel: ProfileViewModel = viewModel()) {

    val state by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Dark Mode")

            Switch(
                checked = state.isDarkMode,
                onCheckedChange = {
                    viewModel.toggleDarkMode()
                }
            )
        }

        ProfileHeader(state)

        Spacer(modifier = Modifier.height(20.dp))

        ProfileCard(state)

        Spacer(modifier = Modifier.height(20.dp))

        EditProfileForm(
            state = state,
            onSave = { name, bio ->
                viewModel.updateProfile(name, bio)
            }
        )
    }
}