package com.example.stanislavkinzl.tabtestupdateddep.app.base

import android.os.Bundle
import android.view.View
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(provideLayout())
        initWidgets(findViewById(android.R.id.content))
        provideViewModel()
    }

    abstract fun provideLayout(): Int

    abstract fun provideViewModel()

    abstract fun initWidgets(view : View)
}