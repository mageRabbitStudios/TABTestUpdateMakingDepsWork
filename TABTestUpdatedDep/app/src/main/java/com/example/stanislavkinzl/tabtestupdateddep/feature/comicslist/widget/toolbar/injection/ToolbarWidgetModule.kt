package com.example.stanislavkinzl.tabtestupdateddep.feature.comicslist.widget.toolbar.injection

import com.example.stanislavkinzl.tabtestupdateddep.feature.comicslist.widget.toolbar.ToolbarWidget
import com.example.stanislavkinzl.tabtestupdateddep.feature.comicslist.widget.toolbar.ToolbarWidgetImpl
import dagger.Module
import dagger.Provides

@Module
class ToolbarWidgetModule {

    @Provides
    fun provideToolbarWidget(toolbarWidgetImpl: ToolbarWidgetImpl): ToolbarWidget =
        toolbarWidgetImpl

}