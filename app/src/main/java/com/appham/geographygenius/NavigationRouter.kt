package com.appham.geographygenius

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.appham.geographygenius.features.game.GameActivity

class NavigationRouter(private val activity: AppCompatActivity) {

    fun <T> observe(navEvents: LiveData<T>, onChange: (T) -> Unit) {
        navEvents.observe(activity, Observer {
            onChange(it)
        })
    }

    fun goToGame() {
        activity.startActivity(Intent(activity, GameActivity::class.java))
    }

}

fun <T> LiveData<T>.observe(navigationRouter: NavigationRouter, onChange: (T) -> Unit) {
    navigationRouter.observe(this, onChange)
}