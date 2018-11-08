package com.example.stanislavkinzl.tabtestupdateddep.app.base

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.extensions.LayoutContainer

open class BaseViewHolder(
    override val containerView: View
) : RecyclerView.ViewHolder(containerView),
    LayoutContainer