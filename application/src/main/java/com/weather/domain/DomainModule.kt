package com.weatherappcomposedemo.domain

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
abstract class DomainModule {

  @[Binds Singleton]
  internal abstract fun weatherRepository(
    implementation: WeatherRepositoryImpl): WeatherRepository
}
