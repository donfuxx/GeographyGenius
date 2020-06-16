package com.appham.geographygenius.features.home.nav

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.appham.geographygenius.common.utils.LiveDataObserver
import com.appham.geographygenius.features.home.HomeViewModel
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module

val homeNavigatorModule = module {
    single<HomeNavigation> { (activity: AppCompatActivity, homeViewModel: HomeViewModel) ->
        HomeNavigator(get {
            parametersOf(
                activity
            )
        }, homeViewModel)
    }
}

class HomeNavigator(
    private val router: HomeNavigation.HomeRouting,
    private val homeViewModel: HomeViewModel
) : HomeNavigation, HomeNavigation.HomeRouting by router {

    override fun init() {
        homeViewModel.getNavEvents().observe { event ->
            when (event) {
                is HomeNavigationEvent.GoToGame -> goToGame()
            }
        }
    }
}

val homeNavigationControllerModule = module {
    single { HomeNavigationController() }
}

class HomeNavigationController : HomeNavigation.HomeNavigationControl {
    private val navEvents: MutableLiveData<HomeNavigationEvent> = MutableLiveData()

    override fun getNavEvents(): LiveData<HomeNavigationEvent> = navEvents

    override fun onGoToGame() {
        navEvents.value = HomeNavigationEvent.GoToGame
    }
}

sealed class HomeNavigationEvent {
    object GoToGame : HomeNavigationEvent()
    object None : HomeNavigationEvent()
}

interface HomeNavigation {
    fun init()

    interface HomeNavigationControl {
        fun getNavEvents(): LiveData<HomeNavigationEvent>

        fun onGoToGame()
    }

    interface HomeRouting: LiveDataObserver {
        fun goToGame()
    }
}