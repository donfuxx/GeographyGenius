package com.appham.geographygenius.cache

import com.appham.geographygenius.domain.entities.DbPlacesDataSource
import com.appham.geographygenius.domain.entities.Place

class LocalPlacesDataSource(
    private val cityDao: CityDao
) : DbPlacesDataSource {

    override suspend fun getPlaces(): List<Place> = cityDao.getAll().map { cityEntity ->
        cityEntity.toPlace()
    }

    override suspend fun addPlaces(vararg places: Place) {
        places.map { place ->
            place.toCityEntity()
        }.also { cities ->
            cityDao.updateAll(*cities.toTypedArray())
        }
    }

}
