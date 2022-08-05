package com.example.githubrepositories.di

import com.example.githubrepositories.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel{ MainViewModel(get()) }
}