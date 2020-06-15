package com.appham.geographygenius

import androidx.appcompat.app.AppCompatActivity
import com.appham.geographygenius.features.home.HomeNavigation
import com.appham.geographygenius.features.home.HomeNavigationEvent
import com.appham.geographygenius.features.home.HomeViewModel
import org.koin.dsl.module

val homeNavigatorModule = module {
    single<HomeNavigation> { (activity: AppCompatActivity, homeViewModel: HomeViewModel) ->
        HomeNavigator(Router(activity), homeViewModel)
    }
}

class HomeNavigator(
    private val router: Routing,
    private val homeViewModel: HomeViewModel
) : HomeNavigation, Routing by router {

    override fun init() {
        homeViewModel.getNavEvents().observe { event ->
            when(event) {
                is HomeNavigationEvent.GoToGame -> goToGame()
            }
        }
    }
}