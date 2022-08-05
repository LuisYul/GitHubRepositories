package com.example.domain.usecase

import androidx.lifecycle.LiveData
import androidx.paging.PagingData

import com.example.domain.model.RepositoryModel

interface UseCase {
    fun getRepositories(): LiveData<PagingData<RepositoryModel>>
}