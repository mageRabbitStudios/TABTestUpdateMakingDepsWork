package com.example.stanislavkinzl.tabtestupdateddep.feature.comicslist.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.example.stanislavkinzl.tabtestupdateddep.feature.comicslist.domain.FetchComicsUseCase

class ComicsViewModelImpl constructor(
    private val fetchComicsUseCase: FetchComicsUseCase
): ComicsViewModel(), FetchComicsUseCase.Callback {

    /**well because it implements one of it's interface's Callback interface, it can
    /afford the luxury of having the callback here. onFetchComicsResults get's called
    every time it's callback is notified - which is in that use case.

    So the variable of the callback, which is in the use case, needs to be set here,
    so the use case later knows which method to call on it's */
    init { fetchComicsUseCase.setCallback(this) }

    //callbacks
    override fun onFetchComicsResult(result: FetchComicsUseCase.Result) {
        when (result) {

            is FetchComicsUseCase.Result.Success -> state.value =
                    ComicsViewModel.State.FetchMemesSuccess(result.comics)

            FetchComicsUseCase.Result.Error   -> state.value =
                    ComicsViewModel.State.FetchMemesError
        }
    }

    //view model
    override fun state(): LiveData<State> = state

    override fun getComicsApiList() {
        fetchComicsUseCase.execute()
    }

    private val state: MutableLiveData<State> = MutableLiveData()

}
