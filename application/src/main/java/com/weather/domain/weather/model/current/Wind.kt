package com.weather.domain.weather.model.current

import com.weather.network.model.current.WindDto

data class Wind(
    val deg: Int,
    val speed: Double
) {
    companion object {
        fun createFrom(dto: WindDto): Wind =
            Wind(
                deg = dto.deg,
                speed = dto.speed
            )
    }
}
