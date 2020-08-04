package com.appham.geographygenius.network

import com.appham.geographygenius.domain.entities.ApiPlacesDataSource
import com.appham.geographygenius.domain.entities.Place

class RemotePlacesDataSource(
    private val placesApi: PlacesApi
) : ApiPlacesDataSource {

    override suspend fun getPlaces():List<Place> = placesApi.getCities().map { cityDto ->
        cityDto.toPlace()
    }

}