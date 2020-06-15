package com.appham.geographygenius.features.home.nav

import androidx.appcompat.app.AppCompatActivity
import com.appham.geographygenius.features.home.HomeNavigation
import com.appham.geographygenius.features.home.HomeNavigationEvent
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