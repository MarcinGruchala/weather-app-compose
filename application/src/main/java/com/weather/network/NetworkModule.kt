package com.weatherappcomposedemo.network

import androidx.core.view.ViewCompat.ScrollIndicators
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
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
  internal fun adapterFactory(): CallAdapter.Factory =
    RxJava3CallAdapterFactory.createWithScheduler(Schedulers.io())

  @[Provides Singleton]
  fun baseUrl(configuration: NetworkConfiguration): String =
    configuration.baseUrl()

  @[Provides Singleton]
  fun retrofit(
    adapterFactory: CallAdapter.Factory,
    converterFactory: Converter.Factory,
    baseUrl: String): Retrofit =
    Retrofit
      .Builder()
      .addConverterFactory(converterFactory)
      .addCallAdapterFactory(adapterFactory)
      .baseUrl(baseUrl)
      .build()

  @[Provides Singleton]
  fun weatherApi(retrofit: Retrofit): WeatherApi =
    retrofit.create()
}
