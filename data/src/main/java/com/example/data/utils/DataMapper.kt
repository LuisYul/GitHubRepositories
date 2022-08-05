package com.example.data.utils

import com.example.data.remote.response.RepositoryResult
import com.example.domain.model.RepositoryModel

object DataMapper {
    fun mapRepositoryResponseToModel(data: List<RepositoryResult>): List<RepositoryModel> {
        return data.map {
            with(it) {
                RepositoryModel(
                    id,
                    name,
                    author.login,
                    url,
                )
            }
        }
    }
}