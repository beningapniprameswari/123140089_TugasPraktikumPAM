package com.example.tugaspam3.di

import com.example.tugaspam3.viewmodel.NotesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { NotesViewModel(get(), get(), get(), get(), get()) }
}
