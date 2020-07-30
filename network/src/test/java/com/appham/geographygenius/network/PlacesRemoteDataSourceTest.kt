package com.appham.geographygenius.network

import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

internal class PlacesRemoteDataSourceTest {

    private val placesApi: PlacesApi = mockk()
    
    private val sut = PlacesRemoteDataSource(placesApi)

    @Test
    fun `Given placesApi returns cities When getPlaces is called Then return list of places`() = runBlocking {
        val expectedCities = listOf(
            CityDto(
                geonameid = "123",
                latitude = 10.01,
                longitude = 5.05,
                name = "Foo town",
                population = 1000,
                timezone = CountryTimeZone.GB
            )
        )
        coEvery { placesApi.getCities() } returns expectedCities
        val actual = sut.getPlaces()
        actual shouldBe expectedCities.map{ cityDto ->
            cityDto.toPlace()
        }
    }
}