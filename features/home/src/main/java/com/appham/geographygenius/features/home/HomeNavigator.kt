package com.appham.geographygenius.features.home

import androidx.appcompat.app.AppCompatActivity
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module

val homeNavigatorModule = module {
    single<HomeNavigation> { (activity: AppCompatActivity, homeViewModel: HomeViewModel) ->
        HomeNavigator(get { parametersOf(activity) }, homeViewModel)
    }
}

class HomeNavigator(
    private val router: HomeRouting,
    private val homeViewModel: HomeViewModel
) : HomeNavigation, HomeRouting by router {

    override fun init() {
        homeViewModel.getNavEvents().observe { event ->
            when (event) {
                is HomeNavigationEvent.GoToGame -> goToGame()
            }
        }
    }
}