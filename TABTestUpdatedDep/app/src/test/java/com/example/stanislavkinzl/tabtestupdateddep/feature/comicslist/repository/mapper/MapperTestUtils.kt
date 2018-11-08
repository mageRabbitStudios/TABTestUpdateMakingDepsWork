package com.example.stanislavkinzl.tabtestupdateddep.feature.comicslist.repository.mapper

import com.example.stanislavkinzl.tabtestupdateddep.app.model.Comic

/**
 * the file hierarchy for those starts at test/resources.
 * Switch from Android to Project view tree.
 * */
const val allComicsJsonFilePath  = "comics/all_comics_list.json"
const val noNameJsonFilePath     = "comics/all_comics_list_no_name.json"
const val noPathJsonFilePath     = "comics/all_comics_list_no_path.json"
const val noThumbJsonFilePath    = "comics/all_comics_list_no_thumbnail.json"

/**Comics expected for test purposes*/
//first test comics
val spiderman = Comic(
    name = "Spiderman",
    url = "path_spiderman/standard_medium.spiderman.jpg",
    pageCount = 10
)
val batman = Comic(
    name = "Batman",
    url  = "path_batman/standard_medium.batman.jpg",
    pageCount = 20
)

//second test comics
val spiderman_without_name = Comic(
    name = "",
    url = "path_spiderman/standard_medium.spiderman.jpg",
    pageCount = 10
)