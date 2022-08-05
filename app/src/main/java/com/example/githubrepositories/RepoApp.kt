package com.example.githubrepositories

import android.app.Application
import com.example.data.di.networkModule
import com.example.data.di.repositoryModule
import com.example.domain.di.useCasesModule
import com.example.githubrepositories.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class RepoApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@RepoApp)
            modules(arrayListOf(repositoryModule,
                useCasesModule, viewModelModule, networkModule))
        }
    }
}