package com.appham.geographygenius.features.home

import androidx.lifecycle.ViewModel
import com.appham.geographygenius.features.home.nav.HomeNavigation
import com.appham.geographygenius.features.home.nav.HomeNavigationController
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeViewModelModule = module {
    viewModel {
        HomeViewModel(get())
    }
}

class HomeViewModel(
    homeNavigationController: HomeNavigationController
) : ViewModel(), HomeNavigation.HomeNavigationControl by homeNavigationController

