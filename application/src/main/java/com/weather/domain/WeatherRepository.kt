package com.weather.domain

import com.weather.domain.model.common.WeatherForecast
import com.weather.network.model.current.CurrentWeatherResponse

interface WeatherRepository {

    suspend fun fetchWeatherForecast(location: String): WeatherForecast

    suspend fun downloadCurrentWeather(location: String): CurrentWeatherResponse
}
