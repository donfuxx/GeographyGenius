package com.appham.geographygenius.features.game

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appham.geographygenius.common.utils.CoroutineContextProvider
import com.appham.geographygenius.domain.entities.GetPlacesQuizUseCase
import com.appham.geographygenius.domain.entities.PlacesQuiz
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val gameViewModelModule = module {
    viewModel {
        GameViewModel(get(), get())
    }
}

class GameViewModel(
    private val getPlacesQuizUseCase: GetPlacesQuizUseCase,
    private val contextProvider: CoroutineContextProvider
) : ViewModel() {

    private val placesQuiz: MutableLiveData<PlacesQuiz> = MutableLiveData()

    fun getPlacesQuiz(): LiveData<PlacesQuiz> = placesQuiz

    fun loadPlaces() {
        viewModelScope.launch(contextProvider.io) {
            placesQuiz.postValue(getPlacesQuizUseCase.execute())
        }
    }

}

