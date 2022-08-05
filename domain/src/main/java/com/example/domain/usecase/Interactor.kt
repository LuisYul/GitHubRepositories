package com.example.domain.usecase

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.example.domain.model.RepositoryModel
import com.example.domain.repository.IRepository

class Interactor constructor(private val repository: IRepository) : UseCase {
    override fun getRepositories(): LiveData<PagingData<RepositoryModel>> {
        return repository.getRepositoriesResults()
    }

}