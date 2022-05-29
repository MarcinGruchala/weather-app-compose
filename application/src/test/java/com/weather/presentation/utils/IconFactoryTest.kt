package com.weather.presentation.utils

import com.weather.R
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test


internal class IconFactoryTest {

    private lateinit var factory: IconFactory

    @Before
    fun setUp() {
        factory = IconFactory()
    }

    @Test
    fun `given clear sky day icon string when get icon called then return proper icon`() {
        val icon = factory.getIcon("01d")
        assertThat(icon).isEqualTo(R.drawable.clear_sky_day)
    }

    @Test
    fun `given clear sky night icon string when get icon called then return proper icon`() {
        val icon = factory.getIcon("01n")
        assertThat(icon).isEqualTo(R.drawable.clear_sky_night)
    }

    @Test
    fun `given few clouds day icon string when get icon called then return proper icon`() {
        val icon = factory.getIcon("02d")
        assertThat(icon).isEqualTo(R.drawable.few_clouds_day)
    }

    @Test
    fun `given few clouds night icon string when get icon called then return proper icon`() {
        val icon = factory.getIcon("02n")
        assertThat(icon).isEqualTo(R.drawable.few_clouds_night)
    }

    @Test
    fun `given scattered clouds day icon string when get icon called then return proper icon`() {
        val icon = factory.getIcon("03d")
        assertThat(icon).isEqualTo(R.drawable.scattered_clouds)
    }

    @Test
    fun `given scattered clouds night icon string when get icon called then return proper icon`() {
        val icon = factory.getIcon("03n")
        assertThat(icon).isEqualTo(R.drawable.scattered_clouds)
    }

    @Test
    fun `given broken clouds icon day string when get icon called then return proper icon`() {
        val icon = factory.getIcon("04d")
        assertThat(icon).isEqualTo(R.drawable.broken_clouds)
    }

    @Test
    fun `given broken clouds icon night string when get icon called then return proper icon`() {
        val icon = factory.getIcon("04n")
        assertThat(icon).isEqualTo(R.drawable.broken_clouds)
    }

    @Test
    fun `given shower rain day icon string when get icon called then return proper icon`() {
        val icon = factory.getIcon("09d")
        assertThat(icon).isEqualTo(R.drawable.shower_rain)
    }

    @Test
    fun `given shower rain night icon string when get icon called then return proper icon`() {
        val icon = factory.getIcon("09n")
        assertThat(icon).isEqualTo(R.drawable.shower_rain)
    }

    @Test
    fun `given rain day icon string when get icon called then return proper icon`() {
        val icon = factory.getIcon("10d")
        assertThat(icon).isEqualTo(R.drawable.rain_day)
    }

    @Test
    fun `given rain night icon string when get icon called then return proper icon`() {
        val icon = factory.getIcon("10n")
        assertThat(icon).isEqualTo(R.drawable.rain_night)
    }

    @Test
    fun `given thunderstorm day icon string when get icon called then return proper icon`() {
        val icon = factory.getIcon("11d")
        assertThat(icon).isEqualTo(R.drawable.thunderstorm)
    }

    @Test
    fun `given thunderstorm night icon string when get icon called then return proper icon`() {
        val icon = factory.getIcon("11n")
        assertThat(icon).isEqualTo(R.drawable.thunderstorm)
    }

    @Test
    fun `given snow day icon string when get icon called then return proper icon`() {
        val icon = factory.getIcon("13d")
        assertThat(icon).isEqualTo(R.drawable.snow)
    }

    @Test
    fun `given snow night icon string when get icon called then return proper icon`() {
        val icon = factory.getIcon("13n")
        assertThat(icon).isEqualTo(R.drawable.snow)
    }

    @Test
    fun `given mist day icon string when get icon called then return proper icon`() {
        val icon = factory.getIcon("50d")
        assertThat(icon).isEqualTo(R.drawable.mist)
    }

    @Test
    fun `given mist night icon string when get icon called then return proper icon`() {
        val icon = factory.getIcon("50n")
        assertThat(icon).isEqualTo(R.drawable.mist)
    }

    @Test
    fun `given unknown string when get icon called then return proper icon`() {
        val icon = factory.getIcon("random string")
        assertThat(icon).isEqualTo(R.drawable.scattered_clouds)
    }
}
