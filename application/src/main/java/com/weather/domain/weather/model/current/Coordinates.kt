package com.weather.domain.weather.model.current

import com.weather.network.model.current.CoordinatesDto

data class Coordinates(
    val lat: Double,
    val lon: Double
) {
    companion object {
        fun createFrom(dto: CoordinatesDto): Coordinates =
            Coordinates(
                lat = dto.lat,
                lon = dto.lon
            )
    }
}
