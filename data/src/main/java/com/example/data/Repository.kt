package com.example.data

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.data.remote.RemoteDataSource
import com.example.data.remote.network.ApiService
import com.example.domain.model.RepositoryModel
import com.example.domain.repository.IRepository

class Repository constructor(
    private val apiService: ApiService,
) : IRepository {
    override fun getRepositoriesResults(): LiveData<PagingData<RepositoryModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false,
            ), pagingSourceFactory = { RemoteDataSource(apiService) }
        ).liveData
    }
}