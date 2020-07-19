package com.appham.geographygenius.features.game

import com.appham.geographygenius.common.testutils.CoroutineTest
import com.appham.geographygenius.common.testutils.LiveDataTest
import com.appham.geographygenius.common.testutils.TestContextProvider
import com.appham.geographygenius.domain.entities.GetPlacesQuizUseCase
import com.appham.geographygenius.domain.entities.PlacesQuiz
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class GameViewModelTest : CoroutineTest, LiveDataTest {

    private val getPlacesQuizUseCase: GetPlacesQuizUseCase = mockk()

    private lateinit var sut: GameViewModel

    @BeforeEach
    fun setUp() {
        sut = GameViewModel(getPlacesQuizUseCase, TestContextProvider())
    }

    @Test
    fun getPlacesQuiz() {
    }

    @Test
    fun `When loadPlaces Then execute getPlacesQuizUseCase`() {
        sut.loadPlaces()

        coVerify { getPlacesQuizUseCase.execute() }
    }

    @Test
    fun `When loadPlaces Then post placesQuiz value`() {
        sut.loadPlaces()

        val expectedPlacesQuiz : PlacesQuiz = mockk()
        coEvery { getPlacesQuizUseCase.execute() } returns expectedPlacesQuiz

        sut.getPlacesQuiz().observeForever { actualPlacesQuiz ->
            assertEquals(actualPlacesQuiz, expectedPlacesQuiz)
        }
    }
}