package com.appham.geographygenius.cache

import com.appham.geographygenius.domain.entities.EditablePlacesDataSource
import com.appham.geographygenius.domain.entities.Place

class LocalPlacesDataSource(
    private val citiesDb: CityDatabase
) : EditablePlacesDataSource {

    override suspend fun getPlaces(): List<Place> = citiesDb.cityDao().getAll().map { cityEntity ->
        cityEntity.toPlace()
    }

    override suspend fun addPlaces(vararg places: Place) {
        places.map { place ->
            place.toCityEntity()
        }.also { cities ->
            citiesDb.cityDao().updateAll(*cities.toTypedArray())
        }
    }

}
