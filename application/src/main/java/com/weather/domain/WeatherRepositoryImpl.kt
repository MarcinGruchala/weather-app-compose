package com.weatherappcomposedemo.domain

import com.weatherappcomposedemo.network.NetworkConfiguration
import com.weatherappcomposedemo.network.WeatherApi
import com.weatherappcomposedemo.network.model.CurrentWeatherResponse
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class WeatherRepositoryImpl @Inject constructor(
  private val api: WeatherApi,
  private val configuration: NetworkConfiguration,
) : WeatherRepository {

  override fun downloadCurrentWeather(location: String): Single<CurrentWeatherResponse> =
    api
      .currentWeather(
        city = location,
        key = configuration.apiKey(),
        units = "metric")

}
