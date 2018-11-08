package com.example.stanislavkinzl.tabtestupdateddep.feature.comicslist.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.stanislavkinzl.tabtestupdateddep.feature.comicslist.domain.FetchComicsUseCase
import javax.inject.Inject

class ComicsViewModelFactory @Inject constructor(
    private val fetchComicsUseCase: FetchComicsUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ComicsViewModelImpl(fetchComicsUseCase) as T
    }

}