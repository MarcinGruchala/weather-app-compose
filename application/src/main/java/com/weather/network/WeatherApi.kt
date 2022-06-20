package com.weather.network

import com.weather.network.model.current.CurrentWeatherResponse
import com.weather.network.model.onecall.OneCallResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("weather")
    suspend fun currentWeather(
        @Query("q") city: String,
        @Query("appid") key: String,
        @Query("units") units: String
    ): Response<CurrentWeatherResponse>

    @GET("weather")
    suspend fun currentWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") key: String,
        @Query("units") units: String
    ): Response<CurrentWeatherResponse>

    @GET("onecall")
    suspend fun futureForecast(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") key: String,
        @Query("exclude") exclude: String,
        @Query("units") units: String
    ): Response<OneCallResponse>
}
