package com.example.stanislavkinzl.tabtestupdateddep.feature.comicslist.domain

import com.example.stanislavkinzl.tabtestupdateddep.app.model.Comic


interface  FetchComicsUseCase {

    sealed class Result {
        data class Success(val comics: List<Comic>) : Result()
        object Error : Result()
    }

    interface Callback {
        fun onFetchComicsResult(result: Result)
    }

    fun execute()

    fun setCallback(callback: Callback)

    fun clean()

}