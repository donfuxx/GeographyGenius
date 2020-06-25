package com.appham.geographygenius.domain.entities

interface PlacesRepository {
    suspend fun getPlaces(): List<Place>
}