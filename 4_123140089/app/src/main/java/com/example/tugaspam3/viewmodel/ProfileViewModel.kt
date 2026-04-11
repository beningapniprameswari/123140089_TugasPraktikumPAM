package com.example.tugaspam3.viewmodel

import androidx.lifecycle.ViewModel
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
}