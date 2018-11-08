package com.example.stanislavkinzl.tabtestupdateddep.feature.comicslist.widget.toolbar

import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.widget_toolbar.*
import javax.inject.Inject

class ToolbarWidgetImpl @Inject constructor(
) : ToolbarWidget, LayoutContainer {

    override lateinit var containerView: View

    override fun init(view: View) {
        containerView = view
    }

    override fun setToolbar(activity: AppCompatActivity) {
        activity.setSupportActionBar(toolbar)
    }

}