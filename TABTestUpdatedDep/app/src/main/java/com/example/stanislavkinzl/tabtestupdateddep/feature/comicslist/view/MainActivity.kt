package com.example.stanislavkinzl.tabtestupdateddep.feature.comicslist.view

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.stanislavkinzl.tabtestupdateddep.R
import com.example.stanislavkinzl.tabtestupdateddep.app.base.BaseActivity
import com.example.stanislavkinzl.tabtestupdateddep.feature.comicslist.viewmodel.ComicsViewModel
import com.example.stanislavkinzl.tabtestupdateddep.feature.comicslist.widget.comicslist.ComicsListWidget
import com.example.stanislavkinzl.tabtestupdateddep.feature.comicslist.widget.toolbar.ToolbarWidget
import es.dmoral.toasty.Toasty
import javax.inject.Inject

class MainActivity : BaseActivity() {

    //================= WIDGETS ===================

    @Inject
    lateinit var comicsViewModel: ComicsViewModel

    @Inject
    lateinit var comicsListWidget: ComicsListWidget

    @Inject
    lateinit var toolbarWidget: ToolbarWidget

    //=============================================

    override fun provideLayout(): Int = R.layout.activity_main

    override fun initWidgets(view: View) {
        comicsListWidget.init(view)
        toolbarWidget.init(view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        comicsViewModel.getComicsApiList()
        toolbarWidget.setToolbar(this)
    }

    override fun provideViewModel() {
        comicsViewModel.state().observe(this, Observer {
            it?.let { onComicsViewModelStateChange(it) }
        })
    }

    private fun onComicsViewModelStateChange(state: ComicsViewModel.State) = when (state) {

        is ComicsViewModel.State.FetchMemesSuccess
        ->
            for (comic in state.comics) {
                comicsListWidget.addResults(state.comics)
                Toasty.success(this, "Success loading comics", Toast.LENGTH_LONG).show()
            }

        ComicsViewModel.State.FetchMemesError
        -> Toasty.error(this, "Error loading comics", Toast.LENGTH_SHORT).show()
    }
}
