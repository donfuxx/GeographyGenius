package com.appham.geographygenius

import androidx.appcompat.app.AppCompatActivity
import com.appham.geographygenius.features.home.HomeViewModel
import io.mockk.mockk

internal class HomeNavigatorTest {

    private val activity: AppCompatActivity = mockk(relaxed = true)

    private val homeViewModel: HomeViewModel = mockk()

    private val sut = HomeNavigator(activity, homeViewModel)


}