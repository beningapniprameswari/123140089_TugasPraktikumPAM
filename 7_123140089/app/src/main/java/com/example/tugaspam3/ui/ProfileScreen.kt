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
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Dark Mode", style = MaterialTheme.typography.bodyLarge)
            Switch(
                checked = state.isDarkMode,
                onCheckedChange = {
                    viewModel.toggleDarkMode()
                }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Sort Order UI
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Sort Notes By:", style = MaterialTheme.typography.titleSmall)
                
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = state.sortOrder == "newest",
                        onClick = { viewModel.setSortOrder("newest") }
                    )
                    Text("Terbaru")
                    
                    Spacer(modifier = Modifier.width(8.dp))
                    
                    RadioButton(
                        selected = state.sortOrder == "alphabetical",
                        onClick = { viewModel.setSortOrder("alphabetical") }
                    )
                    Text("A-Z")
                    
                    Spacer(modifier = Modifier.width(8.dp))
                    
                    RadioButton(
                        selected = state.sortOrder == "oldest",
                        onClick = { viewModel.setSortOrder("oldest") }
                    )
                    Text("Terlama")
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

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
