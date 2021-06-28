package com.android.appvideo.ui.main

import android.util.Log
import androidx.lifecycle.*
import com.android.appvideo.data.Repository

class MainViewModel(private val repository: Repository) : ViewModel(), LifecycleObserver {
    private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData()

    fun getLiveData() = liveDataToObserve

    fun getFilmRepositoryFromLocalSourceRus() = getDataFromLocalSource(isRussian = true)

    fun getFilmRepositoryFromLocalSourceWorld() = getDataFromLocalSource(isRussian = false)

    fun getWeatherFromRemoteSource() = getDataFromLocalSource(isRussian = true)

    private fun getDataFromLocalSource(isRussian: Boolean) {
        liveDataToObserve.value = AppState.Loading
        Thread {
            Thread.sleep(1000)
            liveDataToObserve.postValue(
                AppState.Success(
                    if (isRussian) repository.getFilmRepositoryFromLocalStorageRus()
                    else repository.getFilmRepositoryFromLocalStorageWorld())
            )
        }.start()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private fun onViewStart() {
        Log.i("LifecycleEvent", "onStart")
    }
}