package com.appham.geographygenius.features.game

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appham.geographygenius.domain.entities.GetPlacesQuizUseCase
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val gameViewModelModule = module {
    viewModel {
        GameViewModel(get())
    }
}

class GameViewModel (
    private val getPlacesQuizUseCase: GetPlacesQuizUseCase
): ViewModel() {

    fun loadPlaces() {
        viewModelScope.launch {
            getPlacesQuizUseCase.execute()
        }
    }

}

