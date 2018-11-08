package com.example.stanislavkinzl.tabtestupdateddep.app

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


interface SchedulerProvider {

    fun mainThread(): Scheduler

    fun io(): Scheduler

    fun computation(): Scheduler

}

object DefaultSchedulerProvider : SchedulerProvider {

    override fun mainThread() = AndroidSchedulers.mainThread()

    override fun io() = Schedulers.io()

    override fun computation() = Schedulers.computation()
}