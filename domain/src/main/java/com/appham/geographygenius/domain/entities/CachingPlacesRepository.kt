package com.appham.geographygenius.domain.entities

class CachingPlacesRepository(
    private val remoteSource: PlacesDataSource,
    private val localSource: EditablePlacesDataSource
) : PlacesRepository {

    override suspend fun getPlaces(): List<Place> = remoteSource.getPlaces().also { places ->
        localSource.addPlaces(*places.toTypedArray())
    }
}

interface PlacesRepository {
    suspend fun getPlaces(): List<Place>
}
