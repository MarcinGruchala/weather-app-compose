package com.weather.network

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
object NetworkModule {

  @[Provides Singleton]
  fun moshi(): Moshi = Moshi.Builder().build()

  @[Provides Singleton]
  fun moshiConverterFactory(moshi: Moshi): Converter.Factory =
    MoshiConverterFactory.create(moshi)

  @[Provides Singleton]
  fun baseUrl(configuration: NetworkConfiguration): String =
    configuration.baseUrl()

  @[Provides Singleton]
  fun retrofit(
    converterFactory: Converter.Factory,
    baseUrl: String): Retrofit =
    Retrofit
      .Builder()
      .addConverterFactory(converterFactory)
      .baseUrl(baseUrl)
      .build()

  @[Provides Singleton]
  fun weatherApi(retrofit: Retrofit): WeatherApi =
    retrofit.create()
}
