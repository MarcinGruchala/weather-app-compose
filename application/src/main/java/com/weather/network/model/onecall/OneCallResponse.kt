package com.weather.network.model.onecall

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class OneCallResponse(
    @Json(name = "daily")
    val daily: List<DailyDto>,
    @Json(name = "hourly")
    val hourly: List<HourlyDto>,
    @Json(name = "lat")
    val lat: Double,
    @Json(name = "lon")
    val lon: Double,
    @Json(name = "timezone")
    val timezone: String,
    @Json(name = "timezone_offset")
    val timezoneOffset: Int
)

