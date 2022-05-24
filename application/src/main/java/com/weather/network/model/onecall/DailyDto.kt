package com.weather.network.model.onecall

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.weather.network.model.common.WeatherDto

@JsonClass(generateAdapter = true)
data class DailyDto(
    @Json(name = "clouds")
    val clouds: Int,
    @Json(name = "dew_point")
    val dewPoint: Double,
    @Json(name = "dt")
    val dayTime: Int,
    @Json(name = "feels_like")
    val feelsLike: FeelsLikeDto,
    @Json(name = "humidity")
    val humidity: Int,
    @Json(name = "moon_phase")
    val moonPhase: Double,
    @Json(name = "moonrise")
    val moonrise: Int,
    @Json(name = "moonset")
    val moonset: Int,
    @Json(name = "pop")
    val pop: Double,
    @Json(name = "pressure")
    val pressure: Int,
    @Json(name = "rain")
    val rain: Double?,
    @Json(name = "sunrise")
    val sunrise: Int,
    @Json(name = "sunset")
    val sunset: Int,
    @Json(name = "temp")
    val temp: TempDto,
    @Json(name = "uvi")
    val uvi: Double,
    @Json(name = "weather")
    val weather: List<WeatherDto>,
    @Json(name = "wind_deg")
    val windDeg: Int,
    @Json(name = "wind_gust")
    val windGust: Double,
    @Json(name = "wind_speed")
    val windSpeed: Double
)