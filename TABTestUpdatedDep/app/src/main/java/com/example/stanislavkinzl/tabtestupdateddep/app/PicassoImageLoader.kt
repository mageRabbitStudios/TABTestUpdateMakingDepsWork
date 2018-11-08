package com.example.stanislavkinzl.tabtestupdateddep.app

import android.net.Uri
import android.widget.ImageView
import com.squareup.picasso.Picasso
import java.io.File

class PicassoImageLoader : ImageLoader {

    private val picasso = Picasso.get()

    override fun load(uri: Uri, target: ImageView) = picasso.load(uri).into(target)

    override fun load(path: String, target: ImageView) = picasso.load(path).into(target)

    override fun load(resourceId: Int, target: ImageView) = picasso.load(resourceId).into(target)

    override fun load(file: File, target: ImageView) = picasso.load(file).into(target)

}