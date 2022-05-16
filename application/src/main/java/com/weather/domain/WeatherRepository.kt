package com.weather.domain

import com.weather.network.model.CurrentWeatherResponse

interface WeatherRepository {

    suspend fun downloadCurrentWeather(location: String): CurrentWeatherResponse
}
