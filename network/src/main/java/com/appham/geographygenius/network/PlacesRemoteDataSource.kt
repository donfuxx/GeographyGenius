package com.appham.geographygenius.network

import com.appham.geographygenius.domain.entities.Place
import com.appham.geographygenius.domain.entities.PlacesRepository

class PlacesRemoteDataSource(
    private val placesApi: PlacesApi
) : PlacesRepository {

    override suspend fun getPlaces():List<Place> = placesApi.getCities().map { cityDto ->
        cityDto.toPlace()
    }

}