package com.appham.geographygenius.features.game

import com.appham.geographygenius.common.testutils.CoroutineTest
import com.appham.geographygenius.common.testutils.TestContextProvider
import com.appham.geographygenius.domain.entities.GetPlacesQuizUseCase
import io.mockk.coVerify
import io.mockk.mockk
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class GameViewModelTest : CoroutineTest {

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
}