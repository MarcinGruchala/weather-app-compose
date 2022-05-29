package com.weather.presentation.utils

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Ignore
import org.junit.Test


internal class DateTimeFormatterTest {

    private lateinit var timeFormatter: DateTimeFormatter

    @Before
    fun setUp() {
        timeFormatter = DateTimeFormatter()
    }

    @Test
    fun `given timestamp when getHour called then return string`() {
        val hour = timeFormatter.gerHour(1653825388)
        assertThat(hour).isEqualTo("13")
    }

    @Test
    fun `given timestamp when getFullHour called then return string`() {
        val time = timeFormatter.getFullHour(1653825388)
        assertThat(time).isEqualTo("13:56")
    }

    // TODO: fix that test - method returns translated day of thr week only in test class
    @Ignore
    @Test
    fun `given timestamp when getDayOfTheWeek called then return string`() {
        val time = timeFormatter.getDayOfTheWeek(1653850414)
        assertThat(time).isEqualTo("Sunday")
    }
}