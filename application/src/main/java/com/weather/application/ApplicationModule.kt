package com.weather.application

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import timber.log.Timber

@[Module InstallIn(SingletonComponent::class)]
object ApplicationModule {

    @Provides
    fun timberDebugTree(): Timber.DebugTree =
        Timber.DebugTree()
}