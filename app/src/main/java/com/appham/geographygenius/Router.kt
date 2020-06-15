package com.appham.geographygenius

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.appham.geographygenius.features.game.GameActivity

class Router(private val activity: AppCompatActivity) : Routing {

    override fun goToGame() {
        activity.startActivity(Intent(activity, GameActivity::class.java))
    }

    override fun <T> LiveData<T>.observe(onChange: (T) -> Unit) {
        observe(activity, Observer { onChange(it) })
    }
}

interface Routing {

    fun goToGame()

    fun <T> LiveData<T>.observe(onChange: (T) -> Unit)
}