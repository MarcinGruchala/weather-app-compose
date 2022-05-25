package com.weather.network.model.onecall

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RainDto(
    @Json(name = "1h")
    val volume: Double
)