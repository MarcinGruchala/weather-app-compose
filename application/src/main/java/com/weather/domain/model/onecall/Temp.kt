package com.weather.domain.model.onecall

import com.weather.network.model.onecall.TempDto

data class Temp(
    val day: Double,
    val eve: Double,
    val max: Double,
    val min: Double,
    val morn: Double,
    val night: Double
) {
    companion object {
        fun createFrom(dto: TempDto): Temp =
            Temp(
                day = dto.day,
                eve = dto.eve,
                max = dto.max,
                min = dto.min,
                morn = dto.morn,
                night = dto.night
            )
    }
}
