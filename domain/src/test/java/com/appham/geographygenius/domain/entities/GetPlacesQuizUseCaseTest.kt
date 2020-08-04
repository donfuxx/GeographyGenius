package com.appham.geographygenius.domain.entities

import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class GetPlacesQuizUseCaseTest {

    private val repository: PlacesRepository = mockk()

    private val sut = GetPlacesQuizUseCase(repository)

    @Test
    fun `When execute is called Then return PlacesQuiz`() = runBlocking {
        val places: List<Place> = listOf(
            Place("A", "Some place", PlaceType.CITY, Coords(1.1, 1.2), 111,"us"),
            Place("B", "Another place", PlaceType.CITY, Coords(1.3, 1.4), 222,"de"),
            Place("C", "Yet Another place", PlaceType.CITY, Coords(1.5, 1.6), 333,"es"),
            Place("D", "somewhere", PlaceType.CITY, Coords(1.7, 1.8), 444,"fr")
        )
        coEvery { repository.getPlacesFromRemote() } returns places

        val placesQuiz = sut.execute()

        assertTrue(places.contains(placesQuiz.placeToGuess))
        assertTrue(placesQuiz.wrongPlaces.size == 3)
        assertFalse(placesQuiz.wrongPlaces.contains(placesQuiz.placeToGuess))
    }

}