package com.weather.application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import javax.inject.Inject

@HiltAndroidApp
class WeatherApplication : Application() {

    @Inject
    lateinit var debugTree: Timber.DebugTree

    override fun onCreate() {
        super.onCreate()

        Timber.plant(debugTree)
    }
}
