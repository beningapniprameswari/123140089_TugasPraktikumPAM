package com.example.tugaspam3.viewmodel

import androidx.lifecycle.ViewModel
import com.example.tugaspam3.model.Note
import com.example.tugaspam3.model.ProfileUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class ProfileViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(ProfileUiState())
    val uiState: StateFlow<ProfileUiState> = _uiState

    fun toggleDarkMode() {
        _uiState.update {
            it.copy(isDarkMode = !it.isDarkMode)
        }
    }

    fun updateProfile(name: String, bio: String) {
        _uiState.update {
            it.copy(
                name = name,
                bio = bio
            )
        }
    }

    fun addNote(title: String, content: String) {
        _uiState.update { state ->
            val newNote = Note(
                id = if (state.notes.isEmpty()) 0 else state.notes.maxOf { it.id } + 1,
                title = title,
                content = content
            )
            state.copy(notes = state.notes + newNote)
        }
    }

    fun updateNote(noteId: Int, title: String, content: String) {
        _uiState.update { state ->
            val updatedNotes = state.notes.map { note ->
                if (note.id == noteId) {
                    note.copy(title = title, content = content)
                } else {
                    note
                }
            }
            state.copy(notes = updatedNotes)
        }
    }

    fun deleteNote(noteId: Int) {
        _uiState.update { state ->
            state.copy(notes = state.notes.filter { it.id != noteId })
        }
    }

    fun toggleFavorite(noteId: Int) {
        _uiState.update { state ->
            val updatedNotes = state.notes.map { note ->
                if (note.id == noteId) {
                    note.copy(isFavorite = !note.isFavorite)
                } else {
                    note
                }
            }
            state.copy(notes = updatedNotes)
        }
    }
}