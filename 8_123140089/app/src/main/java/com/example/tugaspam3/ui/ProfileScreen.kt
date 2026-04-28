package com.example.tugaspam3.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tugaspam3.viewmodel.ProfileViewModel
import androidx.compose.runtime.Composable
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.graphics.Color


@Composable
fun ProfileScreen(viewModel: ProfileViewModel) {

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

        // Device & Battery Info Card (Platform Features)
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.3f))
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Info, contentDescription = null, modifier = Modifier.size(20.dp))
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Device Information", style = MaterialTheme.typography.titleSmall)
                }
                
                Spacer(modifier = Modifier.height(8.dp))
                
                DetailRow(label = "Brand", value = state.deviceBrand)
                DetailRow(label = "Model", value = state.deviceModel)
                DetailRow(label = "Android Version", value = state.deviceOs)
                
                HorizontalDivider(
                    modifier = Modifier.padding(vertical = 8.dp),
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f)
                )
                
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Battery Level", style = MaterialTheme.typography.bodyMedium)
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            "${state.batteryLevel}%", 
                            style = MaterialTheme.typography.bodyLarge,
                            color = if (state.batteryLevel < 20) Color.Red else MaterialTheme.colorScheme.primary
                        )
                        if (state.isCharging) {
                            Text(" ⚡", style = MaterialTheme.typography.bodyMedium)
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

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

@Composable
fun DetailRow(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 2.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(label, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f))
        Text(value, style = MaterialTheme.typography.bodySmall)
    }
}
