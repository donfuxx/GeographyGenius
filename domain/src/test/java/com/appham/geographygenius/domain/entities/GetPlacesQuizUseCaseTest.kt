package com.appham.geographygenius.domain.entities

import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

internal class GetPlacesQuizUseCaseTest {

    private val repository: PlacesRepository = mockk()

    private val sut = GetPlacesQuizUseCase(repository)

    @Test
    fun `When execute is called Then return PlacesQuiz`() = runBlocking {
        //TODO
    }

}