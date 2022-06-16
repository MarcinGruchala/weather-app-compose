package com.weather.network

import com.weather.network.model.current.CurrentWeatherResponse
import com.weather.network.model.onecall.OneCallResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkManager @Inject constructor(
    private val api: WeatherApi,
    private val configuration: NetworkConfiguration
) {

    suspend fun downloadCurrentWeather(
        location: String,
        units: String
    ): CurrentWeatherResponse =
        api
            .currentWeather(
                city = location,
                key = configuration.apiKey(),
                units = units
            )

    suspend fun downloadFutureForecast(
        lat: Double,
        lon: Double,
        exclude: String,
        units: String
    ): OneCallResponse =
        api
            .futureForecast(
                lat = lat,
                lon = lon,
                key = configuration.apiKey(),
                exclude = exclude,
                units = units
            )
}
