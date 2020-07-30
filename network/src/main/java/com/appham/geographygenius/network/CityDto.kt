package com.appham.geographygenius.network

import androidx.annotation.Keep
import com.appham.geographygenius.domain.entities.Coords
import com.appham.geographygenius.domain.entities.Place
import com.appham.geographygenius.domain.entities.PlaceType
import com.squareup.moshi.Json

@Keep
data class CityDto(
    val geonameid: String,
    val latitude: Double,
    val longitude: Double,
    val name: String,
    val population: Int,
    val timezone: CountryTimeZone
)

fun CityDto.toPlace(): Place = Place(
    geonameid, name, PlaceType.CITY, Coords(latitude, longitude), timezone.countryCode
)

enum class CountryTimeZone(val countryCode: String, val timezone: String) {
    @Json(name = "Europe/London") GB("GB","Europe/London")
}
