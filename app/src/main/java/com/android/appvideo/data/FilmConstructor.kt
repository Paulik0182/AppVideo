package com.android.appvideo.data

data class FilmConstructor(
    val id: Int,
    val name: String,
    val description: String,
    val imageID: Int,
    var isFavorite: Boolean = false
)