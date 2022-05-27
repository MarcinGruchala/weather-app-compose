package com.weather.presentation.weather.hourly

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.weather.R
import com.weather.ui.theme.WeatherTheme

@Composable
fun HourlyForecast(hourlyForecast: List<HourlyForecastModel>) {
    Card(
        elevation = 4.dp,
        backgroundColor = MaterialTheme.colors.primaryVariant,
        modifier = Modifier.padding(top = 10.dp)
    ) {
        LazyRow(
            contentPadding = PaddingValues(all = 4.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(hourlyForecast) { item ->
                HourlyForecastItem(model = item)
            }
        }
    }
}

@Composable
fun HourlyForecastItem(model: HourlyForecastModel) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = model.time,
            fontSize = 16.sp
        )
        Image(
            painter = painterResource(id = model.icon),
            contentDescription = null
        )
        Text(
            text = "${model.temp} °C",
            fontSize = 16.sp
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF669FFF)
@Composable
fun HourlyForecastPreview() {
    val list = listOf(
        HourlyForecastModel("15 PM", R.drawable.clear_sky_day, "33"),
        HourlyForecastModel("15 PM", R.drawable.clear_sky_day, "33"),
        HourlyForecastModel("15 PM", R.drawable.clear_sky_day, "33"),
        HourlyForecastModel("15 PM", R.drawable.clear_sky_day, "33"),
        HourlyForecastModel("15 PM", R.drawable.clear_sky_day, "33"),
        HourlyForecastModel("15 PM", R.drawable.clear_sky_day, "33"),
        HourlyForecastModel("15 PM", R.drawable.clear_sky_day, "33")

    )

    WeatherTheme {
        HourlyForecast(hourlyForecast = list)
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF669FFF)
@Composable
fun HourlyForecastItemPreview() {
    val model = HourlyForecastModel("15 PM", R.drawable.clear_sky_day, "33")
    WeatherTheme {
        HourlyForecastItem(model = model)
    }
}