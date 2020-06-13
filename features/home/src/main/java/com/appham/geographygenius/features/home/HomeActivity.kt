package com.appham.geographygenius.features.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity() {

    private val homeViewModel: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        btnGoToGame.setOnClickListener { homeViewModel.onGoToGame() }
    }
}