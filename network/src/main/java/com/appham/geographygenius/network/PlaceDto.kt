package com.appham.geographygenius.network

import androidx.annotation.Keep
import com.appham.geographygenius.domain.entities.Coords
import com.appham.geographygenius.domain.entities.Place
import com.appham.geographygenius.domain.entities.PlaceType

@Keep
data class PlaceDto(
    val id: String,
    val name: String,
    val type: PlaceTypeDto,
    val coords: CoordsDto,
    val country: String
)

enum class PlaceTypeDto {
    CITY, MOUNTAIN
}

@Keep
data class CoordsDto(
    val lat: Double,
    val lng: Double
)

fun PlaceDto.toDomainModel(): Place = Place(
    id, name, type.toDomainModel(), coords.toDomainModel(), country
)

fun PlaceTypeDto.toDomainModel(): PlaceType = when(this) {
    PlaceTypeDto.CITY -> PlaceType.CITY
    PlaceTypeDto.MOUNTAIN -> PlaceType.MOUNTAIN
}

fun CoordsDto.toDomainModel(): Coords = Coords(
    lat, lng
)