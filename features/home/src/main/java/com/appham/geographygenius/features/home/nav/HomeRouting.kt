package com.appham.geographygenius.features.home.nav

import com.appham.geographygenius.common.utils.LiveDataObserver

interface HomeRouting: LiveDataObserver {

    fun goToGame()

}