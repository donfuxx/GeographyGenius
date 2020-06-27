package com.appham.geographygenius.features.game

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appham.geographygenius.domain.entities.GetPlacesQuizUseCase
import com.appham.geographygenius.domain.entities.PlacesQuiz
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

    private val placesQuiz: MutableLiveData<PlacesQuiz> = MutableLiveData()

    fun getPlacesQuiz(): LiveData<PlacesQuiz> = placesQuiz

    fun loadPlaces() {
        viewModelScope.launch {
            placesQuiz.postValue(getPlacesQuizUseCase.execute())
        }
    }

}

