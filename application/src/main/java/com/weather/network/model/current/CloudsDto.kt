package com.weather.network.model.current

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CloudsDto(
    @Json(name = "all")
    val all: Int
)