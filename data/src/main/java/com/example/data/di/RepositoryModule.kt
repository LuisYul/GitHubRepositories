package com.example.data.di

import com.example.data.Repository
import com.example.data.remote.RemoteDataSource
import com.example.domain.repository.IRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { RemoteDataSource(get()) }
    single<IRepository> {
        Repository(get())
    }
}