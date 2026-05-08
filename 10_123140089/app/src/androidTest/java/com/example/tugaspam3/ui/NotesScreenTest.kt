package com.example.tugaspam3.ui

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.navigation.NavController
import com.example.tugaspam3.data.NoteRepository
import com.example.tugaspam3.data.SettingsManager
import com.example.tugaspam3.platform.BatteryInfo
import com.example.tugaspam3.platform.DeviceInfo
import com.example.tugaspam3.platform.NetworkMonitor
import com.example.tugaspam3.viewmodel.NotesViewModel
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class NotesScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val repository = mockk<NoteRepository>(relaxed = true)
    private val settingsManager = mockk<SettingsManager>(relaxed = true)
    private val networkMonitor = mockk<NetworkMonitor>(relaxed = true)
    private val deviceInfo = mockk<DeviceInfo>(relaxed = true)
    private val batteryInfo = mockk<BatteryInfo>(relaxed = true)
    private val navController = mockk<NavController>(relaxed = true)

    private lateinit var viewModel: NotesViewModel

    @Before
    fun setup() {
        every { deviceInfo.brand } returns "Samsung"
        every { deviceInfo.model } returns "S24"
        every { deviceInfo.osVersion } returns "14"
        every { batteryInfo.level } returns 100
        every { batteryInfo.isCharging } returns true
        every { networkMonitor.isOnline } returns flowOf(true)
        every { settingsManager.isDarkMode } returns flowOf(false)
        every { settingsManager.sortOrder } returns flowOf("newest")
    }

    @Test
    fun notesScreen_emptyState_showsInfoMessage() {
        every { repository.getAllNotes() } returns flowOf(emptyList())
        viewModel = NotesViewModel(repository, settingsManager, networkMonitor, deviceInfo, batteryInfo)

        composeTestRule.setContent {
            NotesScreen(navController = navController, viewModel = viewModel)
        }

        composeTestRule.onNodeWithTag("empty_state").assertIsDisplayed()
        composeTestRule.onNodeWithText("Belum ada note.", substring = true).assertIsDisplayed()
    }

    @Test
    fun notesScreen_withData_showsNotesList() {
        val notes = listOf(
            com.example.tugaspam3.database.NoteEntity(1L, "Tugas PAM", "Mengerjakan Unit Test", false, 1000L)
        )
        every { repository.getAllNotes() } returns flowOf(notes)
        viewModel = NotesViewModel(repository, settingsManager, networkMonitor, deviceInfo, batteryInfo)

        composeTestRule.setContent {
            NotesScreen(navController = navController, viewModel = viewModel)
        }

        composeTestRule.onNodeWithTag("notes_list").assertIsDisplayed()
        composeTestRule.onNodeWithText("Tugas PAM").assertIsDisplayed()
    }

    @Test
    fun notesScreen_fabClick_isPossible() {
        every { repository.getAllNotes() } returns flowOf(emptyList())
        viewModel = NotesViewModel(repository, settingsManager, networkMonitor, deviceInfo, batteryInfo)

        composeTestRule.setContent {
            NotesScreen(navController = navController, viewModel = viewModel)
        }

        composeTestRule.onNodeWithTag("add_note_fab").assertHasClickAction()
        composeTestRule.onNodeWithTag("add_note_fab").performClick()
    }
}
