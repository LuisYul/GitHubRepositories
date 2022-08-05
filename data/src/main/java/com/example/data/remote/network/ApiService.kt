package com.example.data.remote.network

import com.example.data.remote.response.RepositoryResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/search/repositories")
    suspend fun getRepositoriesPaged(
        @Query("q") query: String,
        @Query("page") page: Int,
        @Query("per_page") limit: Int,
    ): RepositoryResponse

}