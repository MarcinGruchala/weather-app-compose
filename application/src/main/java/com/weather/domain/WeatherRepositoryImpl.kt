package com.weather.domain

import com.weather.network.CurrentWeatherResponse
import com.weather.network.NetworkConfiguration
import com.weather.network.WeatherApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi,
    private val configuration: NetworkConfiguration,
) : WeatherRepository {

    override suspend fun downloadCurrentWeather(location: String): CurrentWeatherResponse =
        api
            .currentWeather(
                city = location,
                key = configuration.apiKey(),
                units = "metric"
            )
}
