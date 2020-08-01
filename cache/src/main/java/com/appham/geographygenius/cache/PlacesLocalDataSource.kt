package com.appham.geographygenius.cache

import com.appham.geographygenius.domain.entities.Place
import com.appham.geographygenius.domain.entities.PlacesRepository

class PlacesLocalDataSource(
    private val citiesDb: CityDatabase
) : PlacesRepository {

    override suspend fun getPlaces(): List<Place> = citiesDb.cityDao().getAll().map { cityEntity ->
        cityEntity.toPlace()
    }

}