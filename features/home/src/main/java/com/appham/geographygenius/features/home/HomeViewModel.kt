package com.appham.geographygenius.features.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeViewModelModule = module {
    viewModel {
        HomeViewModel()
    }
}

class HomeViewModel : ViewModel() {

    private val navEvents: MutableLiveData<HomeNavigationEvent> = MutableLiveData()

    fun getNavEvents(): LiveData<HomeNavigationEvent> = navEvents

    fun onGoToGame() {
        navEvents.value = HomeNavigationEvent.GoToGame
    }
}

sealed class HomeNavigationEvent {
    object GoToGame : HomeNavigationEvent()
    object None : HomeNavigationEvent()
}

interface HomeNavigation {
    fun init()
}
