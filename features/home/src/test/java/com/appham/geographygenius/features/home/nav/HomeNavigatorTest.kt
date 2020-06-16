package com.appham.geographygenius.features.home.nav

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.appham.geographygenius.features.home.InstantExecutorExtension
import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(InstantExecutorExtension::class)
internal class HomeNavigatorTest {

    private val router: HomeNavigation.Routing = spyk(
        object :
            HomeNavigation.Routing {
            override fun goToGame() {}

            override fun <T> LiveData<T>.observe(onChange: (T) -> Unit) {
                observeForever(onChange)
            }

        }
    )

    private val navigationController: HomeNavigation.NavigationControl = mockk()

    private val navEvents: MutableLiveData<HomeNavigationEvent> = spyk(MutableLiveData())

    private val sut = HomeNavigator(
        router,
        navigationController
    )

    init {
        every { navigationController.getNavEvents() } returns navEvents
    }

    @Test
    fun `Given init called When GoToGame emitted Then call goToGame`() {
        sut.init()

        verify { navigationController.getNavEvents() }

        navEvents.value = HomeNavigationEvent.GoToGame

        verify { router.goToGame() }
    }

    @Test
    fun `Given init called When None emitted Then don't call goToGame`() {
        sut.init()

        verify { navigationController.getNavEvents() }

        navEvents.value = HomeNavigationEvent.None

        verify(exactly = 0) { router.goToGame() }
    }

    @Test
    fun `Given init called When no events emitted Then don't call goToGame`() {
        sut.init()

        verify { navigationController.getNavEvents() }

        verify(exactly = 0) { router.goToGame() }
    }

}