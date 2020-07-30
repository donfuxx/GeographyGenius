package com.appham.geographygenius.network

import retrofit2.http.GET

interface PlacesApi {

    @GET("api/cities.json")
    suspend fun getCities() : List<CityDto>
}