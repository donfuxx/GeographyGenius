package com.appham.geographygenius

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.appham.geographygenius.features.home.HomeNavigationEvent
import com.appham.geographygenius.features.home.HomeViewModel
import io.mockk.*
import junit.framework.Assert.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(InstantExecutorExtension::class)
internal class HomeNavigatorTest {

    private val activity: AppCompatActivity = mockk(relaxed = true)

    private val homeViewModel: HomeViewModel = mockk()

    private val navEvents: MutableLiveData<HomeNavigationEvent> = spyk(MutableLiveData())

    private val sut = HomeNavigator(activity, homeViewModel)

    init {
        every { homeViewModel.getNavEvents() } returns navEvents
//        every { activity.goToGame() } returns Unit
    }


    @Test
    fun `Given init called Then observe navEvents`() {
        sut.init()

        verify { homeViewModel.getNavEvents() }

        verify { navEvents.observe(activity, any())}
    }

    @Test
    fun `Given init called When GoToGame emitted Then call goToGame`() {
        sut.init()

        val onChanged = slot<Observer<HomeNavigationEvent>>()

        verify { navEvents.observe(activity, capture(onChanged))}

        onChanged.captured.onChanged(HomeNavigationEvent.GoToGame)

//        verify { activity.startActivity(any()) }

        val intent = slot<Intent>()

        verify(exactly = 1) { activity.startActivity(capture(intent)) }

        assertEquals(intent.captured.action, "")

//        val targetActivity = slot<Class<GameActivity>>()
//
//        verify(exactly = 1) { activity.launchActivity(capture(targetActivity)) }
//
//        assertEquals(GameActivity::class.java, targetActivity)

//        mockkObject(GameActivity)
//
//        val mockIntent: Intent = mockk()
//        every { mockIntent.toString() } returns "GameActivity"
//
//        every { GameActivity.getLaunchIntent(activity) } returns mockIntent
//
//        verify(exactly = 1) { activity.startActivity(mockIntent) }
    }
}