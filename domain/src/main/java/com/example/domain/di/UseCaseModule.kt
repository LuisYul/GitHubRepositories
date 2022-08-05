package com.example.domain.di
import com.example.domain.usecase.Interactor
import com.example.domain.usecase.UseCase
import org.koin.dsl.module

val useCasesModule = module {
    factory<UseCase> { Interactor(get()) }
}