package com.appham.geographygenius

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.appham.geographygenius.features.game.GameActivity
import com.appham.geographygenius.features.home.nav.HomeRouting
import org.koin.dsl.module

val routerModule = module {
    factory<HomeRouting> { (activity: AppCompatActivity) -> Router(activity) }
}

class Router(private val activity: AppCompatActivity) :
    HomeRouting {

    override fun goToGame() {
        activity.startActivity(Intent(activity, GameActivity::class.java))
    }

    override fun <T> LiveData<T>.observe(onChange: (T) -> Unit) {
        observe(activity, Observer { onChange(it) })
    }
}