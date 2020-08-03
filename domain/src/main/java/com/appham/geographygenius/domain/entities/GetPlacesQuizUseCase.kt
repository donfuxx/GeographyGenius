package com.appham.geographygenius.domain.entities

import org.koin.dsl.module

val getPlacesQuizUseCaseModule = module {
    single {
        GetPlacesQuizUseCase(get())
    }
    single<PlacesRepository> {
        CachingPlacesRepository(get(), get())
    }
}

class GetPlacesQuizUseCase(
    private val placesRepository: PlacesRepository
) {

    suspend fun execute(): PlacesQuiz { //TODO: add filter
        with(placesRepository.getPlaces().toMutableList()) {
            val placeToGuess = removeAt((0 until size).random())
            val wrongPlaces = mutableListOf<Place>()

            while (wrongPlaces.size < 3) {
                wrongPlaces.add(removeAt((0 until size).random()))
            }

            return PlacesQuiz(
                placeToGuess, wrongPlaces
            )
        }
    }
}