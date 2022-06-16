package com.weather.domain.weather.model.common

import com.weather.domain.weather.model.current.CurrentWeatherModel
import com.weather.domain.weather.model.onecall.OneCallModel

data class WeatherForecast(
    val currentWeather: CurrentWeatherModel,
    val futureForecast: OneCallModel
)
