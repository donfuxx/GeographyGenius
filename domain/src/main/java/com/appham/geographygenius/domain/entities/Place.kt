package com.appham.geographygenius.domain.entities

data class Place(
    val id: String,
    val name: String,
    val type: PlaceType,
    val coords: Coords,
    val population: Int,
    val country: String
)

enum class PlaceType {
    CITY, MOUNTAIN
}

data class Coords(
    val lat: Double,
    val lng: Double
)