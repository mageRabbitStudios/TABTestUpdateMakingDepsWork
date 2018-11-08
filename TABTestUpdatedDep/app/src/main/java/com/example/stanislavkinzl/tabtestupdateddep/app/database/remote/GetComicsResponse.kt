package com.example.stanislavkinzl.tabtestupdateddep.app.database.remote

import com.google.gson.annotations.SerializedName

/***
 * Model class coming from the network so everything is marked as nullable or has default values.
 * Needs to be sanity checked (any mandatory fields) and mapped to the model we want to use internally.
 *
 */
data class GetComicsResponse(
    @SerializedName("data")         val data: Data?
)

data class Data(
    @SerializedName("results")      val comics: List<ComicItem>?
)

data class ComicItem(
    @SerializedName("id")           val id: Int?,
    @SerializedName("title")        val name: String?,
    @SerializedName("description")  val description: String?,
    @SerializedName("thumbnail")    val thumbnail: Thumbnail?,
    @SerializedName("pageCount")    val pageCount: Int?
)

data class Thumbnail(
    @SerializedName("path")         val path: String?,
    @SerializedName("extension")    val extension: String?
)