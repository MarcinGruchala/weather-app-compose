package com.weather.domain.model.current

import com.weather.network.model.current.CloudsDto

data class Clouds(
    val all: Int
) {
    companion object {
        fun createFrom(dto: CloudsDto): Clouds =
            Clouds(
                all = dto.all
            )
    }
}
