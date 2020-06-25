package com.appham.geographygenius.features.home.nav

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.appham.geographygenius.common.utils.LiveDataObserver
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module

val homeNavigatorModule = module {
    single<HomeNavigation> { (activity: AppCompatActivity) ->
        HomeNavigator(get {
            parametersOf(
                activity
            )
        }, get())
    }
    single<HomeNavigation.NavigationControl> { HomeNavigationController() }
}

class HomeNavigator(
    private val router: HomeNavigation.Routing,
    private val navigationController: HomeNavigation.NavigationControl
) : HomeNavigation, HomeNavigation.Routing by router {

    override fun init() {
        navigationController.getNavEvents().observe { event ->
            when (event) {
                is HomeNavigation.Event.GoToGame -> goToGame()
            }
        }
    }
}

class HomeNavigationController : HomeNavigation.NavigationControl {
    private val navEvents: MutableLiveData<HomeNavigation.Event> = MutableLiveData()

    override fun getNavEvents(): LiveData<HomeNavigation.Event> = navEvents

    override fun onGoToGame() {
        navEvents.value = HomeNavigation.Event.GoToGame
    }
}

interface HomeNavigation {
    fun init()

    interface NavigationControl {
        fun getNavEvents(): LiveData<Event> // TODO use SingleLiveEvent

        fun onGoToGame()
    }

    interface Routing: LiveDataObserver {
        fun goToGame()
    }

    sealed class Event {
        object GoToGame : Event()
        object None : Event()
    }
}