package com.example.stanislavkinzl.tabtestupdateddep.feature.comicslist.domain

import com.example.stanislavkinzl.tabtestupdateddep.app.SchedulerProvider
import com.example.stanislavkinzl.tabtestupdateddep.app.model.Comic
import com.example.stanislavkinzl.tabtestupdateddep.feature.comicslist.repository.ComicRepository
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class FetchComicsUseCaseImpl @Inject constructor(
    private val comicsRepository: ComicRepository,
    private val scheduleProvider: SchedulerProvider
) : FetchComicsUseCase {

    //the disposable which is model used to store given List/data between repository and viewModel
    private var disposable: Disposable? = null

    //callback is callback, there is only one callback for this given use case onFetchComicsResult()
    private var callback: FetchComicsUseCase.Callback? = null

    override fun execute() {
        disposable = comicsRepository.fetchComics()
            .subscribeOn(scheduleProvider.io())
            .observeOn(scheduleProvider.mainThread())
            .subscribe(this::onSuccess, this::onError)
    }

    override fun setCallback(callback: FetchComicsUseCase.Callback) {
        this.callback = callback
    }

    override fun clean() {
        disposable?.dispose()
    }

    private fun onSuccess(comics: List<Comic>) {
        callback?.onFetchComicsResult(FetchComicsUseCase.Result.Success(comics))
    }

    private fun onError(throwable: Throwable) {
        callback?.onFetchComicsResult((FetchComicsUseCase.Result.Error))
    }

}
