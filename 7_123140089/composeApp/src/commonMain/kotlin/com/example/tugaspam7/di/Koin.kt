package com.example.tugaspam7.di

import com.example.tugaspam7.data.NoteApiService
import com.example.tugaspam7.data.NoteRepository
import com.example.tugaspam7.database.AppDatabase
import com.example.tugaspam7.database.DatabaseDriverFactory
import com.example.tugaspam7.ui.NoteViewModel
import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.koin.core.module.Module
import org.koin.dsl.module
import org.koin.core.module.dsl.viewModel

fun commonModule() = module {
    single { 
        val driver = get<DatabaseDriverFactory>().createDriver()
        AppDatabase(driver)
    }
    single { NoteRepository(get()) }
    single {
        HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    coerceInputValues = true
                })
            }
        }
    }
    single { NoteApiService(get()) }
    viewModel { NoteViewModel(get(), get(), get()) }
}

expect fun platformModule(): Module
