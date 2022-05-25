package com.weather.domain.model.onecall

import com.weather.network.model.onecall.OneCallResponse

data class OneCallModel(
    val daily: List<Daily>,
    val hourly: List<Hourly>,
    val lat: Double,
    val lon: Double,
    val timezone: String,
    val timezoneOffset: Int
) {
    companion object {
        fun createFrom(dto: OneCallResponse): OneCallModel =
            OneCallModel(
                daily = dto.daily.map(Daily::createFrom),
                hourly = dto.hourly.map(Hourly::createFrom),
                lat = dto.lat,
                lon = dto.lon,
                timezone = dto.timezone,
                timezoneOffset = dto.timezoneOffset
            )
    }
}

