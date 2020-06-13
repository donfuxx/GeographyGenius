package com.appham.geographygenius.features.home

import androidx.lifecycle.ViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeViewModelModule = module {
    viewModel {
        HomeViewModel()
    }
}

class HomeViewModel : ViewModel() {

    fun onGoToGame() {
    }
}

interface HomeNavigation {
    fun goToGame()
}
