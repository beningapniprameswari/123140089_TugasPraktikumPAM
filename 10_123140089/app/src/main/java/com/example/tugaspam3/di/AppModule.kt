package com.example.tugaspam3.di

import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.example.tugaspam3.data.NoteRepository
import com.example.tugaspam3.data.SettingsManager
import com.example.tugaspam3.database.NoteDatabase
import com.example.tugaspam3.platform.*
import com.example.tugaspam3.viewmodel.ProfileViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    // Platform Features
    single<DeviceInfo> { AndroidDeviceInfo() }
    single<NetworkMonitor> { AndroidNetworkMonitor(androidContext()) }
    single<BatteryInfo> { AndroidBatteryInfo(androidContext()) }

    // Database
    single {
        val driver = AndroidSqliteDriver(NoteDatabase.Schema, androidContext(), "notes.db")
        NoteDatabase(driver)
    }

    // Repository & Data Store
    single { NoteRepository(get()) }
    single { SettingsManager(androidContext()) }

    // ViewModel
    viewModel { ProfileViewModel(get(), get(), get(), get(), get()) }
}
