package com.appham.geographygenius.cache

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.appham.geographygenius.domain.entities.Coords
import com.appham.geographygenius.domain.entities.Place
import com.appham.geographygenius.domain.entities.PlaceType

@Entity
data class CityEntity(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "geo_name_id") val geonameid: String,
    @ColumnInfo(name = "latitude")val latitude: Double,
    @ColumnInfo(name = "longitude")val longitude: Double,
    @ColumnInfo(name = "name")val name: String,
    @ColumnInfo(name = "population")val population: Int,
    @ColumnInfo(name = "timezone")val timezone: String
)

fun CityEntity.toPlace() = Place(
    geonameid, name, PlaceType.CITY, Coords(latitude, longitude), timezone
)