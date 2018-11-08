package com.example.stanislavkinzl.tabtestupdateddep.feature.comicslist.widget.comicslist.adapter

import android.view.View
import com.example.stanislavkinzl.tabtestupdateddep.app.ImageLoader
import com.example.stanislavkinzl.tabtestupdateddep.app.base.BaseViewHolder
import com.example.stanislavkinzl.tabtestupdateddep.app.model.Comic
import kotlinx.android.synthetic.main.comic_card.*

class ComicsListAdapterVH(
    override val containerView: View,
    private val imageLoader: ImageLoader
) : BaseViewHolder(containerView) {

    private fun showImage(url: String?) {
        url?.let { imageLoader.load(it, comics_list_item_thumbnail) }
    }

    fun showComic(comic: Comic) {
        showImage(comic.url)
        comics_list_item_title.text = comic.name
        comics_list_item_count.text = when(comic.pageCount) {

            0    -> "Unknown"
            else -> comic.pageCount.toString()
        }
    }
}
