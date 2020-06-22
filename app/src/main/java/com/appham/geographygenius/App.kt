package com.appham.geographygenius

import android.app.Application
import com.appham.geographygenius.features.home.homeViewModelModule
import com.appham.geographygenius.features.home.nav.homeNavigatorModule
import com.appham.geographygenius.network.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger()
            androidContext(this@App)
            modules(listOf(homeViewModelModule,
                homeNavigatorModule, networkModule, routerModule))
        }
    }
}