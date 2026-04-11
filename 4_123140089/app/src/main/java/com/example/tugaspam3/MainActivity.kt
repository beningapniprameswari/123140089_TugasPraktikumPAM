package com.example.tugaspam3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tugaspam3.ui.ProfileScreen
import com.example.tugaspam3.viewmodel.ProfileViewModel
import androidx.compose.ui.graphics.Color
import com.example.tugaspam3.ui.theme.*
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxSize

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val viewModel: ProfileViewModel = viewModel()
            val state by viewModel.uiState.collectAsState()

            val lightColors = lightColorScheme(
                primary = PinkPrimary,
                secondary = PinkSecondary,
                background = PinkBackground,
                surface = PinkCard,
                onPrimary = Color.White,
                onBackground = TextPrimary
            )

            val darkColors = darkColorScheme(
                primary = PinkPrimary,
                secondary = PinkSecondary,
                background = Color(0xFF121212),
                surface = Color(0xFF1E1E1E),
                onPrimary = Color.White,
                onBackground = Color.White
            )

            MaterialTheme(
                colorScheme = if (state.isDarkMode) darkColors else lightColors
            ) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ProfileScreen(viewModel)
                }
            }
        }
    }
}