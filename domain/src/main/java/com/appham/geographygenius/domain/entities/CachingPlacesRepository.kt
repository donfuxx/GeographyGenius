package com.appham.geographygenius.domain.entities

class CachingPlacesRepository(
    private val remoteSource: ApiPlacesDataSource,
    private val localSource: DbPlacesDataSource
) : PlacesRepository {

    override suspend fun getPlacesFromRemote(): List<Place> = remoteSource.getPlaces().also { places ->
        localSource.addPlaces(*places.toTypedArray())
    }

    override suspend fun getPlacesFromLocal(): List<Place> = localSource.getPlaces()
}

interface PlacesRepository {
    suspend fun getPlacesFromRemote(): List<Place>
    suspend fun getPlacesFromLocal(): List<Place>
}
