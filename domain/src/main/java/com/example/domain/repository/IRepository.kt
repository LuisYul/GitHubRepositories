package com.example.domain.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.example.domain.model.RepositoryModel

interface IRepository {
    fun getRepositoriesResults() : LiveData<PagingData<RepositoryModel>>
}