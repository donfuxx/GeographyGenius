package com.appham.geographygenius.features.game

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class GameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
    }

    companion object {
        fun getLaunchIntent(context: Context) = Intent(context, GameActivity::class.java)
    }
}