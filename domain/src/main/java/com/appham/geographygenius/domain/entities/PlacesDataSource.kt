package com.appham.geographygenius.domain.entities

interface PlacesDataSource {
    suspend fun getPlaces(): List<Place>
}

interface EditablePlacesDataSource : PlacesDataSource {
    suspend fun addPlaces(vararg places: Place)
}