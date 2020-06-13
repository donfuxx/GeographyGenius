package com.appham.geographygenius

import android.app.Activity
import android.content.Intent
import com.appham.game.GameActivity
import com.appham.geographygenius.features.home.HomeNavigation
import org.koin.dsl.module

val homeNavigatorModule = module {
    single<HomeNavigation> { (activity: Activity) -> HomeNavigator(activity) }
}

class HomeNavigator(private val activity: Activity) : HomeNavigation {

    override fun goToGame() {
        activity.startActivity(Intent(activity, GameActivity::class.java))
    }

}