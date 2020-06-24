package com.appham.geographygenius.network

import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface PlacesApi {

    @GET("api/places.json")
    fun getPlaces() : Deferred<List<PlaceDto>>
}