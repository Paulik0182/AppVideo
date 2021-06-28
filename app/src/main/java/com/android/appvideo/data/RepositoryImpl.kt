package com.android.appvideo.data

class RepositoryImpl : Repository {
    override fun getFilmRepositoryFromServer(): FilmRepository {
        return FilmRepository.createFromParcel()
    }
    override fun getFilmRepositoryFromLocalStorageRus() = getRussianCities()
    override fun getFilmRepositoryFromLocalStorageWorld() = getWorldCities()
}