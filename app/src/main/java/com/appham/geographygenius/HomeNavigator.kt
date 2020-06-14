package com.appham.geographygenius

import androidx.appcompat.app.AppCompatActivity
import com.appham.geographygenius.features.home.HomeNavigation
import com.appham.geographygenius.features.home.HomeNavigationEvent
import com.appham.geographygenius.features.home.HomeViewModel
import org.koin.dsl.module

val homeNavigatorModule = module {
    single<HomeNavigation> { (activity: AppCompatActivity, homeViewModel: HomeViewModel) ->
        HomeNavigator(NavigationRouter(activity), homeViewModel)
    }
}

class HomeNavigator(
    private val navigationRouter: NavigationRouter,
    private val homeViewModel: HomeViewModel
) : HomeNavigation {

    override fun init() {

        homeViewModel.getNavEvents().observe(navigationRouter)  { event ->
            when(event) {
                is HomeNavigationEvent.GoToGame -> navigationRouter.goToGame()
            }
        }
    }

}
