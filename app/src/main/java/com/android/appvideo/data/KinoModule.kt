package com.android.appvideo.data

import com.android.appvideo.data.Repository
import com.android.appvideo.ui.main.MainViewModel
import com.android.appvideo.data.RepositoryImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single<Repository> { RepositoryImpl() }

    //View models
    viewModel { MainViewModel(get()) }
}

fun module(function: () -> Unit): Any {

}
