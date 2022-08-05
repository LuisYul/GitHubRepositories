package com.example.domain.model

import java.io.Serializable

data class RepositoryModel(
    val id: Int,
    val name: String,
    val author: String,
    val url: String,
) : Serializable