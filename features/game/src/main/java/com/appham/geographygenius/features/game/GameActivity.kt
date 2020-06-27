package com.appham.geographygenius.features.game

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_game.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class GameActivity : AppCompatActivity() {

    private val gameViewModel: GameViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        gameViewModel.loadPlaces()

        gameViewModel.getPlacesQuiz().observe(this, Observer { placesQuiz ->
            place_text.text = placesQuiz.placeToGuess.name
        })
    }

}