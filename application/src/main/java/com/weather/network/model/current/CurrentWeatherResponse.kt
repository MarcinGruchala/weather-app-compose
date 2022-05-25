package com.weather.network.model.current

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.weather.network.model.common.WeatherDto

@JsonClass(generateAdapter = true)
data class CurrentWeatherResponse(
  @Json(name = "coord")
  val coordinates: CoordinatesDto,
  @Json(name = "weather")
  val weather: List<WeatherDto>,
  @Json(name = "base")
  val base: String,
  @Json(name = "main")
  val mainForecast: MainForecastDto,
  @Json(name = "visibility")
  val visibility: Int,
  @Json(name = "wind")
  val wind: WindDto,
  @Json(name = "clouds")
  val clouds: CloudsDto,
  @Json(name = "dt")
  val dayTime: Int,
  @Json(name = "sys")
  val sys: SysDto,
  @Json(name = "timezone")
  val timezone: Int,
  @Json(name = "id")
  val id: Int,
  @Json(name = "name")
  val name: String,
  @Json(name = "cod")
  val cod: Int,
)
