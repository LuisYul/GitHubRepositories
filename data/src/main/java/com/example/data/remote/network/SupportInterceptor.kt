package com.example.data.remote.network

import okhttp3.Interceptor
import okhttp3.Response
import java.util.*

class SupportInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request.newBuilder()
            .addHeader("Content-Type", "application/json")
            .addHeader("Accept", "application/json")
            .addHeader("iso-lang", Locale.getDefault().language)
            .build()
        return chain.proceed(request)
    }
}