package com.weather.network

import com.weather.network.model.current.CurrentWeatherResponse
import com.weather.network.model.onecall.OneCallResponse
import retrofit2.Response
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
    ): Response<CurrentWeatherResponse> =
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
    ): Response<OneCallResponse> =
        api
            .futureForecast(
                lat = lat,
                lon = lon,
                key = configuration.apiKey(),
                exclude = exclude,
                units = units
            )
}
