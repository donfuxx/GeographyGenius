package com.appham.geographygenius.di

import com.appham.geographygenius.features.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel {
        HomeViewModel()
    }
}