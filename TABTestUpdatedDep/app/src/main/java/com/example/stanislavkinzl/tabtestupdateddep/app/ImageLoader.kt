package com.example.stanislavkinzl.tabtestupdateddep.app

import android.net.Uri
import android.widget.ImageView
import java.io.File

interface ImageLoader {
    fun load(uri: Uri, target: ImageView)
    fun load(path: String, target: ImageView)
    fun load(resourceId: Int, target: ImageView)
    fun load(file: File, target: ImageView)
}
