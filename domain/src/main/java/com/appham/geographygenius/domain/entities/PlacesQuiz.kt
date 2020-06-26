package com.appham.geographygenius.domain.entities

data class PlacesQuiz(
    val placeToGuess: Place,
    val wrongPlaces: List<Place>
)