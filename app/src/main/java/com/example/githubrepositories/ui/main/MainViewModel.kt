package com.example.githubrepositories.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.domain.usecase.UseCase

class MainViewModel(useCase: UseCase) : ViewModel() {

    val repositories = useCase.getRepositories().cachedIn(viewModelScope)

}