package com.appham.geographygenius.network

import com.appham.geographygenius.domain.entities.Place
import com.appham.geographygenius.domain.entities.PlacesDataSource

class RemotePlacesDataSource(
    private val placesApi: PlacesApi
) : PlacesDataSource {

    override suspend fun getPlaces():List<Place> = placesApi.getCities().map { cityDto ->
        cityDto.toPlace()
    }

}