package com.example.stanislavkinzl.tabtestupdateddep.feature.comicslist.widget.comicslist.injection

import android.content.Context
import android.content.res.Configuration
import android.support.v7.widget.GridLayoutManager
import com.example.stanislavkinzl.tabtestupdateddep.app.Calculator
import com.example.stanislavkinzl.tabtestupdateddep.app.ImageLoader
import com.example.stanislavkinzl.tabtestupdateddep.app.NUMBER_OF_COMICS_PER_ROW_LANDSCAPE
import com.example.stanislavkinzl.tabtestupdateddep.app.NUMBER_OF_COMICS_PER_ROW_PORTRAIT
import com.example.stanislavkinzl.tabtestupdateddep.feature.comicslist.widget.comicslist.ComicsListWidget
import com.example.stanislavkinzl.tabtestupdateddep.feature.comicslist.widget.comicslist.ComicsListWidgetImpl
import com.example.stanislavkinzl.tabtestupdateddep.feature.comicslist.widget.comicslist.GridSpacingItemDecoration
import com.example.stanislavkinzl.tabtestupdateddep.feature.comicslist.widget.comicslist.adapter.ComicsListAdapter
import dagger.Module
import dagger.Provides

@Module
class ComicsListWidgetModule {

    @Provides
    fun provideComicsListWidget(comicsListWidget: ComicsListWidgetImpl): ComicsListWidget = comicsListWidget

    @Provides
    fun provideComicsListAdapter(context: Context, imageLoader: ImageLoader): ComicsListAdapter =
            ComicsListAdapter(context, imageLoader)


    @Provides
    fun provideGridLayoutManager(context: Context, spanCount: Int): GridLayoutManager =
            GridLayoutManager(context, spanCount)

    @Provides
    fun provideSpanCount(context: Context): Int =
            when(context.resources.configuration.orientation) {

              Configuration.ORIENTATION_PORTRAIT -> NUMBER_OF_COMICS_PER_ROW_PORTRAIT
              else                               -> NUMBER_OF_COMICS_PER_ROW_LANDSCAPE
    }

    @Provides
    fun provideGridSpacingItemDecoration(calculator: Calculator, spanCount: Int): GridSpacingItemDecoration =
            GridSpacingItemDecoration(spanCount, calculator.dpToPx(10), true)
}