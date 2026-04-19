package com.example.tugaspam3.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tugaspam3.data.NoteRepository
import com.example.tugaspam3.data.SettingsManager
import com.example.tugaspam3.model.Note
import com.example.tugaspam3.model.ProfileUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val repository: NoteRepository,
    private val settingsManager: SettingsManager
) : ViewModel() {

    private val _uiState = MutableStateFlow(ProfileUiState())
    val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()

    init {
        observeData()
    }

    private fun observeData() {
        viewModelScope.launch {
            // Gabungkan aliran notes, darkMode, sortOrder, DAN searchQuery
            // Kita gunakan data utama dari getAllNotes, lalu filter di memori jika ada searchQuery
            combine(
                repository.getAllNotes(),
                settingsManager.isDarkMode,
                settingsManager.sortOrder,
                _uiState
            ) { entities, darkMode, sortOrder, currentState ->
                val allNotes = entities.map {
                    Note(
                        id = it.id.toInt(),
                        title = it.title,
                        content = it.content,
                        isFavorite = it.isFavorite
                    )
                }
                
                // Filter berdasarkan search query jika ada
                val filteredNotes = if (currentState.searchQuery.isEmpty()) {
                    allNotes
                } else {
                    allNotes.filter { 
                        it.title.contains(currentState.searchQuery, ignoreCase = true) || 
                        it.content.contains(currentState.searchQuery, ignoreCase = true)
                    }
                }
                
                Triple(sortNotes(filteredNotes, sortOrder), darkMode, sortOrder)
            }.collectLatest { (sortedNotes, darkMode, sortOrder) ->
                _uiState.update { 
                    it.copy(
                        notes = sortedNotes,
                        isDarkMode = darkMode,
                        sortOrder = sortOrder,
                        isLoading = false
                    ) 
                }
            }
        }
    }

    private fun sortNotes(notes: List<Note>, order: String): List<Note> {
        return when (order) {
            "alphabetical" -> notes.sortedBy { it.title.lowercase() }
            "oldest" -> notes.sortedBy { it.id }
            else -> notes.sortedByDescending { it.id }
        }
    }

    fun onSearchQueryChange(query: String) {
        // Cukup update query, combine di observeData akan otomatis memfilter ulang
        _uiState.update { it.copy(searchQuery = query) }
    }

    fun toggleDarkMode() {
        viewModelScope.launch {
            settingsManager.setDarkMode(!_uiState.value.isDarkMode)
        }
    }

    fun setSortOrder(order: String) {
        viewModelScope.launch {
            settingsManager.setSortOrder(order)
        }
    }

    fun updateProfile(name: String, bio: String) {
        _uiState.update {
            it.copy(name = name, bio = bio)
        }
    }

    fun addNote(title: String, content: String) {
        viewModelScope.launch {
            repository.insertNote(title, content)
        }
    }

    fun updateNote(noteId: Int, title: String, content: String) {
        viewModelScope.launch {
            repository.updateNote(noteId.toLong(), title, content)
        }
    }

    fun deleteNote(noteId: Int) {
        viewModelScope.launch {
            repository.deleteNote(noteId.toLong())
        }
    }

    fun toggleFavorite(noteId: Int) {
        viewModelScope.launch {
            repository.toggleFavorite(noteId.toLong())
        }
    }
}
