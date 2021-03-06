package com.appham.geographygenius.features.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.appham.geographygenius.features.home.nav.HomeNavigation
import kotlinx.android.synthetic.main.activity_home.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class HomeActivity : AppCompatActivity() {

    private val homeViewModel: HomeViewModel by viewModel()

    private val homeNavigator: HomeNavigation by inject { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        homeNavigator.init()

        btnGoToGame.setOnClickListener {
            homeViewModel.onGoToGame()
        }
    }
}