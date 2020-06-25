package com.appham.geographygenius.features.game

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appham.geographygenius.domain.entities.PlacesRepository
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val gameViewModelModule = module {
    viewModel {
        GameViewModel(get())
    }
}

class GameViewModel (
    private val placesRepository: PlacesRepository
): ViewModel() {

    fun loadPlaces() {
        viewModelScope.launch {
            placesRepository.getPlaces()
        }
    }

}

