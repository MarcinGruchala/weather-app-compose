package com.weather.domain.weather.model.current

import com.weather.network.model.current.SysDto

data class Sys(
    val country: String,
    val id: Int,
    val sunrise: Int,
    val sunset: Int,
    val type: Int
) {
    companion object {
        fun createFrom(dto: SysDto): Sys =
            Sys(
                country = dto.country,
                id = dto.id,
                sunrise = dto.sunrise,
                sunset = dto.sunset,
                type = dto.type
            )
    }
}
