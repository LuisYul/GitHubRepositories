package com.example.data.remote.response

import com.google.gson.annotations.SerializedName

data class RepositoryResponse(
    @field:SerializedName("total_count")
    val totalCount: Int,

    @field:SerializedName("incomplete_results")
    val incompleteResults: Boolean,

    @field:SerializedName("items")
    val items: List<RepositoryResult>
)

data class RepositoryResult(
    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("full_name")
    val name: String ,

    @field:SerializedName("html_url")
    val url: String,

    @field:SerializedName("owner")
    val author: AuthorResponse,
)

data class AuthorResponse(
    @field:SerializedName("login")
    val login: String,
)
