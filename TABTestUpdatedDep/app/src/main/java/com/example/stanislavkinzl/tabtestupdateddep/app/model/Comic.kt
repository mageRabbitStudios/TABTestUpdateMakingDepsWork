package com.example.stanislavkinzl.tabtestupdateddep.app.model

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@SuppressLint("ParcelCreator")
@Parcelize
data class Comic(
    var name: String,
    var url: String,
    var pageCount: Int
) : Parcelable