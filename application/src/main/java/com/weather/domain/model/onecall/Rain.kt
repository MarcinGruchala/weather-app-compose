package com.weather.domain.model.onecall

import com.weather.network.model.onecall.RainDto

data class Rain(
    val volume: Double
) {
    companion object {
        fun createFrom(dto: RainDto): Rain =
            Rain(
                volume = dto.volume
            )
    }
}