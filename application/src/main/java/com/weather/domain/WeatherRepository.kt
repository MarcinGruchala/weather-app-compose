package com.weather.domain

import com.weather.network.CurrentWeatherResponse

interface WeatherRepository {

    suspend fun downloadCurrentWeather(location: String): CurrentWeatherResponse
}
