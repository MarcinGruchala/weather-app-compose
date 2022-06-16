package com.weather.domain.weather

import com.weather.domain.weather.model.common.WeatherForecast
import com.weather.network.model.current.CurrentWeatherResponse

interface WeatherRepository {

    suspend fun fetchWeatherForecast(location: String): WeatherForecast

    suspend fun downloadCurrentWeather(location: String): CurrentWeatherResponse
}
