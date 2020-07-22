package com.appham.geographygenius.features.game

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.appham.geographygenius.common.utils.lazyWithScope
import com.appham.geographygenius.common.utils.showSnackbar
import com.appham.geographygenius.common.utils.withScope
import com.appham.geographygenius.domain.entities.PlacesQuiz
import kotlinx.android.synthetic.main.activity_game.*
import kotlinx.coroutines.Deferred
import org.koin.androidx.viewmodel.ext.android.viewModel

class GameActivity : AppCompatActivity() {

    private val gameViewModel: GameViewModel by viewModel()

    private val mapInteractor: Deferred<MapInteractor> by lazyWithScope(lifecycleScope) {
        map_view.getMapInteractor()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        gameViewModel.loadPlaces()

        gameViewModel.getPlacesQuiz().observe(this, Observer { state ->
            when (state) {
                is GameViewState.Success -> updateMap(state.placesQuiz)
                is GameViewState.Error -> map_view.showSnackbar(state.throwable.localizedMessage.orEmpty())
            }
        })

        map_view.onCreate(savedInstanceState)
    }

    private fun updateMap(placesQuiz: PlacesQuiz) {
        place_text.text = placesQuiz.placeToGuess.name
        mapInteractor.withScope(lifecycleScope) {
            addMarker(placesQuiz.placeToGuess.coords, placesQuiz.placeToGuess.name)
            moveCamera(placesQuiz.placeToGuess.coords)
        }
    }

}