package com.example.tugaspam7.di

import com.example.tugaspam7.database.DatabaseDriverFactory
import com.example.tugaspam7.data.DataStoreFactory
import com.example.tugaspam7.data.SettingsRepository
import org.koin.dsl.module

actual fun platformModule() = module {
    single { DatabaseDriverFactory(get()) }
    single { DataStoreFactory(get()).create() }
    single { SettingsRepository(get()) }
}
