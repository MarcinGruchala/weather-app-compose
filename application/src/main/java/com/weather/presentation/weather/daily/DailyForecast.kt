package com.weather.presentation.weather.daily

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.weather.R
import com.weather.ui.theme.DarkBlue
import com.weather.ui.theme.WeatherTheme

@Composable
fun DailyForecast(dailyForecast: List<DailyForecastModel>) {
    Card(
        modifier = Modifier.padding(6.dp),
        elevation = 4.dp,
        backgroundColor = DarkBlue
    ) {
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(dailyForecast) { item ->
                DailyForecastItem(model = item)
            }
        }
    }
}

@Composable
fun DailyForecastItem(model: DailyForecastModel) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(text = model.day)
        Image(painter = painterResource(id = model.icon), contentDescription = null)
        Text(text = "${model.tempMin} °C")
        Text(text = "${model.tempMax} °C")
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF669FFF)
@Composable
fun DailyForecastPreview() {
    val mockModel = DailyForecastModel(
        day = "Monday",
        icon = R.drawable.rain_day,
        tempMax = 22,
        tempMin = 13
    )
    val mockList = List(7) { mockModel }

    WeatherTheme {
        DailyForecast(dailyForecast = mockList)
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF669FFF)
@Composable
fun DailyForecastItemPreview() {
    val mockModel = DailyForecastModel(
        day = "Monday",
        icon = R.drawable.rain_day,
        tempMax = 22,
        tempMin = 13
    )

    WeatherTheme {
        DailyForecastItem(mockModel)
    }

}
