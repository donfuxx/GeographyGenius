package com.appham.geographygenius.features.game

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appham.geographygenius.common.utils.CoroutineContextProvider
import com.appham.geographygenius.domain.entities.GetPlacesQuizUseCase
import com.appham.geographygenius.domain.entities.PlacesQuiz
import com.appham.geographygenius.features.game.GameViewState.Error
import com.appham.geographygenius.features.game.GameViewState.Success
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
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

    private val placesQuiz: MutableLiveData<GameViewState> = MutableLiveData()

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        placesQuiz.value = Error(throwable)
    }

    fun getPlacesQuiz(): LiveData<GameViewState> = placesQuiz

    fun loadPlaces() {
        placesQuiz.value = GameViewState.Loading
        viewModelScope.launch(exceptionHandler) {
            withContext(contextProvider.io) {
                placesQuiz.postValue(Success(getPlacesQuizUseCase.execute()))
            }
        }
    }
}

sealed class GameViewState {
    object Loading : GameViewState()
    data class Error(val throwable: Throwable) : GameViewState()
    data class Success(val placesQuiz: PlacesQuiz) : GameViewState()
}

