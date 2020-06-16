package com.appham.geographygenius

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.appham.geographygenius.features.game.GameActivity
import com.appham.geographygenius.features.home.nav.HomeNavigation
import org.koin.dsl.module
import java.lang.ref.WeakReference

val routerModule = module {
    factory<HomeNavigation.Routing> { (activity: AppCompatActivity) -> Router(activity) }
}

class Router(activity: AppCompatActivity) : HomeNavigation.Routing {

    private val activityRef: WeakReference<AppCompatActivity> = WeakReference(activity)

    override fun goToGame() {
        activityRef.get()?.let{ activity ->
            activity.startActivity(Intent(activity, GameActivity::class.java))
        }
    }

    override fun <T> LiveData<T>.observe(onChange: (T) -> Unit) {
        activityRef.get()?.let { activity ->
            observe(activity, Observer { onChange(it) })
        }
    }
}