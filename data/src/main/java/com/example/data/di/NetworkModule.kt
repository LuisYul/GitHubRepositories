package com.example.data.di

import com.example.data.di.Constant.BASE_URL
import com.example.data.remote.network.ApiService
import com.example.data.remote.network.SupportInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    factory { SupportInterceptor() }
    single { provideOkHttpClient(get()) }
    single { provideApi(get()) }
    single { provideRetrofit(get()) }
}

fun provideRetrofit(okHttpClient: OkHttpClient) : Retrofit {
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
}

fun provideOkHttpClient(authInterceptor: SupportInterceptor): OkHttpClient {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY
    val builder = OkHttpClient.Builder()
    builder.addInterceptor(interceptor)
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .addInterceptor(authInterceptor)
    return builder.build()
}

fun provideApi(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

object Constant {
    const val BASE_URL = "https://api.github.com/"
}