package com.appham.geographygenius.domain.entities

class CachingPlacesRepository(
    private val remoteSource: ApiPlacesDataSource,
    private val localSource: DbPlacesDataSource
) : PlacesRepository {

    override suspend fun getPlaces(): List<Place> = remoteSource.getPlaces().also { places ->
        localSource.addPlaces(*places.toTypedArray())
    }
}

interface PlacesRepository {
    suspend fun getPlaces(): List<Place>
}
