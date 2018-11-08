package com.example.stanislavkinzl.tabtestupdateddep.feature.comicslist.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.example.stanislavkinzl.tabtestupdateddep.app.model.Comic

abstract class ComicsViewModel : ViewModel() {

    sealed class State {
        data class FetchMemesSuccess(val comics: List<Comic>) : State()
        object FetchMemesError : State()
    }

    abstract fun state(): LiveData<State>

    abstract fun getComicsApiList()
}