package com.example.tugaspam3.viewmodel

import app.cash.turbine.test
import com.example.tugaspam3.data.NoteRepository
import com.example.tugaspam3.data.SettingsManager
import com.example.tugaspam3.database.NoteEntity
import com.example.tugaspam3.platform.BatteryInfo
import com.example.tugaspam3.platform.DeviceInfo
import com.example.tugaspam3.platform.NetworkMonitor
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class ProfileViewModelTest {
    private val repository = mockk<NoteRepository>(relaxed = true)
    private val settingsManager = mockk<SettingsManager>(relaxed = true)
    private val networkMonitor = mockk<NetworkMonitor>(relaxed = true)
    private val deviceInfo = mockk<DeviceInfo>(relaxed = true)
    private val batteryInfo = mockk<BatteryInfo>(relaxed = true)
    
    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        
        every { deviceInfo.brand } returns "Google"
        every { deviceInfo.model } returns "Pixel"
        every { deviceInfo.osVersion } returns "14"
        every { batteryInfo.level } returns 80
        every { batteryInfo.isCharging } returns false
        
        every { repository.getAllNotes() } returns flowOf(emptyList())
        every { settingsManager.isDarkMode } returns flowOf(false)
        every { settingsManager.sortOrder } returns flowOf("newest")
        every { networkMonitor.isOnline } returns flowOf(true)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `initial state displays device and battery info`() = runTest {
        val viewModel = ProfileViewModel(repository, settingsManager, networkMonitor, deviceInfo, batteryInfo)
        advanceUntilIdle()

        val state = viewModel.uiState.value
        assertEquals("Google", state.deviceBrand)
        assertEquals(80, state.batteryLevel)
    }

    @Test
    fun `onSearchQueryChange updates state`() = runTest {
        val viewModel = ProfileViewModel(repository, settingsManager, networkMonitor, deviceInfo, batteryInfo)
        advanceUntilIdle()

        viewModel.onSearchQueryChange("test")
        assertEquals("test", viewModel.uiState.value.searchQuery)
    }

    @Test
    fun `deleteNote calls repository`() = runTest {
        val viewModel = ProfileViewModel(repository, settingsManager, networkMonitor, deviceInfo, batteryInfo)
        
        viewModel.deleteNote(1)
        advanceUntilIdle()
        
        coVerify { repository.deleteNote(1L) }
    }

    @Test
    fun `uiState emits updated notes when repository changes`() = runTest {
        val notes = listOf(
            NoteEntity(1L, "T1", "C1", false, 1000L)
        )
        every { repository.getAllNotes() } returns flowOf(notes)
        
        val viewModel = ProfileViewModel(repository, settingsManager, networkMonitor, deviceInfo, batteryInfo)
        advanceUntilIdle()

        viewModel.uiState.test {
            val item = awaitItem()
            assertEquals(1, item.notes.size)
            assertEquals("T1", item.notes[0].title)
        }
    }

    @Test
    fun `toggleDarkMode calls settingsManager`() = runTest {
        val viewModel = ProfileViewModel(repository, settingsManager, networkMonitor, deviceInfo, batteryInfo)
        advanceUntilIdle()

        viewModel.toggleDarkMode()
        advanceUntilIdle()
        
        coVerify { settingsManager.setDarkMode(true) }
    }
}
