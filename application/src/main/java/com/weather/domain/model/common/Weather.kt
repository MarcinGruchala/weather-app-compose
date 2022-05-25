package com.weather.domain.model.common

import com.weather.network.model.common.WeatherDto

data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
) {
    companion object {
        fun createFrom(dto: WeatherDto): Weather =
            Weather(
                description = dto.description,
                icon = dto.icon,
                id = dto.id,
                main = dto.main
            )
    }
}