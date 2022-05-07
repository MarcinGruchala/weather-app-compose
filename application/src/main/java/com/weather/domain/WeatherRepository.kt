package com.weatherappcomposedemo.domain

import com.weatherappcomposedemo.network.model.CurrentWeatherResponse
import io.reactivex.rxjava3.core.Single

interface WeatherRepository {

  fun downloadCurrentWeather(location: String): Single<CurrentWeatherResponse>
}
