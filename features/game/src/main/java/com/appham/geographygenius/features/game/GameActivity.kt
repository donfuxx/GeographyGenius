package com.appham.geographygenius.features.game

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_game.*
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class GameActivity : AppCompatActivity() {

    private val gameViewModel: GameViewModel by viewModel()

    private val mapInteractor: Deferred<MapInteractor> by lazy {
        lifecycleScope.async {
            map_view.getMapInteractor()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        gameViewModel.loadPlaces()

        gameViewModel.getPlacesQuiz().observe(this, Observer { placesQuiz ->
            place_text.text = placesQuiz.placeToGuess.name
            lifecycleScope.launch {
                mapInteractor.await().apply {
                    addMarker(placesQuiz.placeToGuess.coords, placesQuiz.placeToGuess.name)
                    moveCamera(placesQuiz.placeToGuess.coords)
                }
            }
        })

        map_view.onCreate(savedInstanceState)
    }

}