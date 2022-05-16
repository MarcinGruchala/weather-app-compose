package com.weather.network

import com.weather.network.model.CurrentWeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("weather")
    suspend fun currentWeather(
        @Query("q") city: String,
        @Query("appid") key: String,
        @Query("units") units: String
    ): CurrentWeatherResponse
}
