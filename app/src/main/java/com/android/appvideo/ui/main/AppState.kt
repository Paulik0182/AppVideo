package com.android.appvideo.ui.main

import com.android.appvideo.data.FilmRepository

sealed class AppState {
    data class Success(val FilmRepositoryData: List<FilmRepository>) : AppState()
    data class Error(val error: Throwable) : AppState()
    object Loading : AppState()
}