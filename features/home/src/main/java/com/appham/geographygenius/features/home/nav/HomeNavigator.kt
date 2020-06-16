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
    single { HomeNavigationController() }
}

class HomeNavigator(
    private val router: HomeNavigation.Routing,
    private val homeViewModel: HomeViewModel
) : HomeNavigation, HomeNavigation.Routing by router {

    override fun init() {
        homeViewModel.getNavEvents().observe { event ->
            when (event) {
                is HomeNavigationEvent.GoToGame -> goToGame()
            }
        }
    }
}

class HomeNavigationController : HomeNavigation.NavigationControl {
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

    interface NavigationControl {
        fun getNavEvents(): LiveData<HomeNavigationEvent>

        fun onGoToGame()
    }

    interface Routing: LiveDataObserver {
        fun goToGame()
    }
}