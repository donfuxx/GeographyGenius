package com.appham.geographygenius.features.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(InstantExecutorExtension::class)
internal class HomeNavigatorTest {

    private val router: HomeRouting = spyk(object : HomeRouting {
        override fun goToGame() {}

        override fun <T> LiveData<T>.observe(onChange: (T) -> Unit) {
            observeForever(onChange)
        }

    })

    private val homeViewModel: HomeViewModel = mockk()

    private val navEvents: MutableLiveData<HomeNavigationEvent> = spyk(MutableLiveData())

    private val sut = HomeNavigator(
        router,
        homeViewModel
    )

    init {
        every { homeViewModel.getNavEvents() } returns navEvents
    }

    @Test
    fun `Given init called When GoToGame emitted Then call goToGame`() {
        sut.init()

        verify { homeViewModel.getNavEvents() }

        navEvents.value = HomeNavigationEvent.GoToGame

        verify { router.goToGame() }
    }

    @Test
    fun `Given init called When None emitted Then don't call goToGame`() {
        sut.init()

        verify { homeViewModel.getNavEvents() }

        navEvents.value = HomeNavigationEvent.None

        verify (exactly = 0) { router.goToGame() }
    }

    @Test
    fun `Given init called When no events emitted Then don't call goToGame`() {
        sut.init()

        verify { homeViewModel.getNavEvents() }

        verify (exactly = 0) { router.goToGame() }
    }

}