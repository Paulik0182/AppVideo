package com.android.appvideo.data

interface Repository {
    fun getFilmRepositoryFromServer(): FilmRepository
    fun getFilmRepositoryFromLocalStorageRus(): List<FilmRepository>
    fun getFilmRepositoryFromLocalStorageWorld(): List<FilmRepository>
}