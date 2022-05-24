package com.weather.domain.model.onecall

import com.weather.network.model.onecall.FeelsLikeDto

data class FeelsLike(
    val day: Double,
    val eve: Double,
    val morn: Double,
    val night: Double
) {
    companion object {
        fun createFrom(dto: FeelsLikeDto): FeelsLike =
            FeelsLike(
                day = dto.day,
                eve = dto.eve,
                morn = dto.morn,
                night = dto.night
            )
    }
}