package com.example.tugaspam3.model

data class ProfileUiState(
    val name: String = "Bening Apni Prameswari",
    val nim: String = "123140089",
    val bio: String = "Mahasiswa Teknik Informatika ITERA Angkatan 2023",
    val email: String = "bening.123140089@student.itera.ac.id",
    val phone: String = "+6281366031307",
    val location: String = "Bandar Lampung",
    val isDarkMode: Boolean = false,
    val notes: List<Note> = emptyList(),
    val isLoading: Boolean = false,
    val searchQuery: String = "",
    val sortOrder: String = "newest",
    
    // Platform Info
    val isOnline: Boolean = true,
    val deviceBrand: String = "",
    val deviceModel: String = "",
    val deviceOs: String = "",
    val batteryLevel: Int = 0,
    val isCharging: Boolean = false
)
