package com.appham.geographygenius

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.appham.geographygenius.features.game.GameActivity
import com.appham.geographygenius.features.home.HomeNavigation
import com.appham.geographygenius.features.home.HomeNavigationEvent
import com.appham.geographygenius.features.home.HomeViewModel
import org.koin.dsl.module

val homeNavigatorModule = module {
    single<HomeNavigation> { (activity: AppCompatActivity, homeViewModel: HomeViewModel) ->
        HomeNavigator(activity, homeViewModel)
    }
}

class HomeNavigator(
    private val activity: AppCompatActivity,
    private val homeViewModel: HomeViewModel
) : HomeNavigation {

    override fun init() {
        homeViewModel.getNavEvents().observe(activity, Observer { event ->
            when(event) {
                is HomeNavigationEvent.GoToGame -> goToGame()
            }
        })
    }

    private fun goToGame() {
        activity.startActivity(Intent(activity, GameActivity::class.java))
    }

}