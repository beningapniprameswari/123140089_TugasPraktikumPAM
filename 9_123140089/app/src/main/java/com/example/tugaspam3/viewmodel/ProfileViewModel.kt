package com.example.tugaspam3.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tugaspam3.data.NoteRepository
import com.example.tugaspam3.data.SettingsManager
import com.example.tugaspam3.model.Note
import com.example.tugaspam3.model.ProfileUiState
import com.example.tugaspam3.platform.AiService
import com.example.tugaspam3.platform.BatteryInfo
import com.example.tugaspam3.platform.DeviceInfo
import com.example.tugaspam3.platform.NetworkMonitor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val repository: NoteRepository,
    private val settingsManager: SettingsManager,
    private val networkMonitor: NetworkMonitor,
    private val deviceInfo: DeviceInfo,
    private val batteryInfo: BatteryInfo,
    private val aiService: AiService
) : ViewModel() {

    private val _uiState = MutableStateFlow(ProfileUiState())
    val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()

    init {
        // Initialize Device and Battery info
        _uiState.update { 
            it.copy(
                deviceBrand = deviceInfo.brand,
                deviceModel = deviceInfo.model,
                deviceOs = deviceInfo.osVersion,
                batteryLevel = batteryInfo.level,
                isCharging = batteryInfo.isCharging
            )
        }
        observeData()
    }

    private fun observeData() {
        viewModelScope.launch {
            combine(
                repository.getAllNotes(),
                settingsManager.isDarkMode,
                settingsManager.sortOrder,
                networkMonitor.isOnline,
                _uiState
            ) { entities, darkMode, sortOrder, isOnline, currentState ->
                val allNotes = entities.map {
                    Note(
                        id = it.id.toInt(),
                        title = it.title,
                        content = it.content,
                        isFavorite = it.isFavorite
                    )
                }
                
                val filteredNotes = if (currentState.searchQuery.isEmpty()) {
                    allNotes
                } else {
                    allNotes.filter { 
                        it.title.contains(currentState.searchQuery, ignoreCase = true) || 
                        it.content.contains(currentState.searchQuery, ignoreCase = true)
                    }
                }
                
                val sorted = sortNotes(filteredNotes, sortOrder)
                UpdateData(sorted, darkMode, sortOrder, isOnline)
            }.collectLatest { data ->
                _uiState.update { 
                    it.copy(
                        notes = data.notes,
                        isDarkMode = data.darkMode,
                        sortOrder = data.sortOrder,
                        isOnline = data.isOnline,
                        isLoading = false,
                        batteryLevel = batteryInfo.level,
                        isCharging = batteryInfo.isCharging
                    ) 
                }
            }
        }
    }

    private data class UpdateData(
        val notes: List<Note>,
        val darkMode: Boolean,
        val sortOrder: String,
        val isOnline: Boolean
    )

    private fun sortNotes(notes: List<Note>, order: String): List<Note> {
        return when (order) {
            "alphabetical" -> notes.sortedBy { it.title.lowercase() }
            "oldest" -> notes.sortedBy { it.id }
            else -> notes.sortedByDescending { it.id }
        }
    }

    // AI Functions
    fun summarizeNote(content: String) {
        if (content.isBlank()) return
        
        viewModelScope.launch {
            _uiState.update { it.copy(aiIsLoading = true, aiError = null, aiGeneratedContent = null) }
            try {
                val summary = aiService.summarizeNote(content)
                _uiState.update { it.copy(aiIsLoading = false, aiGeneratedContent = summary) }
            } catch (e: Exception) {
                _uiState.update { it.copy(aiIsLoading = false, aiError = e.message) }
            }
        }
    }

    fun fixGrammar(content: String) {
        if (content.isBlank()) return

        viewModelScope.launch {
            _uiState.update { it.copy(aiIsLoading = true, aiError = null, aiGeneratedContent = null) }
            try {
                val fixedText = aiService.fixGrammar(content)
                _uiState.update { it.copy(aiIsLoading = false, aiGeneratedContent = fixedText) }
            } catch (e: Exception) {
                _uiState.update { it.copy(aiIsLoading = false, aiError = e.message) }
            }
        }
    }

    fun clearAiState() {
        _uiState.update { it.copy(aiIsLoading = false, aiError = null, aiGeneratedContent = null) }
    }

    // Other methods
    fun onSearchQueryChange(query: String) {
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
