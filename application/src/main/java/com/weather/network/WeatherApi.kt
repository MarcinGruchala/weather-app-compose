package com.weatherappcomposedemo.network

import com.weatherappcomposedemo.network.model.CurrentWeatherResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

  @GET("weather")
  fun currentWeather(
    @Query("q") city: String,
    @Query("appid") key: String,
    @Query("units") units: String): Single<CurrentWeatherResponse>
}
