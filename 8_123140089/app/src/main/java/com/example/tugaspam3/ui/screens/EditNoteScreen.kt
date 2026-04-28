package com.example.tugaspam3.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tugaspam3.viewmodel.ProfileViewModel

@Composable
fun EditNoteScreen(navController: NavController, noteId: Int, viewModel: ProfileViewModel) {
    val state by viewModel.uiState.collectAsState()
    val note = state.notes.find { it.id == noteId }

    var title by remember { mutableStateOf(note?.title ?: "") }
    var content by remember { mutableStateOf(note?.content ?: "") }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()
        ) {

            Text(
                "Edit Note", 
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(16.dp))

            if (note != null) {
                OutlinedTextField(
                    value = title,
                    onValueChange = { title = it },
                    label = { Text("Title") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = MaterialTheme.colorScheme.primary,
                        focusedLabelColor = MaterialTheme.colorScheme.primary
                    )
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = content,
                    onValueChange = { content = it },
                    label = { Text("Content") },
                    modifier = Modifier.fillMaxWidth().weight(1f),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = MaterialTheme.colorScheme.primary,
                        focusedLabelColor = MaterialTheme.colorScheme.primary
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        if (title.isNotBlank()) {
                            viewModel.updateNote(noteId, title, content)
                            navController.popBackStack()
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    )
                ) {
                    Text("Update Note")
                }
            } else {
                Text("Note not found", color = MaterialTheme.colorScheme.error)
            }
        }
    }
}
