package com.appham.geographygenius.features.game

import com.appham.geographygenius.common.testutils.CoroutineTest
import com.appham.geographygenius.common.testutils.LiveDataTest
import com.appham.geographygenius.common.testutils.TestContextProvider
import com.appham.geographygenius.domain.entities.GetPlacesQuizUseCase
import com.appham.geographygenius.domain.entities.PlacesQuiz
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeTypeOf
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class GameViewModelTest : CoroutineTest, LiveDataTest {

    private val getPlacesQuizUseCase: GetPlacesQuizUseCase = mockk(relaxed = true)

    private lateinit var sut: GameViewModel

    @BeforeEach
    fun setUp() {
        sut = GameViewModel(getPlacesQuizUseCase, TestContextProvider())
    }

    @Test
    fun `When loadPlaces Then execute getPlacesQuizUseCase`() {
        sut.loadPlaces()

        coVerify { getPlacesQuizUseCase.execute() }
    }

    @Test
    fun `When loadPlaces Then post placesQuiz value`() {
        val expectedPlacesQuiz : PlacesQuiz = mockk()
        coEvery { getPlacesQuizUseCase.execute() } returns expectedPlacesQuiz

        sut.loadPlaces()

        sut.getPlacesQuiz().observeForever { state ->
            state.shouldBeTypeOf<GameViewState.Success>()
            state as GameViewState.Success
            state.placesQuiz shouldBe expectedPlacesQuiz
        }
    }

    @Test
    fun `When loadPlaces with error Then post error`() {
        val error = Throwable("error")
        coEvery { getPlacesQuizUseCase.execute() } throws error

        sut.loadPlaces()

        sut.getPlacesQuiz().observeForever { state ->
            state.shouldBeTypeOf<GameViewState.Error>()
            state as GameViewState.Error
            state.throwable shouldBe error
        }
    }
}